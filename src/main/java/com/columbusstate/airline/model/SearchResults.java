package com.columbusstate.airline.model;

import java.util.List;

public class SearchResults {

    private List<FlightSearchResult> searchedFlights;
    private int selectedSearchResult;

    public int getSelectedSearchResult() {
        return selectedSearchResult;
    }

    public void setSelectedSearchResult(int selectedSearchResult) {
        this.selectedSearchResult = selectedSearchResult;
    }

    public List<FlightSearchResult> getSearchedFlights() {
        return searchedFlights;
    }

    public void setSearchedFlights(List<FlightSearchResult> searchedFlights) {
        this.searchedFlights = searchedFlights;
    }

    @Override
    public String toString() {
        return "SearchResults{" + "searchedFlights=" + searchedFlights + ", selectedSearchResult=" + selectedSearchResult + '}';
    }

}
