package com.solvd.airport.main.plane.repo;

import com.solvd.airport.main.plane.Plane;
import com.solvd.airport.services.airline.Airline;

import java.util.Set;

public interface PlaneRepository {

    /**
     * Adds plane to the planes repository
     */
    Plane addPlane(String planeId, int capacity);

    /**
     * Adds plane to the planes repository
     */
    Plane addPlane(Plane plane);


    /**
     * Find plane by name
     */
    Plane findPlaneByName(String planeName);

    /**
     * Updates plane with the planeId that is currently present in the planes repository
     */
    Set<Plane> updatePlane(Plane plane);

    /**
     * Deletes plane from the planes' repository if it is present
     */
    Set<Plane> deletePlane(Plane plane);
}
