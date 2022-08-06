package com.solvd.airport.services.flight.repo;

import com.solvd.airport.services.flight.Flight;

import java.util.List;

public interface FlightRepository {

    /**
     * Adds flight to the flights repository
     */
    Flight addFlight(Flight flight);

    /**
     * Find flight by flight id
     */
    Flight findFlightByFlightId(String flightId);

    /**
     * Find flight by departure country name
     */
    List <Flight> findFlightByDepartureCountryName(String country);

    /**
     * Deletes flight from the flight' repository if it is present
     */
    List<Flight> deleteFlight(Flight flight);
}
