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
     * Find flight by departure city name
     */
    List <Flight> findFlightByDepartureCity(String city);

    /**
     * Find flight by arrival city name
     */
    public List<Flight> findFlightByArrivalCity(String city);

    /**
     * Deletes flight from the flight' repository if it is present
     */
    List<Flight> deleteFlight(Flight flight);
}
