package com.solvd.airport.services.runway.repo;

import com.solvd.airport.services.runway.Runway;

import java.util.ArrayList;
import java.util.List;

public class RunwayRepositoryImpl implements RunwayRepository {

    private List<Runway> runways = new ArrayList<>();
    private static final RunwayRepositoryImpl RUNWAY_REPOSITORY = new RunwayRepositoryImpl();

    private RunwayRepositoryImpl() {
    }

    public static RunwayRepositoryImpl getRunwayRepositoryImpl() {
        return RUNWAY_REPOSITORY;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    @Override
    public Runway addRunway(Runway runway) {
        runways.add(runway);
        return runway;
    }

    @Override
    public List<Runway> deleteRunway(Runway runway) {
        runways.remove(runway);
        return runways;
    }
}
