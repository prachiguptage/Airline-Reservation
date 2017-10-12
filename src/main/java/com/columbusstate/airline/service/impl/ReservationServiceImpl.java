package com.columbusstate.airline.service.impl;

import com.columbusstate.airline.dao.BookingDAO;
import com.columbusstate.airline.dao.PassengerDAO;
import com.columbusstate.airline.domain.Booking;
import com.columbusstate.airline.domain.BookingDetails;
import com.columbusstate.airline.domain.impl.BookingImpl;
import com.columbusstate.airline.model.Passenger;
import com.columbusstate.airline.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prachi Gupta
 */
@Service(value = "reservationServiceImpl")
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    @Qualifier(value = "bookingDAO")
    BookingDAO bookingDAO;

    @Autowired
    @Qualifier(value = "passengerDAO")
    PassengerDAO passengerDAO;

    @Override
    public String bookFlight(Booking booking) {
        String bookingRef = bookingDAO.bookFlight(booking);
        ((BookingImpl) booking).setBookingRefNo(bookingRef);

        //Save Passengers
        for (BookingDetails bookingDetails : ((BookingImpl) booking).getBookingDetails()) {
            Passenger passenger = bookingDetails.getPassenger();
            passenger.setId(passengerDAO.savePassengerDetails(passenger));
            bookingDAO.createBookingDetails(bookingDetails);
        }

        return bookingRef;

    }

}
