package com.columbusstate.airline.dao;

import com.columbusstate.airline.domain.Booking;
import com.columbusstate.airline.domain.BookingDetails;


public interface BookingDAO {

    public String bookFlight(Booking Booking);

    public String createBookingDetails(BookingDetails bookingDetails);

}
