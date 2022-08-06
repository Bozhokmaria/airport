package com.solvd.airport.services.flight;

import com.solvd.airport.services.informational.arrival.Arrival;
import com.solvd.airport.services.informational.departure.Departure;
import com.solvd.airport.main.plane.Plane;

public class Flight {
    private String flightId;
    private Plane plane;

    private Departure departure;
    private Arrival arrival;
    private double price;

    public Flight() {
    }

    public Flight(String flightId, Plane plane, Departure departure, Arrival arrival, double price) {
        this.flightId = flightId;
        this.plane = plane;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (Double.compare(flight.price, price) != 0) return false;
        if (flightId != null ? !flightId.equals(flight.flightId) : flight.flightId != null) return false;
        if (plane != null ? !plane.equals(flight.plane) : flight.plane != null) return false;
        if (arrival != null ? !arrival.equals(flight.arrival) : flight.arrival != null) return false;
        return departure != null ? departure.equals(flight.departure) : flight.departure == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = flightId != null ? flightId.hashCode() : 0;
        result = 31 * result + (plane != null ? plane.hashCode() : 0);
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", plane=" + plane +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", price=" + price +
                '}';
    }
}
