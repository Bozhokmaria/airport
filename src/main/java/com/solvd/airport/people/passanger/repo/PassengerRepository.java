package com.solvd.airport.people.passanger.repo;

import com.solvd.airport.people.passanger.Passenger;

import java.util.List;
import java.util.Set;

public interface PassengerRepository {

    /**
     * Adds passenger to the passengers repository
     */
    Passenger addPassenger(Passenger passenger);

    /**
     * Finds passenger by passenger`s id
     */
    Passenger findPassengerById(String id);

    /**
     * Finds passenger by passenger`s full name
     * */
    List<Passenger> findPassengerByFullName(String name, String lastName);

    /**
     * Deletes passenger from the passengers' repository if it is present
     */
    Set<Passenger> deletePassenger(Passenger passenger);
}
