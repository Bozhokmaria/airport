package com.solvd.airport.processes.buying;

import com.solvd.airport.exception.NoSuchElementException;
import com.solvd.airport.exception.WrongFormatException;
import com.solvd.airport.people.passanger.Passenger;
import com.solvd.airport.people.passanger.repo.PassengerRepositoryImpl;
import com.solvd.airport.services.flight.Flight;
import com.solvd.airport.services.flight.repo.FlightRepositoryImpl;
import com.solvd.airport.services.luggage.Luggage;
import com.solvd.airport.services.ticket.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BuyingTicketsDesk {

    private static final Logger LOGGER = LogManager.getLogger(BuyingTicketsDesk.class);

    public void proceedTicketBuying() {
        Ticket ticket = new Ticket();
        boolean successfulPayment = false;

        Scanner scanner = new Scanner(System.in);
        Passenger passenger = new Passenger();

        LOGGER.info("Enter passenger id document:");
        String id = scanner.nextLine();
        passenger.setId(id);

        LOGGER.info("Enter passenger name:");
        String name = scanner.nextLine();
        passenger.setName(name);

        LOGGER.info("Enter passenger last name:");
        String lastName = scanner.nextLine();
        passenger.setLastName(lastName);

        PassengerRepositoryImpl passengerRepository = PassengerRepositoryImpl.getPassengerRepositoryImpl();
        Passenger passenger1 = passengerRepository.findPassengerById(id);
        LOGGER.info("Check passenger already used the airport system: " + passenger1);
        if (passenger1 == null) {
            passengerRepository.addPassenger(passenger);
            LOGGER.info("Passenger did not use the airport system. Add to the system: " + passenger);
            ticket.setPassenger(passenger);
        } else {
            passenger1.setDiscount(5);
            LOGGER.info("Passenger already used the airport system. Set discount " + passenger1.getDiscount());
            ticket.setPassenger(passenger1);
        }

        LOGGER.info("Enter do passenger have luggage 1 - yes, 2 - no");
        int luggage = scanner.nextInt();
        Luggage luggage1 = new Luggage();
        try {
            if (luggage == 1) {
                luggage1 = new Luggage("lug" + passenger.getId());
            } else if (luggage == 2) {
                luggage1 = null;
            } else {
                throw new WrongFormatException("Wrong number for luggage presence");
            }
            ticket.setLuggage(luggage1);

        } catch (RuntimeException e) {
            LOGGER.error(e);
        }

        LOGGER.info("Where is your start point. Enter country: to see Available flights from");
        scanner.nextLine();
        String departureCountry = scanner.nextLine();

        FlightRepositoryImpl flightRepository = FlightRepositoryImpl.getFlightRepositoryImpl();
        List<Flight> available = flightRepository.findFlightByDepartureCountryName(departureCountry);
        LOGGER.info("Flights available" + available);

        try {
            if (!available.isEmpty()) {

                LOGGER.info("Enter flight id to start tickets reservation");
                String flightId = scanner.nextLine();
                Flight flight = flightRepository.findFlightByFlightId(flightId);
                try {
                    if (flight != null) {
                        if (!(flight.getPlane().getCapacity() > 0)) {
                            throw new WrongFormatException(" No capacity");
                        }
                        flight = flightRepository.findFlightByFlightId(flightId);
                        int capacity = flightRepository.findFlightByFlightId(flightId).getPlane().getCapacity();
                        ticket.setFlight(flight);

                        LOGGER.info("Price іs: " + flight.getPrice());
                        LOGGER.info("Pay by card or cash. Type 1 for card, 2 -cash");

                        int paymentMethod = scanner.nextInt();
                        if (paymentMethod == 2) {
                            LOGGER.info("Amount of money from passenger");
                            double cash = scanner.nextDouble();
                            try {
                                if (cash < 0 &&
                                        (flight.getPrice() - ((flight.getPrice() * passenger.getDiscount()) / 100)) > cash) {
                                    throw new WrongFormatException("Amount of money cant be negative or less than ticket price");
                                } else {
                                    double change = cash - (flight.getPrice() - ((flight.getPrice() * passenger.getDiscount()) / 100));
                                    successfulPayment = true;
                                    LOGGER.info("Cash. Your change: " + change);
                                    flightRepository.findFlightByFlightId(flightId).getPlane().setCapacity(--capacity);
                                }
                            } catch (RuntimeException e) {
                                LOGGER.error(e);
                            }
                        } else if (paymentMethod == 1) {
                            successfulPayment = true;
                            flightRepository.findFlightByFlightId(flightId).getPlane().setCapacity(--capacity);
                        }
                    } else {
                        throw new NoSuchElementException("There is no suitable flight or all sits are occupied");
                    }
                } catch (RuntimeException e) {
                    LOGGER.error(e);
                }
            } else {
                throw new WrongFormatException("No flights from this country" + departureCountry);
            }
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        }


        try {
            if (ticket.getPassenger() != null && ticket.getFlight() != null && successfulPayment) {
                ticket.setTicketId(ticket.getFlight().getFlightId() + "T" + passenger.getId());
                LOGGER.info("Your ticket. Buying was successful \n" + ticket);
            } else {
                throw new WrongFormatException("Unsuccessful purchase");
            }
        } catch (
                RuntimeException ex) {
            LOGGER.error(ex);
        }
    }
}
