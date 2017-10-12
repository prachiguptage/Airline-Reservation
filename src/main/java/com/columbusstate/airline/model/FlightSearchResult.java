package com.columbusstate.airline.model;

/**
 *
 * @author Prachi Gupta
 */
public class FlightSearchResult {

    private int flightSearchResultId;
    private FlightDetails departureFlightDetails;
    private FlightDetails returnFlightDetails;
    private boolean isFlightSelected;

    public boolean isIsFlightSelected() {
        return isFlightSelected;
    }

    public void setIsFlightSelected(boolean isFlightSelected) {
        this.isFlightSelected = isFlightSelected;
    }

    public int getFlightSearchResultId() {
        return flightSearchResultId;
    }

    public void setFlightSearchResultId(int flightSearchResultId) {
        this.flightSearchResultId = flightSearchResultId;
    }

    public FlightDetails getDepartureFlightDetails() {
        return departureFlightDetails;
    }

    public void setDepartureFlightDetails(FlightDetails departureFlightDetails) {
        this.departureFlightDetails = departureFlightDetails;
    }

    public FlightDetails getReturnFlightDetails() {
        return returnFlightDetails;
    }

    public void setReturnFlightDetails(FlightDetails returnFlightDetails) {
        this.returnFlightDetails = returnFlightDetails;
    }

    @Override
    public String toString() {
        return "FlightSearchResult{" + "flightSearchResultId=" + flightSearchResultId + ", departureFlightDetails=" + departureFlightDetails + ", returnFlightDetails=" + returnFlightDetails + ", isFlightSelected=" + isFlightSelected + '}';
    }

}
