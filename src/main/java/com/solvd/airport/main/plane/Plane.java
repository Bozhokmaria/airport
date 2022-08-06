package com.solvd.airport.main.plane;

public class Plane {
    private String planeName;
    private int capacity;

    public Plane() {
    }

    public Plane(String planeName, int capacity) {
        this.planeName = planeName;
        this.capacity = capacity;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (capacity != plane.capacity) return false;
        return planeName != null ? planeName.equals(plane.planeName) : plane.planeName == null;
    }

    @Override
    public int hashCode() {
        int result = planeName != null ? planeName.hashCode() : 0;
        result = 31 * result + capacity;
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId='" + planeName + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
