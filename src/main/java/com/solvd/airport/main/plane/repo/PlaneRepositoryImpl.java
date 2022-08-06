package com.solvd.airport.main.plane.repo;

import com.solvd.airport.main.plane.Plane;

import java.util.LinkedHashSet;
import java.util.Set;

public class PlaneRepositoryImpl implements PlaneRepository {

    private Set<Plane> planes = new LinkedHashSet<>();
    private static final PlaneRepositoryImpl PLANE_REPOSITORY = new PlaneRepositoryImpl();

    private PlaneRepositoryImpl() {
    }

    public static PlaneRepositoryImpl getPlaneRepositoryImpl() {
        return PLANE_REPOSITORY;
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    @Override
    public Plane addPlane(String planeId, int capacity) {
        Plane plane = new Plane(planeId, capacity);
        planes.add(plane);
        return plane;
    }

    @Override
    public Plane addPlane(Plane plane) {
        planes.add(plane);
        return plane;
    }

    @Override
    public Set<Plane> updatePlane(Plane plane) {
        Plane planeToUpdate = planes.stream().filter(plane1 -> plane.getPlaneName().equals(plane1.getPlaneName())).findAny().orElse(null);
        if (planes.contains(planeToUpdate)) {
            planes.remove(planeToUpdate);
            planes.add(plane);
        }
        return planes;
    }

    @Override
    public Set<Plane> deletePlane(Plane plane) {
        planes.remove(plane);
        return planes;
    }

    @Override
    public Plane findPlaneByName(String planeName) {
        Plane plane = planes.stream().filter(plane1 -> plane1.getPlaneName().equals(planeName)).findAny().orElse(null);
        return plane;
    }
}
