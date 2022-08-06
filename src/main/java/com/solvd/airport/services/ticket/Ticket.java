package com.solvd.airport.services.ticket;

import com.solvd.airport.people.passanger.Passenger;
import com.solvd.airport.services.flight.Flight;
import com.solvd.airport.services.luggage.Luggage;

public class Ticket {
    private String ticketId;
    private Flight flight;
    private Passenger passenger;
    private Luggage luggage;

    public Ticket() {
    }

    public Ticket(String ticketId, Flight flight, Passenger passenger, Luggage luggage) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.passenger = passenger;
        this.luggage = luggage;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (ticketId != null ? !ticketId.equals(ticket.ticketId) : ticket.ticketId != null) return false;
        if (flight != null ? !flight.equals(ticket.flight) : ticket.flight != null) return false;
        if (passenger != null ? !passenger.equals(ticket.passenger) : ticket.passenger != null) return false;
        return luggage != null ? luggage.equals(ticket.luggage) : ticket.luggage == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ticketId != null ? ticketId.hashCode() : 0;
        result = 31 * result + (flight != null ? flight.hashCode() : 0);
        result = 31 * result + (passenger != null ? passenger.hashCode() : 0);
        result = 31 * result + (luggage != null ? luggage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", luggage=" + luggage +
                ", passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }
}
