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
public class MealBookingDetailsDecorator extends BookingDetailsDecorator {

    private final BookingDetails bookingDetails;

    public MealBookingDetailsDecorator(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    @Override
    public float getThisPassengerCost() {

        return bookingDetails.getThisPassengerCost() + AirlinesConstants.MEAL_PRICE;
    }

    @Override
    public String toString() {
        return "MealBookingDetailsDecorator{" + "bookingDetails=" + bookingDetails + '}';
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
        return 'Y';
    }

    @Override
    public char getIsExtraLuggageBooked() {
        return bookingDetails.getIsExtraLuggageBooked();
    }

}
