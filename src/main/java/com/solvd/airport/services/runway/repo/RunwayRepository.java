package com.solvd.airport.services.runway.repo;

import com.solvd.airport.services.runway.Runway;

import java.util.List;

public interface RunwayRepository {
    /**
     * Adds runway to the runways repository
     */
    Runway addRunway(Runway runway);

    /**
     * Deletes runway from the runway's repository if it is present
     */
    List<Runway> deleteRunway(Runway runway);
}
