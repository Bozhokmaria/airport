package com.solvd.airport.services.informational.departure.repo;

import com.solvd.airport.services.informational.departure.Departure;
import com.solvd.airport.main.airport.Airport;

import java.time.LocalDateTime;
import java.util.Set;

public interface DepartureRepository {
    /**
     * Adds departure to the departures repository
     */
    Departure addDeparture(String id, Airport airport, LocalDateTime timeOfDeparture);

    /**
     * Adds departure to the departures repository
     */
    Departure addDeparture(Departure departure);

    /**
     * Updates departure with the id that is currently present in the departures repository
     */
    Set<Departure> updateDeparture(Departure departure);

    /**
     * Find departure by airport name
     */
    Departure findDepartureByAirportName(String airportName);

    /**
     * Deletes departure from the departures' repository if it is present
     */
    Set<Departure> deleteDeparture(Departure departure);
}
