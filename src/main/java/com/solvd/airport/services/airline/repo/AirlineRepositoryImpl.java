package com.solvd.airport.services.airline.repo;

import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.services.airline.Airline;
import com.solvd.airport.services.flight.Flight;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AirlineRepositoryImpl implements AirlineRepository {

    private Set<Airline> airlines = new LinkedHashSet<>();
    private AirlineRepositoryImpl airlineRepository = new AirlineRepositoryImpl();

    private AirlineRepositoryImpl() {
    }

    public AirlineRepositoryImpl getAirlineRepository() {
        return airlineRepository;
    }

    public Set<Airline> getAirlines() {
        return airlines;
    }

    @Override
    public Airline addAirline(String id, String name, List<Flight> flights) {
        Airline airline = new Airline(id, name, flights);
        airlines.add(airline);
        return airline;
    }

    @Override
    public Airline addAirline(Airline airline) {
        airlines.add(airline);
        return airline;
    }

    @Override
    public Airline findAirlineById(String id) {
        Airline airline = airlines.stream().filter(a -> a.getId().equals(id)).findAny()
                .orElseThrow(() -> new NoSuchElementException("There is no airline with the given id: " + id));
        return airline;
    }

    @Override
    public Set<Airline> updateAirline(Airline airline) {
        Airline airlineToUpdate = airlines.stream().filter(airline1 -> airline.getId().equals(airline1.getId())).findAny()
                .orElseThrow(() -> new NoSuchElementException("There is no airline with the given id: " + airline.getId()));
        if (airlines.contains(airlineToUpdate)) {
            airlines.remove(airlineToUpdate);
            airlines.add(airline);
        }
        return airlines;
    }

    @Override
    public Set<Airline> deleteAirline(Airline airline) {
        if (airlines.contains(airline)) {
            airlines.remove(airline);
        } else {
            throw new NoSuchElementException("There was no such airline");
        }
        return airlines;
    }
}
