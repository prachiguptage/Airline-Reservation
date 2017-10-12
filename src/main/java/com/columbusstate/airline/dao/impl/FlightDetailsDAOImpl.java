package com.columbusstate.airline.dao.impl;

import com.columbusstate.airline.dao.FlightDetailsDAO;
import com.columbusstate.airline.model.FlightDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prachi Gupta
 */
@Repository(value = "flightDetailsDAO")
public class FlightDetailsDAOImpl implements FlightDetailsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<FlightDetails> getFlightsBySearchCriteria(String from, String to) {

        System.out.println("***********************************");

        List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();

        String sql = "select * from flight_details where FROM_LOCATION = ? and TO_LOCATION =?";
        //jdbcTemplate.query
        FlightDetails flightDetails = null;
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, from, to);
        for (Iterator iterator = result.iterator(); iterator.hasNext();) {
            Map<String, Object> rowMap = (Map<String, Object>) iterator.next();
            flightDetails = new FlightDetails();
            flightDetails.setFlightId((String) rowMap.get("flight_id"));
            flightDetails.setFlightAndAirlineName((String) rowMap.get("FLIGHT_NAME"));
            flightDetails.setFlightAndAirlineName((String) rowMap.get("AIRLINES_NAME"));
            flightDetails.setFrom((String) rowMap.get("FROM_LOCATION"));
            flightDetails.setTo((String) rowMap.get("TO_LOCATION"));
            flightDetails.setFlightTime((String) rowMap.get("DEPARTURE_TIME"));
            flightDetails.setFlightDuration((Integer) rowMap.get("FLIGHT_DURATION"));
            flightDetails.setFlightPrice((Float) rowMap.get("PRICE_PER_SEAT"));
            flightDetailsList.add(flightDetails);
        }
        return flightDetailsList;
    }

}
