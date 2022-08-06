package com.solvd.airport.main.airport.repo;

import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.main.airport.Airport;

import java.util.LinkedHashSet;
import java.util.Set;

public class AirportRepositoryImpl implements AirportRepository{

    private Set<Airport> airports = new LinkedHashSet<>();
    private static final AirportRepositoryImpl AIRPORT_REPOSITORY = new AirportRepositoryImpl();

    private AirportRepositoryImpl() {
    }

    public static AirportRepositoryImpl getAirportRepositoryImpl() {
        return AIRPORT_REPOSITORY;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    @Override
    public Airport addAirport(Airport airport) {
        airports.add(airport);
        return airport;
    }

    @Override
    public Set<Airport> deleteAirport(Airport airport) {
        airports.remove(airport);
        return airports;
    }

    @Override
    public Airport findAirportByName(String name) {
        Airport airport = airports.stream().filter(a -> a.getName().equals(name)).findAny()
                .orElseThrow(() -> new NoSuchElementException("There is no airport with the given name: " + name));
        return airport;
    }
}
