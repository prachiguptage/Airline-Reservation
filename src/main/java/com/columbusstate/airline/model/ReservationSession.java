package com.columbusstate.airline.model;

public class ReservationSession {

    private Search search;
    private SearchResults searchResults;
    private FlightSearchResult selectedFlightSearchResult;
    private ReservationDetails reservationDetails;

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    public ReservationDetails getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(ReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    public FlightSearchResult getSelectedFlightSearchResult() {
        return selectedFlightSearchResult;
    }

    public void setSelectedFlightSearchResult(FlightSearchResult selectedFlightSearchResult) {
        this.selectedFlightSearchResult = selectedFlightSearchResult;
    }

    @Override
    public String toString() {
        return "ReservationSession{" + "search=" + search + ", searchResults=" + searchResults + ", selectedFlightSearchResult=" + selectedFlightSearchResult + ", reservationDetails=" + reservationDetails + '}';
    }

}
