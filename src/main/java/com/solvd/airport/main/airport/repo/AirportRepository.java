package com.solvd.airport.main.airport.repo;

import com.solvd.airport.main.airport.Airport;

import java.util.Set;

public interface AirportRepository {
    /**
     * Adds airport to the Airports repository
     */
    Airport addAirport(Airport airport);

    /**
     * Deletes airport from the airports' repository if it is present
     */
    Set<Airport> deleteAirport(Airport airport);

    /**
     * Find airport by name
     */
    Airport findAirportByName(String name);
}
