package com.solvd.airport.processes.buying;

import com.solvd.airport.exception.WrongFormatException;
import com.solvd.airport.people.passanger.Passenger;
import com.solvd.airport.people.passanger.repo.PassengerRepositoryImpl;
import com.solvd.airport.processes.enums.PaymentMethod;
import com.solvd.airport.services.flight.Flight;
import com.solvd.airport.services.flight.repo.FlightRepositoryImpl;
import com.solvd.airport.services.luggage.Luggage;
import com.solvd.airport.services.ticket.Ticket;
import com.solvd.airport.services.ticket.repo.TicketRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuyingTicketsDesk {

    private static final Logger LOGGER = LogManager.getLogger(BuyingTicketsDesk.class);

    public static void proceedTicketBuying() {
        Ticket ticket = new Ticket();

        Passenger passenger = identificatePassenger();
        checkPassengerInLoyaltySystem(passenger);
        Luggage luggage = collectPassengerLuggageInfo(passenger);

        List<String> departureCities = getDepartureCities();
        String departureCity = getDepartureCity(departureCities);
        String arrivalCity = getArrivalCity(departureCity);
        List<Flight> availableFlights = getAvailableFlights(departureCity, arrivalCity);
        Flight flight = getPassengerSuitableFlight(availableFlights, departureCity, arrivalCity);
        boolean availableTicket = checkFlightCapacity(flight);
        if (availableTicket) {
            proceedPayment(flight, passenger);
            ticket.setPassenger(passenger);
            ticket.setLuggage(luggage);
            ticket.setFlight(flight);
            ticket.setTicketId(ticket.getFlight().getFlightId() + "T" + passenger.getId());
            TicketRepositoryImpl.getTicketRepositoryImpl().addTicket(ticket);
            LOGGER.info("Your ticket info below. Buying was successful \n" + ticket);
        } else {
            LOGGER.info("No available tickets on the chosen flight");
        }
    }

    private static Passenger identificatePassenger() {
        Scanner scanner = new Scanner(System.in);
        Passenger passenger = new Passenger();

        LOGGER.info("Enter passenger id document:");
        String id = scanner.nextLine();
        passenger.setId(id);

        boolean notValidFirstName = true;
        while (notValidFirstName) {
            LOGGER.info("Enter passenger first name:");
            String name = scanner.nextLine();
            if (name.matches("[A-Z][a-z]+")) {
                passenger.setName(name);
                notValidFirstName = false;
            } else {
                LOGGER.error("First letter should be uppercase");
            }
        }

        boolean notValidLastName = true;
        while (notValidLastName) {
            LOGGER.info("Enter passenger last name:");
            String lastName = scanner.nextLine();
            if (lastName.matches("[A-Z][a-z]+")) {
                passenger.setLastName(lastName);
                notValidLastName = false;
            } else {
                LOGGER.error("First letter should be uppercase");
            }
        }

        return passenger;
    }

    private static void checkPassengerInLoyaltySystem(Passenger passenger) {
        PassengerRepositoryImpl passengerRepository = PassengerRepositoryImpl.getPassengerRepositoryImpl();
        Passenger passenger1 = passengerRepository.findPassengerById(passenger.getId());
        LOGGER.info("Check if passenger already used the airport system: " + passenger);
        if (passenger1 == null) {
            passengerRepository.addPassenger(passenger);
            LOGGER.info("Passenger did not use the airport system. Add to the system: " + passenger);
        } else {
            passenger1.setDiscount(3);
            LOGGER.info("Passenger already used the airport system. Set discount " + passenger1.getDiscount());
        }
    }

    private static Luggage collectPassengerLuggageInfo(Passenger passenger) {
        Scanner scanner = new Scanner(System.in);
        Luggage passengerLuggage;
        LOGGER.info("Enter do passenger have luggage 1 - yes, 2 - no. By default - no luggage");
        int luggage;

        try {
            luggage = scanner.nextInt();
            if (luggage == 1) {
                passengerLuggage = new Luggage("lug" + passenger.getId());
            } else if (luggage == 2) {
                passengerLuggage = null;
            } else {
                throw new WrongFormatException("Wrong number for luggage presence");
            }
        } catch (RuntimeException e) {
            LOGGER.error(e + " - Wrong input. By default - were chosen no luggage");
            passengerLuggage = null;
        }

        return passengerLuggage;
    }

    private static void prettyPrintCities(List<String> cities) {
        for (String city : cities) {
            LOGGER.info(city);
        }
    }

    private static List<String> getDepartureCities() {
        FlightRepositoryImpl flightRepository = FlightRepositoryImpl.getFlightRepositoryImpl();
        List<String> cities = flightRepository.getFlights().stream()
                .map(flight -> flight.getDeparture().getAirport().getCity()).collect(Collectors.toList());
        return cities;
    }

    private static String getDepartureCity(List<String> departureCities) {
        String departureCity = null;
        boolean cityNotCorrectlyEntered = true;

        LOGGER.info("It is available to buy tickets from cities:");
        prettyPrintCities(departureCities);
        Scanner scanner = new Scanner(System.in);
        while (cityNotCorrectlyEntered) {
            LOGGER.info("Enter city from which you want to buy ticket");
            departureCity = scanner.nextLine();
            for (int i = 0; i < departureCities.size(); i++) {
                if (departureCity.equalsIgnoreCase(departureCities.get(i))) {
                    departureCity = departureCities.get(i);
                    cityNotCorrectlyEntered = false;
                }
            }
            if (cityNotCorrectlyEntered) {
                try {
                    throw new WrongFormatException("In the list there is no such city. Look one more time");
                } catch (RuntimeException e) {
                    LOGGER.error(e);
                    prettyPrintCities(departureCities);
                }
            }
        }
        return departureCity;
    }

    private static String getArrivalCity(String departureCity) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrivalCities = getAvailableArrivalCities(departureCity);
        LOGGER.info("Cities where you can fly from " + departureCity);
        prettyPrintCities(arrivalCities);
        String arrivalCity = null;
        boolean arrivalCityEnteredNotCorrectly = true;
        while (arrivalCityEnteredNotCorrectly) {
            arrivalCity = scanner.nextLine();
            for (int i = 0; i < arrivalCities.size(); i++) {
                if (arrivalCity.equalsIgnoreCase(arrivalCities.get(i))) {
                    arrivalCity = arrivalCities.get(i);
                    arrivalCityEnteredNotCorrectly = false;
                }
            }
            if (arrivalCityEnteredNotCorrectly) {
                try {
                    throw new WrongFormatException("In the list there is no such city. Look one more time");
                } catch (RuntimeException e) {
                    LOGGER.error(e);
                    prettyPrintCities(arrivalCities);
                }
            }
        }
        return arrivalCity;
    }

    private static List<String> getAvailableArrivalCities(String departureCity) {
        FlightRepositoryImpl flightRepository = FlightRepositoryImpl.getFlightRepositoryImpl();
        List<String> arrivals = flightRepository.getFlights().stream()
                .filter(flight -> flight.getDeparture().getAirport().getCity().equals(departureCity))
                .map(flight -> flight.getArrival().getAirport().getCity())
                .collect(Collectors.toList());
        return arrivals;
    }

    private static List<Flight> getAvailableFlights(String departureCity, String arrivalCity) {
        FlightRepositoryImpl flightRepository = FlightRepositoryImpl.getFlightRepositoryImpl();
        List<Flight> flights = flightRepository.getFlights().stream()
                .filter(flight -> flight.getDeparture().getAirport().getCity().equals(departureCity)
                        && flight.getArrival().getAirport().getCity().equals(arrivalCity))
                .collect(Collectors.toList());
        return flights;
    }

    private static Flight getPassengerSuitableFlight(List<Flight> availableFlights, String departureCity, String arrivalCity) {
        LOGGER.info("Available flights from " + departureCity + " to " + arrivalCity + " " + availableFlights);
        Scanner scanner = new Scanner(System.in);

        String flightId = null;
        boolean flightIdNotEntered = true;
        while (flightIdNotEntered) {
            LOGGER.info("Enter flight id to start tickets reservation");
            flightId = scanner.nextLine();
            for (int i = 0; i < availableFlights.size(); i++) {
                if (flightId.equalsIgnoreCase(availableFlights.get(i).getFlightId())) {
                    flightId = availableFlights.get(i).getFlightId();
                    flightIdNotEntered = false;
                }
            }
            if (flightIdNotEntered) {
                try {
                    throw new WrongFormatException("Wrong flight id. There is no flights with such id");
                } catch (RuntimeException e) {
                    LOGGER.error(e);
                    LOGGER.info("Available flights from " + departureCity + " to " + arrivalCity + " " + availableFlights);
                }
            }
        }
        Flight flight = FlightRepositoryImpl.getFlightRepositoryImpl().findFlightByFlightId(flightId);
        return flight;
    }

    private static boolean checkFlightCapacity(Flight flight) {
        FlightRepositoryImpl flightRepository = FlightRepositoryImpl.getFlightRepositoryImpl();
        int capacity = flightRepository.findFlightByFlightId(flight.getFlightId()).getPlane().getCapacity();
        if ((capacity - 1) > 0) {
            LOGGER.info("Tickets are available");
            return true;
        } else {
            LOGGER.info("Tickets are not available");
            return false;
        }
    }

    private static void proceedPayment(Flight flight, Passenger passenger) {
        boolean unsuccessfulPayment = true;
        int capacity = flight.getPlane().getCapacity();

        Scanner scanner = new Scanner(System.in);

        while (unsuccessfulPayment) {
            LOGGER.info("Price іs: " + flight.getPrice());
            LOGGER.info("Pay by card or cash. Type 1 for card, 2 -cash");
            int paymentMethod = scanner.nextInt();
            PaymentMethod method = null;

            if (paymentMethod == 1) {
                method = PaymentMethod.CARD;

            } else if (paymentMethod == 2) {
                method = PaymentMethod.CASH;
            }

            if (method != null) {
                switch (method) {
                    case CARD:
                        unsuccessfulPayment = false;
                        FlightRepositoryImpl.getFlightRepositoryImpl().findFlightByFlightId(flight.getFlightId())
                                .getPlane().setCapacity(--capacity);
                        break;
                    case CASH:
                        LOGGER.info("Amount of money from passenger");
                        double cash = scanner.nextDouble();
                        try {
                            if (cash < 0
                                    ||
                                    (flight.getPrice() - ((flight.getPrice() * passenger.getDiscount()) / 100)) > cash) {
                                throw new WrongFormatException("Amount of money cant be negative or less than ticket price");
                            } else {
                                double change = cash - (flight.getPrice() - ((flight.getPrice() * passenger.getDiscount()) / 100));
                                unsuccessfulPayment = false;
                                LOGGER.info("Cash. Your change: " + change);
                                FlightRepositoryImpl.getFlightRepositoryImpl().findFlightByFlightId(flight.getFlightId())
                                        .getPlane().setCapacity(--capacity);
                            }
                        } catch (RuntimeException e) {
                            LOGGER.error(e);
                        }
                        break;
                }
            }
        }
    }
}
