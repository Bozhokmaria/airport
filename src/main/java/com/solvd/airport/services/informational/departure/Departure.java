package com.solvd.airport.services.informational.departure;

import com.solvd.airport.services.informational.GeneralInfo;
import com.solvd.airport.main.airport.Airport;

import java.time.LocalDateTime;

public class Departure extends GeneralInfo {
    private LocalDateTime timeOfDeparture;

    public Departure() {
    }

    public Departure(String id, Airport airport, LocalDateTime timeOfDeparture) {
        super(id, airport);
        this.timeOfDeparture = timeOfDeparture;
    }

    public LocalDateTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalDateTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Departure departure = (Departure) o;

        return timeOfDeparture != null ? timeOfDeparture.equals(departure.timeOfDeparture) : departure.timeOfDeparture == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (timeOfDeparture != null ? timeOfDeparture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "timeOfDeparture=" + timeOfDeparture +
                "} " + super.toString();
    }
}