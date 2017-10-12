package com.columbusstate.airline.model;

import java.util.Date;

public class Passenger {

    private String id;
    private String firstName;
    private String lastName;
    private char gender;
    private Date dateOfBirth;
    private String passportNo;
    private boolean isAdult;

    //
    private boolean mealAdded;
    private boolean extraLuggageAdded;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isIsAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isMealAdded() {
        return mealAdded;
    }

    public void setMealAdded(boolean mealAdded) {
        this.mealAdded = mealAdded;
    }

    public boolean isExtraLuggageAdded() {
        return extraLuggageAdded;
    }

    public void setExtraLuggageAdded(boolean extraLuggageAdded) {
        this.extraLuggageAdded = extraLuggageAdded;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    @Override
    public String toString() {
        return "Passenger{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", passportNo=" + passportNo + ", isAdult=" + isAdult + ", mealAdded=" + mealAdded + ", extraLuggageAdded=" + extraLuggageAdded + '}';
    }

}
