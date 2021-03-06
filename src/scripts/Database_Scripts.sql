/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Prachi Gupta
 * Created: May 7, 2017
 */

create database airline;

use airline;

create table Flight_Details(flight_id VARCHAR(100) NOT NULL, FLIGHT_NAME VARCHAR(100), AIRLINES_NAME VARCHAR(100), FROM_LOCATION VARCHAR(100), TO_LOCATION VARCHAR(100), DEPARTURE_TIME VARCHAR(30), DAYS_OF_WEEK VARCHAR(20), FLIGHT_DURATION INT, PRICE_PER_SEAT FLOAT);


INSERT INTO Flight_Details ( flight_id, FLIGHT_NAME , AIRLINES_NAME , FROM_LOCATION, TO_LOCATION , DEPARTURE_TIME , DAYS_OF_WEEK , FLIGHT_DURATION, PRICE_PER_SEAT) VALUES( "DL01", "Delta 01", "DELTA AIRLINES", "SAN FRANCISCO", "NEW YORK", "14:00", "1,2,3,4,5", "7", "200");

INSERT INTO Flight_Details( flight_id, FLIGHT_NAME , AIRLINES_NAME , FROM_LOCATION, TO_LOCATION , DEPARTURE_TIME , DAYS_OF_WEEK , FLIGHT_DURATION, PRICE_PER_SEAT) VALUES("DL02","Delta 02","DELTA AIRLINES","NEW YORK","SAN FRANCISCO","20:00","1,2,3,4,5","7","200");

INSERT INTO Flight_Details ( flight_id, FLIGHT_NAME , AIRLINES_NAME , FROM_LOCATION, TO_LOCATION , DEPARTURE_TIME , DAYS_OF_WEEK , FLIGHT_DURATION, PRICE_PER_SEAT) VALUES( "SG01", "Flight 01", "SINGAPORE AIRLINES", "SAN FRANCISCO", "COLUMBUS", "15:00", "1,3,5", "5", "150");

INSERT INTO Flight_Details ( flight_id, FLIGHT_NAME , AIRLINES_NAME , FROM_LOCATION, TO_LOCATION , DEPARTURE_TIME , DAYS_OF_WEEK , FLIGHT_DURATION, PRICE_PER_SEAT) VALUES( "SG02”, “SG Airlines Flight 02", "SINGAPORE AIRLINES", "COLUMBUS", "SAN FRANCISCO", "21:00", "1,3,5", "5", "150");


create table PASSENGER(PASSENGER_ID INT NOT NULL AUTO_INCREMENT, 
FIRST_NAME VARCHAR(100), LAST_NAME VARCHAR(100), GENDER CHAR, 
DATE_OF_BIRTH DATE,  PASSPORT_NUMBER VARCHAR (50),  PRIMARY KEY ( PASSENGER_ID ));


create table BOOKING(BOOKING_ID INT NOT NULL AUTO_INCREMENT,
DEPARTURE_DATE DATE, RETURN_DATE DATE, DEPARTURE_FLIGHT VARCHAR(100), RETURN_FLIGHT_ID VARCHAR(100), PRICE INT,  BOOKING_STATUS VARCHAR(20), PRIMARY KEY(BOOKING_ID));

create table BOOKING_DETAILS(BOOKING_DETAILS_ID INT NOT NULL AUTO_INCREMENT, BOOKING_ID INT,  FOREIGN KEY (BOOKING_ID) REFERENCES BOOKING(BOOKING_ID), PASSENGER_ID INT, FOREIGN KEY (PASSENGER_ID) REFERENCES PASSENGER(PASSENGER_ID) ,EXTRA_BAGGAGE_SELECTED CHAR, MEALS_SELECTED CHAR, SEAT_SELECTED VARCHAR(20), PRIMARY KEY(BOOKING_DETAILS_ID));
