package com.columbusstate.airline.domain.impl;

import com.columbusstate.airline.domain.Booking;
import com.columbusstate.airline.domain.BookingDetails;
import com.columbusstate.airline.domain.BookingDetailsDecorator;
import com.columbusstate.airline.model.Passenger;
import com.columbusstate.airline.util.AirlinesConstants;

/**
 *
 * @author Prachi Gupta
 */
public class LuggageBookingDetailsDecorator extends BookingDetailsDecorator {

    private final BookingDetails bookingDetails;

    public LuggageBookingDetailsDecorator(BookingDetails bookingDetails) {

        this.bookingDetails = bookingDetails;
    }

    @Override
    public float getThisPassengerCost() {
        return bookingDetails.getThisPassengerCost() + AirlinesConstants.EXTRA_LUGGAGE_PRICE;
    }

    @Override
    public String toString() {
        return "LuggageBookingDetailsDecorator{" + "bookingDetails=" + bookingDetails + '}';
    }

    @Override
    public Booking getBooking() {
        return bookingDetails.getBooking();
    }

    @Override
    public Passenger getPassenger() {
        return bookingDetails.getPassenger();
    }

    @Override
    public char getIsMealSelected() {
        return bookingDetails.getIsMealSelected();
    }

    @Override
    public char getIsExtraLuggageBooked() {
        return 'Y';
    }

}
