package com.solvd.airport.services.ticket.repo;

import com.solvd.airport.services.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();
    private static final TicketRepositoryImpl TICKET_REPOSITORY = new TicketRepositoryImpl();

    private TicketRepositoryImpl() {
    }

    public static TicketRepositoryImpl getTicketRepositoryImpl() {
        return TICKET_REPOSITORY;
    }

    public List<Ticket> getTickets() {

        return tickets;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> deleteTicket(Ticket ticket) {
        tickets.remove(ticket);
        return tickets;
    }
}
