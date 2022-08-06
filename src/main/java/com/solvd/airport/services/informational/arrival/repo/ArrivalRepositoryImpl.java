package com.solvd.airport.services.informational.arrival.repo;

import com.solvd.airport.exception.EntityAlreadyExistsException;
import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.services.informational.arrival.Arrival;
import com.solvd.airport.main.airport.Airport;
import com.solvd.airport.services.informational.departure.Departure;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrivalRepositoryImpl implements ArrivalRepository {
    private Set<Arrival> arrivals = new LinkedHashSet<>();

    private static final ArrivalRepositoryImpl ARRIVAL_REPOSITORY = new ArrivalRepositoryImpl();

    private ArrivalRepositoryImpl() {
    }

    public static ArrivalRepositoryImpl getArrivalRepositoryImpl() {
        return ARRIVAL_REPOSITORY;
    }

    public Set<Arrival> getArrivals() {
        return arrivals;
    }

    @Override
    public Arrival addArrival(String id, Airport airport, LocalDateTime timeOfArrival) {
        Arrival arrival = new Arrival(id, airport, timeOfArrival);
        if (arrivals.contains(arrival)) {
            throw new EntityAlreadyExistsException("Such arrival already exists");
        } else {
            arrivals.add(arrival);
        }
        return arrival;
    }

    @Override
    public Arrival addArrival(Arrival arrival) {
        if (arrivals.contains(arrival)) {
            throw new EntityAlreadyExistsException("Such arrival already exists");
        } else {
            arrivals.add(arrival);
        }
        return arrival;
    }

    @Override
    public Set<Arrival> updateArrival(Arrival arrival) {
        Arrival arrivalToUpdate = arrivals.stream()
                .filter(arrival1 -> arrival.getId().equals(arrival1.getId()))
                .findAny().orElseThrow(() -> new NoSuchElementException("There is no arrival with such id: " + arrival.getId()));
        if (arrivals.contains(arrivalToUpdate)) {
            arrivals.remove(arrivalToUpdate);
            arrivals.add(arrival);
        }
        return arrivals;
    }

    @Override
    public Set<Arrival> deleteArrival(Arrival arrival) {
        if (arrivals.contains(arrival)) {
            arrivals.remove(arrival);
        } else {
            throw new NoSuchElementException("There was no such arrival");
        }
        return arrivals;
    }

    @Override
    public Arrival findArrivalByAirportName(String airportName) {
        Arrival arrival =
                arrivals.stream().filter(a -> a.getAirport().getName().equals(airportName)).findAny()
                        .orElseThrow(() -> new NoSuchElementException("There is no arrival to this airport"));
        return arrival;
    }
}
