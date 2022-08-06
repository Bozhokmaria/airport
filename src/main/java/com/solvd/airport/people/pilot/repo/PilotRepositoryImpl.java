package com.solvd.airport.people.pilot.repo;

import com.solvd.airport.exception.EntityAlreadyExistsException;
import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.people.pilot.Pilot;

import java.util.LinkedHashSet;
import java.util.Set;

public class PilotRepositoryImpl implements PilotRepository {

    private Set<Pilot> pilots = new LinkedHashSet<>();
    private static final PilotRepositoryImpl PILOT_REPOSITORY = new PilotRepositoryImpl();

    private PilotRepositoryImpl() {
    }

    public static PilotRepositoryImpl getPilotRepositoryImpl() {
        return PILOT_REPOSITORY;
    }

    public Set<Pilot> getPilots() {
        return pilots;
    }

    @Override
    public Pilot addPilot(Pilot pilot) {
        pilots.add(pilot);
        return pilot;
    }

    @Override
    public Pilot findPilotById(String id) {
        Pilot pilot = pilots.stream().filter(pilot1 -> pilot1.getId().equals(id)).findAny()
                .orElse(null);
        return pilot;
    }

    @Override
    public Set<Pilot> deletePilot(Pilot pilot) {
        if (pilots.contains(pilot)) {
            pilots.remove(pilot);
        } else {
            throw new NoSuchElementException("There was no such pilot");
        }
        return pilots;
    }
}
