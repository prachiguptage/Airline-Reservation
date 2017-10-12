package com.columbusstate.airline.domain.impl;

import com.columbusstate.airline.domain.Booking;
import com.columbusstate.airline.domain.BookingDetails;
import com.columbusstate.airline.model.Passenger;

/**
 *
 * @author Prachi Gupta
 */
public class RegularBookingDetails extends BookingDetails {

    private Booking booking;
    private Passenger passenger;
    private char isMealSelected = 'N';
    private char isExtraLuggageBooked = 'N';

    @Override
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public char getIsMealSelected() {
        return isMealSelected;
    }

    public void setIsMealSelected(char isMealSelected) {
        this.isMealSelected = isMealSelected;
    }

    @Override
    public char getIsExtraLuggageBooked() {
        return isExtraLuggageBooked;
    }

    public void setIsExtraLuggageBooked(char isExtraLuggageBooked) {
        this.isExtraLuggageBooked = isExtraLuggageBooked;
    }

    @Override
    public float getThisPassengerCost() {

        float thisPassengerCost = ((BookingImpl) booking).getReturnFlight() != null ? ((BookingImpl) booking).getDepartureFlight().getFlightPrice()
                + ((BookingImpl) booking).getReturnFlight().getFlightPrice() : ((BookingImpl) booking).getDepartureFlight().getFlightPrice();
        return thisPassengerCost;
    }

    @Override
    public String toString() {
        return "RegularBookingDetails{" + "passenger=" + passenger + ", isMealSelected=" + isMealSelected + ", isExtraLuggageBooked=" + isExtraLuggageBooked + '}';
    }

}
