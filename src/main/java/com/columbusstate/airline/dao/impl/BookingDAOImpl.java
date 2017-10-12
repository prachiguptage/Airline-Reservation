package com.columbusstate.airline.dao.impl;

import com.columbusstate.airline.dao.BookingDAO;
import com.columbusstate.airline.domain.Booking;
import com.columbusstate.airline.domain.BookingDetails;
import com.columbusstate.airline.domain.impl.BookingImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prachi Gupta
 */
@Repository(value = "bookingDAO")
public class BookingDAOImpl implements BookingDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String bookFlight(Booking booking) {
        String bookingRef = createBooking(booking);
        ((BookingImpl) booking).setBookingRefNo(bookingRef);

        return bookingRef;
    }

    private String createBooking(final Booking booking) {

        final String sql = "insert into BOOKING (DEPARTURE_DATE, RETURN_DATE, DEPARTURE_FLIGHT, RETURN_FLIGHT_ID, PRICE, BOOKING_STATUS) values (?,?,?,?,?,?)";
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setDate(1, new java.sql.Date(((BookingImpl) booking).getDepartureDate().getTime()));
                statement.setDate(2, ((BookingImpl) booking).getReturnDate() != null
                        ? new java.sql.Date(((BookingImpl) booking).getReturnDate().getTime()) : null);
                statement.setString(3, ((BookingImpl) booking).getDepartureFlight() != null ? ((BookingImpl) booking).getDepartureFlight().getFlightId() : null);
                statement.setString(4, ((BookingImpl) booking).getReturnFlight() != null ? ((BookingImpl) booking).getReturnFlight().getFlightId() : null);
                statement.setFloat(5, booking.getTotalPrice());
                statement.setString(6, ((BookingImpl) booking).getBookingStatus());
                return statement;
            }
        }, holder);

        long primaryKey = holder.getKey().longValue();
        System.out.println("Booking Id --> " + primaryKey);
        return Long.toString(primaryKey);
    }

    @Override
    public String createBookingDetails(final BookingDetails bookingDetails) {

        System.out.println("bookingDetails -> " + bookingDetails);
        final String sql = "insert into BOOKING_DETAILS (BOOKING_ID, PASSENGER_ID, EXTRA_BAGGAGE_SELECTED, MEALS_SELECTED) values (?,?,?,?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, ((BookingImpl) bookingDetails.getBooking()).getBookingRefNo());
                statement.setString(2, bookingDetails.getPassenger().getId());
                statement.setString(3, String.valueOf(bookingDetails.getIsExtraLuggageBooked()));
                statement.setString(4, String.valueOf(bookingDetails.getIsMealSelected()));
                return statement;
            }
        }, holder);

        long primaryKey = holder.getKey().longValue();
        System.out.println("Booking details Id --> " + primaryKey);
        return Long.toString(primaryKey);
    }

}
