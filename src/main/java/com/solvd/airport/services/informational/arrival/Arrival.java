package com.solvd.airport.services.informational.arrival;

import com.solvd.airport.services.informational.GeneralInfo;
import com.solvd.airport.main.airport.Airport;

import java.time.LocalDateTime;

public class Arrival extends GeneralInfo {
    private LocalDateTime timeOfArrival;

    public Arrival() {
    }

    public Arrival(String id, Airport airport, LocalDateTime timeOfArrival) {
        super(id, airport);
        this.timeOfArrival = timeOfArrival;
    }

    public LocalDateTime getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(LocalDateTime timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Arrival arrival = (Arrival) o;

        return timeOfArrival != null ? timeOfArrival.equals(arrival.timeOfArrival) : arrival.timeOfArrival == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (timeOfArrival != null ? timeOfArrival.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Arrival{" +
                "timeOfArrival=" + timeOfArrival +
                "} " + super.toString();
    }
}
