package com.columbusstate.airline.controller;

import com.columbusstate.airline.domain.Booking;
import com.columbusstate.airline.domain.BookingDetails;
import com.columbusstate.airline.domain.impl.BookingImpl;
import com.columbusstate.airline.domain.impl.LuggageBookingDetailsDecorator;
import com.columbusstate.airline.domain.impl.MealBookingDetailsDecorator;
import com.columbusstate.airline.domain.impl.RegularBookingDetails;
import com.columbusstate.airline.model.FlightSearchResult;
import com.columbusstate.airline.model.Passenger;
import com.columbusstate.airline.model.ReservationDetails;
import com.columbusstate.airline.model.ReservationSession;
import com.columbusstate.airline.service.ReservationService;
import com.columbusstate.airline.util.AirlinesConstants;
import java.util.ArrayList;
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
public class ConfirmationController {

    @Autowired
    @Qualifier(value = "reservationServiceImpl")
    ReservationService reservationService;

    @RequestMapping(value = "/flightCheckout", method = RequestMethod.POST)
    public ModelAndView flightCheckout(@ModelAttribute("reservationDetails") ReservationDetails reservationDetails,
            HttpServletRequest request) {

        ReservationSession reservationSession = (ReservationSession) request.getSession().getAttribute("reservationSession");
        FlightSearchResult selectedFlights = reservationSession.getReservationDetails().getSelectedFlight();
        reservationDetails.setSelectedFlight(selectedFlights);
        reservationSession.setReservationDetails(reservationDetails);

        Booking booking = convertViewModelToDomain(reservationSession);

        String bookingConfirmationNumber = reservationService.bookFlight(booking);
        reservationDetails.setBookingReferenceNumber(bookingConfirmationNumber);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirmation");
        modelAndView.addObject("reservationDetails", reservationDetails);
        return modelAndView;

    }

    private Booking convertViewModelToDomain(ReservationSession reservationSession) {

        Booking booking = new BookingImpl();
        BookingDetails details = null;
        List<BookingDetails> bookingDetailsList = new ArrayList<BookingDetails>();
        for (Passenger passenger : reservationSession.getReservationDetails().getPassengers()) {
            details = new RegularBookingDetails();
            ((RegularBookingDetails) details).setPassenger(passenger);
            ((RegularBookingDetails) details).setBooking(booking);

            if (passenger.isExtraLuggageAdded()) {

                details = new LuggageBookingDetailsDecorator(details);

            }

            if (passenger.isMealAdded()) {

                details = new MealBookingDetailsDecorator(details);

            }

            bookingDetailsList.add(details);
        }
        ((BookingImpl) booking).setBookingDetails(bookingDetailsList);
        ((BookingImpl) booking).setDepartureFlight(reservationSession.getReservationDetails().getSelectedFlight().getDepartureFlightDetails());
        ((BookingImpl) booking).setReturnFlight(reservationSession.getReservationDetails().getSelectedFlight().getReturnFlightDetails());
        ((BookingImpl) booking).setDepartureDate(reservationSession.getSearch().getDepartureDate());
        ((BookingImpl) booking).setReturnDate(reservationSession.getSearch().getReturnDate());
        ((BookingImpl) booking).setBookingStatus(AirlinesConstants.CONFIRMED);

        System.out.println("Booking --> " + booking);
        System.out.println("Total Price -----------------> " + booking.getTotalPrice());
        return booking;
    }

    @RequestMapping(value = "/bookAnother", method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;

    }

}
