package com.solvd.airport.people.pilot.repo;

import com.solvd.airport.people.pilot.Pilot;

import java.util.Set;

public interface PilotRepository {

    /**
     * Adds pilot to the pilot repository
     */
    Pilot addPilot(Pilot pilot);

    /**
     * Finds pilot by pilot`s id
     */
    Pilot findPilotById(String id);

    /**
     * Deletes pilot from the pilots' repository if it is present
     */
    Set<Pilot> deletePilot(Pilot pilot);
}
