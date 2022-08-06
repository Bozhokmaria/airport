package com.solvd.airport.services.airline.repo;

import com.solvd.airport.services.airline.Airline;
import com.solvd.airport.services.flight.Flight;

import java.util.List;
import java.util.Set;

public interface AirlineRepository {

    /**
     * Adds airline to the airlines repository
     */
    Airline addAirline(String id, String name, List<Flight> flights);

    /**
     * Adds airline to the airlines repository
     */
    Airline addAirline(Airline airline);

    /**
     * Finds airline by id
     */
    Airline findAirlineById(String id);


    /**
     * Updates airline with the id that is currently present in the airlines repository
     */
    Set<Airline> updateAirline(Airline airline);

    /**
     * Deletes airline from the airlines` repository if it is present
     */
    Set<Airline> deleteAirline(Airline airline);
}
