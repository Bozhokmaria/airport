package com.solvd.airport.services.airline;

import com.solvd.airport.services.flight.Flight;

import java.util.List;

public class Airline {
    private String id;
    private String name;
    private List<Flight> flights;

    public Airline() {
    }

    public Airline(String id, String name, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.flights = flights;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;

        Airline airline = (Airline) o;

        if (id != null ? !id.equals(airline.id) : airline.id != null) return false;
        if (name != null ? !name.equals(airline.name) : airline.name != null) return false;
        return flights != null ? flights.equals(airline.flights) : airline.flights == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (flights != null ? flights.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
