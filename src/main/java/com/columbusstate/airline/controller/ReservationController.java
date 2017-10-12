package com.columbusstate.airline.controller;

import com.columbusstate.airline.model.FlightSearchResult;
import com.columbusstate.airline.model.Passenger;
import com.columbusstate.airline.model.ReservationDetails;
import com.columbusstate.airline.model.ReservationSession;
import com.columbusstate.airline.model.SearchResults;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

    @RequestMapping(value = "/selectFlight", method = RequestMethod.POST)
    public ModelAndView selectFlight(@ModelAttribute("searchResults") SearchResults searchResults,
            HttpServletRequest request) {

        System.out.println("Selected Flight-> " + searchResults);
        ReservationSession reservationSession = (ReservationSession) request.getSession().getAttribute("reservationSession");
        System.out.println("reservationSession --> " + reservationSession);

        SearchResults searchResultFromSession = reservationSession.getSearchResults();
        if (searchResults.getSelectedSearchResult() == 0 && searchResultFromSession.getSearchedFlights().isEmpty()) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/");
            return modelAndView;

        }

        for (FlightSearchResult flightSearchResult : searchResultFromSession.getSearchedFlights()) {
            if (flightSearchResult.getFlightSearchResultId() == searchResults.getSelectedSearchResult()) {

                reservationSession.setSelectedFlightSearchResult(flightSearchResult);

            }
        }

        ReservationDetails reservationDetails = new ReservationDetails();
        reservationDetails.setSelectedFlight(reservationSession.getSelectedFlightSearchResult());
        //reservationSession 
        Passenger passenger = null;
        List<Passenger> passengerList = new ArrayList<Passenger>();
        for (int i = 0; i < reservationSession.getSearch().getNumberOfAdults(); i++) {

            passenger = new Passenger();
            passenger.setIsAdult(true);
            passengerList.add(passenger);

        }

        for (int i = 0; i < reservationSession.getSearch().getNumberOfChild(); i++) {

            passenger = new Passenger();
            passenger.setIsAdult(false);
            passengerList.add(passenger);

        }

        reservationDetails.setPassengers(passengerList);
        System.out.println("Number of Passengers travelling :" + reservationDetails.getPassengers().size());
        reservationSession.setReservationDetails(reservationDetails);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reservationDetails");
        modelAndView.addObject("reservationDetails", reservationDetails);
        System.out.println("reservationSession after flight selection--> " + reservationSession);
        return modelAndView;

    }

}
