package com.solvd.airport.services.informational.arrival.repo;

import com.solvd.airport.services.informational.arrival.Arrival;
import com.solvd.airport.main.airport.Airport;

import java.time.LocalDateTime;
import java.util.Set;

public interface ArrivalRepository {

    /**
     * Adds arrival in the arrivals repository
     */
    Arrival addArrival(String id, Airport airport, LocalDateTime timeOfArrival);

    /**
     * Adds arrival in the arrivals repository
     */
    Arrival addArrival(Arrival arrival);

    /**
     * Find arrival by airportName
     */
    Arrival findArrivalByAirportName(String airportName);

    /**
     * Updates arrival with the id that is currently present in the arrivals repository
     */
    Set<Arrival> updateArrival(Arrival arrival);

    /**
     * Deletes arrival from the arrivals' repository if it is present
     */
    Set<Arrival> deleteArrival(Arrival arrival);
}
