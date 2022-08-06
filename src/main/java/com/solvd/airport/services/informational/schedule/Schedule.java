package com.solvd.airport.services.informational.schedule;

import com.solvd.airport.services.informational.arrival.Arrival;
import com.solvd.airport.services.informational.departure.Departure;
import com.solvd.airport.services.flight.Flight;

public class Schedule {

    private String id;
    private Flight flight;
    private Departure departure;
    private Arrival arrival;

    public Schedule() {
    }

    public Schedule(String id, Flight flight, Departure departure, Arrival arrival) {
        this.id = id;
        this.flight = flight;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (id != null ? !id.equals(schedule.id) : schedule.id != null) return false;
        if (flight != null ? !flight.equals(schedule.flight) : schedule.flight != null) return false;
        if (departure != null ? !departure.equals(schedule.departure) : schedule.departure != null) return false;
        return arrival != null ? arrival.equals(schedule.arrival) : schedule.arrival == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flight != null ? flight.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", flight=" + flight +
                ", departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}
