package com.columbusstate.airline.dao;

import com.columbusstate.airline.model.FlightDetails;
import java.util.List;


public interface FlightDetailsDAO {

    public List<FlightDetails> getFlightsBySearchCriteria(String from, String to);
}
