package com.columbusstate.airline.model;

import java.util.List;

public class ReservationDetails {

    private FlightSearchResult selectedFlight;
    private List<Passenger> passengers;

    //total cost
    private float totalPrice;
    private String bookingReferenceNumber;

    public FlightSearchResult getSelectedFlight() {
        return selectedFlight;
    }

    public void setSelectedFlight(FlightSearchResult selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingReferenceNumber() {
        return bookingReferenceNumber;
    }

    public void setBookingReferenceNumber(String bookingReferenceNumber) {
        this.bookingReferenceNumber = bookingReferenceNumber;
    }

    @Override
    public String toString() {
        return "ReservationDetails{" + "selectedFlight=" + selectedFlight + ", passengers=" + passengers + ", totalPrice=" + totalPrice + ", bookingReferenceNumber=" + bookingReferenceNumber + '}';
    }

}
