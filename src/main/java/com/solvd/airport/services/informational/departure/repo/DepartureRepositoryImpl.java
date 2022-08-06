package com.solvd.airport.services.informational.departure.repo;

import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.services.informational.departure.Departure;
import com.solvd.airport.main.airport.Airport;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class DepartureRepositoryImpl implements DepartureRepository {
    private Set<Departure> departures = new LinkedHashSet<>();

    private static final DepartureRepositoryImpl DEPARTURE_REPOSITORY = new DepartureRepositoryImpl();

    private DepartureRepositoryImpl() {
    }

    public static DepartureRepositoryImpl getDepartureRepositoryImpl() {
        return DEPARTURE_REPOSITORY;
    }

    public Set<Departure> getDepartures() {
        return departures;
    }

    @Override
    public Departure addDeparture(String id, Airport airport, LocalDateTime timeOfDeparture) {
        Departure departure = new Departure(id, airport, timeOfDeparture);
        departures.add(departure);
        return departure;
    }

    @Override
    public Departure addDeparture(Departure departure) {
        departures.add(departure);
        return departure;
    }

    @Override
    public Set<Departure> updateDeparture(Departure departure) {
        Departure departureToUpdate = departures.stream().filter(departure1 -> departure.getId().equals(departure1.getId())).findAny()
                .orElseThrow(() -> new NoSuchElementException("There is no Departure with such id"));
        if (departures.contains(departureToUpdate)) {
            departures.remove(departureToUpdate);
            departures.add(departure);
        }
        return departures;
    }

    @Override
    public Departure findDepartureByAirportName(String airportName) {
        Departure departure =
                departures.stream().filter(departure1 -> departure1.getAirport().getName().equals(airportName)).findAny()
                        .orElseThrow(() -> new NoSuchElementException("There is no suitable departure from this airport"));
        return departure;
    }

    @Override
    public Set<Departure> deleteDeparture(Departure departure) {
        departures.remove(departure);
        return departures;
    }
}
