package com.solvd.airport.services.flight.repo;

import com.solvd.airport.services.flight.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightRepositoryImpl implements FlightRepository {
    private List<Flight> flights = new ArrayList<>();

    private static final FlightRepositoryImpl FLIGHT_REPOSITORY = new FlightRepositoryImpl();

    private FlightRepositoryImpl() {
    }

    public static FlightRepositoryImpl getFlightRepositoryImpl() {
        return FLIGHT_REPOSITORY;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    @Override
    public Flight addFlight(Flight flight) {
        flights.add(flight);
        return flight;
    }

    @Override
    public List<Flight> findFlightByDepartureCountryName(String country) {
        List<Flight> availableFlights = flights.stream()
                .filter(flight -> flight.getDeparture().getAirport().getCountry().equals(country))
                .collect(Collectors.toList());
        return availableFlights;
    }

    @Override
    public List<Flight> findFlightByDepartureCity(String city) {
        List<Flight> availableFlights = flights.stream()
                .filter(flight -> flight.getDeparture().getAirport().getCity().equals(city))
                .collect(Collectors.toList());
        return availableFlights;
    }

    @Override
    public List<Flight> findFlightByArrivalCity(String city) {
        List<Flight> availableFlights = flights.stream()
                .filter(flight -> flight.getArrival().getAirport().getCity().equals(city))
                .collect(Collectors.toList());
        return availableFlights;
    }

    @Override
    public Flight findFlightByFlightId(String flightId) {
        Flight flight = flights.stream().filter(flight1 -> flight1.getFlightId().equals(flightId)).findAny().orElse(null);
        return flight;
    }

    @Override
    public List<Flight> deleteFlight(Flight flight) {
        flights.remove(flight);
        return flights;
    }
}
