package com.columbusstate.airline.model;

import java.util.Date;

public class Search {

    private String flyingFrom;
    private String flyingTo;
    private Date departureDate;
    private Date returnDate;
    private int numberOfAdults;
    private int numberOfChild;
    private boolean isTwoWay;

    public String getFlyingFrom() {
        return flyingFrom;
    }

    public void setFlyingFrom(String flyingFrom) {
        this.flyingFrom = flyingFrom;
    }

    public String getFlyingTo() {
        return flyingTo;
    }

    public void setFlyingTo(String flyingTo) {
        this.flyingTo = flyingTo;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChild() {
        return numberOfChild;
    }

    public void setNumberOfChild(int numberOfChild) {
        this.numberOfChild = numberOfChild;
    }

    public boolean isIsTwoWay() {
        return isTwoWay;
    }

    public void setIsTwoWay(boolean isTwoWay) {
        this.isTwoWay = isTwoWay;
    }

    @Override
    public String toString() {
        return "Search{" + "flyingFrom=" + flyingFrom + ", flyingTo=" + flyingTo + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", numberOfAdults=" + numberOfAdults + ", numberOfChild=" + numberOfChild + ", isTwoWay=" + isTwoWay + '}';
    }

}
