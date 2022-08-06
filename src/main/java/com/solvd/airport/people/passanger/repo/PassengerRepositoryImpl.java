package com.solvd.airport.people.passanger.repo;

import com.solvd.airport.exception.EntityAlreadyExistsException;
import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.people.passanger.Passenger;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PassengerRepositoryImpl implements PassengerRepository {

    private Set<Passenger> passengers = new LinkedHashSet<>();
    private static final PassengerRepositoryImpl PASSENGER_REPOSITORY = new PassengerRepositoryImpl();

    private PassengerRepositoryImpl() {
    }

    public static PassengerRepositoryImpl getPassengerRepositoryImpl() {
        return PASSENGER_REPOSITORY;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        passengers.add(passenger);
        return passenger;
    }

    @Override
    public Passenger findPassengerById(String id) {
        Passenger passenger = passengers.stream().filter(passenger1 -> passenger1.getId().equals(id)).findAny()
                .orElse(null);
        //Throw(() -> new NoSuchElementException("There is no passenger with the given id: " + id));
        return passenger;
    }

    @Override
    public Set<Passenger> deletePassenger(Passenger passenger) {
        if (passengers.contains(passenger)) {
            passengers.remove(passenger);
        } else {
            throw new NoSuchElementException("There was no such passenger");
        }
        return passengers;
    }

    @Override
    public List<Passenger> findPassengerByFullName(String name, String lastName) {
        List<Passenger> passengers1 = passengers.stream()
                .filter(passenger1 -> passenger1.getName().equals(name) && passenger1.getLastName().equals(lastName))
                .collect(Collectors.toList());
        return passengers1;
    }
}
