package com.columbusstate.airline.domain.impl;

import com.columbusstate.airline.domain.Booking;
import com.columbusstate.airline.domain.BookingDetails;
import com.columbusstate.airline.model.FlightDetails;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Prachi Gupta
 */
public class BookingImpl implements Booking {

    private String bookingRefNo;
    private List<BookingDetails> bookingDetails;
    private Date departureDate;
    private Date returnDate;
    private FlightDetails departureFlight;
    private FlightDetails returnFlight;
    private String bookingStatus;
    private float totalPrice;

    public String getBookingRefNo() {
        return bookingRefNo;
    }

    public void setBookingRefNo(String bookingRefNo) {
        this.bookingRefNo = bookingRefNo;
    }

    public List<BookingDetails> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetails> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public FlightDetails getDepartureFlight() {
        return departureFlight;
    }

    public void setDepartureFlight(FlightDetails departureFlight) {
        this.departureFlight = departureFlight;
    }

    public FlightDetails getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(FlightDetails returnFlight) {
        this.returnFlight = returnFlight;
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

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public float getTotalPrice() {

        float totalPriceLocal = 0.0f;

        for (BookingDetails bookingDetailsVal : this.bookingDetails) {
            totalPriceLocal = totalPriceLocal + bookingDetailsVal.getThisPassengerCost();
        }
        setTotalPrice(totalPriceLocal);
        return totalPriceLocal;
    }

    public void setTotalPrice(float totalPrice) {

        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "RegularBooking{" + "bookingRefNo=" + bookingRefNo + ", bookingDetails=" + bookingDetails + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", departureFlight=" + departureFlight + ", returnFlight=" + returnFlight + ", bookingStatus=" + bookingStatus + ", totalPrice=" + totalPrice + '}';
    }

}
