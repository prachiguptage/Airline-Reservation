package com.columbusstate.airline.dao.impl;

import com.columbusstate.airline.dao.PassengerDAO;
import com.columbusstate.airline.model.Passenger;
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
@Repository(value = "passengerDAO")
public class PassengerDAOImpl implements PassengerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String savePassengerDetails(final Passenger passenger) {

        System.out.println("Passenger -> " + passenger);
        final String sql = "insert into PASSENGER (FIRST_NAME, LAST_NAME, GENDER, DATE_OF_BIRTH, PASSPORT_NUMBER) values (?,?,?,?,?)";
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, passenger.getFirstName());
                statement.setString(2, passenger.getLastName());
                statement.setString(3, String.valueOf(passenger.getGender()));
                statement.setDate(4, new java.sql.Date(passenger.getDateOfBirth().getTime()));
                statement.setString(5, passenger.getPassportNo());
                return statement;
            }
        }, holder);

        long primaryKey = holder.getKey().longValue();
        System.out.println("Passenger Id --> " + primaryKey);
        return String.valueOf(primaryKey);

    }
}
