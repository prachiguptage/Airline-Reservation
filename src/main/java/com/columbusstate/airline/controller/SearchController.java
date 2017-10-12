package com.columbusstate.airline.controller;

import com.columbusstate.airline.model.FlightSearchResult;
import com.columbusstate.airline.model.ReservationSession;
import com.columbusstate.airline.model.Search;
import com.columbusstate.airline.model.SearchResults;
import com.columbusstate.airline.service.FlightSearchService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @Autowired
    @Qualifier(value = "flightSearchImpl")
    private FlightSearchService flightSearchService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute("search") Search search, HttpServletRequest request) {

        System.out.println("Searching flights for criteria -> " + search);
        ReservationSession reservationSession = (ReservationSession) request.getSession().getAttribute("reservationSession");
        List<FlightSearchResult> searchedFlights = flightSearchService.searchFlights(search);

        SearchResults searchResults = new SearchResults();
        searchResults.setSearchedFlights(searchedFlights);
        reservationSession.setSearchResults(searchResults);
        reservationSession.setSearch(search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchResults");
        modelAndView.addObject("searchResults", searchResults);
        request.getSession().setAttribute("reservationSession", reservationSession);
        return modelAndView;

    }

}
