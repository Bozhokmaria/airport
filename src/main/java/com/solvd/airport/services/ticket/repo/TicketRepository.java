package com.solvd.airport.services.ticket.repo;

import com.solvd.airport.services.ticket.Ticket;

import java.util.List;

public interface TicketRepository {
    /**
     * Adds ticket to the tickets repository
     */
    Ticket addTicket(Ticket ticket);

    /**
     * Deletes ticket from the ticket's repository if it is present
     */
    List<Ticket> deleteTicket(Ticket ticket);
}
