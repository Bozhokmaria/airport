package com.solvd.airport.services.runway;

import com.solvd.airport.services.flight.Flight;

public class Runway {
    private String runwayId;
    private Flight flight;
    private boolean occupiedStatus;

    public Runway() {
    }

    public Runway(String runwayId, Flight flight, boolean occupiedStatus) {
        this.runwayId = runwayId;
        this.flight = flight;
        this.occupiedStatus = occupiedStatus;
    }

    public String getRunwayId() {
        return runwayId;
    }

    public void setRunwayId(String runwayId) {
        this.runwayId = runwayId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isOccupiedStatus() {
        return occupiedStatus;
    }

    public void setOccupiedStatus(boolean occupiedStatus) {
        this.occupiedStatus = occupiedStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Runway)) return false;

        Runway runway = (Runway) o;

        if (occupiedStatus != runway.occupiedStatus) return false;
        if (runwayId != null ? !runwayId.equals(runway.runwayId) : runway.runwayId != null) return false;
        return flight != null ? flight.equals(runway.flight) : runway.flight == null;
    }

    @Override
    public int hashCode() {
        int result = runwayId != null ? runwayId.hashCode() : 0;
        result = 31 * result + (flight != null ? flight.hashCode() : 0);
        result = 31 * result + (occupiedStatus ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Runway{" +
                "runwayId='" + runwayId + '\'' +
                ", flight=" + flight +
                ", occupiedStatus=" + occupiedStatus +
                '}';
    }
}
