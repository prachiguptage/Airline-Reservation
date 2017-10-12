package com.columbusstate.airline.model;

/**
 *
 * @author Prachi Gupta
 */
public class FlightDetails {

    private String flightId;
    private String flightAndAirlineName;
    private String from;
    private String to;
    private String flightTime;
    private int flightDuration;
    private float flightPrice;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightAndAirlineName() {
        return flightAndAirlineName;
    }

    public void setFlightAndAirlineName(String flightAndAirlineName) {
        this.flightAndAirlineName = flightAndAirlineName;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public float getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(float flightPrice) {
        this.flightPrice = flightPrice;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "FlightDetails{" + "flightId=" + flightId + ", flightAndAirlineName=" + flightAndAirlineName + ", from=" + from + ", to=" + to + ", flightTime=" + flightTime + ", flightDuration=" + flightDuration + ", flightPrice=" + flightPrice + '}';
    }

}
