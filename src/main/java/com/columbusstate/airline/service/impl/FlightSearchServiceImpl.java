package com.columbusstate.airline.service.impl;

import com.columbusstate.airline.dao.FlightDetailsDAO;
import com.columbusstate.airline.model.FlightDetails;
import com.columbusstate.airline.model.FlightSearchResult;
import com.columbusstate.airline.model.Search;
import com.columbusstate.airline.service.FlightSearchService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prachi Gupta
 */
@Service(value = "flightSearchImpl")
public class FlightSearchServiceImpl implements FlightSearchService {

    @Autowired
    @Qualifier(value = "flightDetailsDAO")
    FlightDetailsDAO flightDetailsDAO;

    public List<FlightSearchResult> searchFlights(Search search) {

        List<FlightSearchResult> searchResults = new ArrayList<FlightSearchResult>();
        List<FlightDetails> returnFlights = null;

        List<FlightDetails> departureFlights = flightDetailsDAO.getFlightsBySearchCriteria(search.getFlyingFrom(), search.getFlyingTo());
        if (search.isIsTwoWay()) {

            returnFlights = flightDetailsDAO.getFlightsBySearchCriteria(search.getFlyingTo(), search.getFlyingFrom());
        } else {

            search.setReturnDate(null);

        }

        FlightSearchResult flightSearchResult = null;
        int i = 1;
        for (FlightDetails departingFlightDetails : departureFlights) {
            if (returnFlights != null && !returnFlights.isEmpty()) {
                for (FlightDetails returnFlight : returnFlights) {
                    flightSearchResult = new FlightSearchResult();
                    flightSearchResult.setFlightSearchResultId(i);
                    flightSearchResult.setDepartureFlightDetails(departingFlightDetails);
                    flightSearchResult.setReturnFlightDetails(returnFlight);
                    searchResults.add(flightSearchResult);
                    i++;

                }
            } else {
                flightSearchResult = new FlightSearchResult();
                flightSearchResult.setFlightSearchResultId(i);
                flightSearchResult.setDepartureFlightDetails(departingFlightDetails);
                searchResults.add(flightSearchResult);
                i++;
            }
        }

        return searchResults;

    }

}
