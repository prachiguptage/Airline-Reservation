package com.columbusstate.airline.service;

import com.columbusstate.airline.model.FlightSearchResult;
import com.columbusstate.airline.model.Search;
import java.util.List;

public interface FlightSearchService {

    public List<FlightSearchResult> searchFlights(Search search);

}
