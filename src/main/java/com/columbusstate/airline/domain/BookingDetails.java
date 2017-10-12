package com.columbusstate.airline.domain;

import com.columbusstate.airline.model.Passenger;

/**
 *
 * @author Prachi Gupta
 */
public abstract class BookingDetails {

    public abstract float getThisPassengerCost();

    public abstract Booking getBooking();

    public abstract Passenger getPassenger();

    public abstract char getIsMealSelected();

    public abstract char getIsExtraLuggageBooked();

}
