package com.solvd.airport.processes.seed_data;

import com.solvd.airport.main.airport.Airport;
import com.solvd.airport.main.airport.repo.AirportRepositoryImpl;
import com.solvd.airport.main.gate.Gate;
import com.solvd.airport.main.gate.repo.GateRepositoryImpl;
import com.solvd.airport.main.plane.Plane;
import com.solvd.airport.main.plane.repo.PlaneRepositoryImpl;
import com.solvd.airport.main.terminal.Terminal;
import com.solvd.airport.main.terminal.repo.TerminalRepositoryImpl;
import com.solvd.airport.people.employee.Employee;
import com.solvd.airport.people.employee.repo.EmployeeRepositoryImpl;
import com.solvd.airport.people.pilot.Pilot;
import com.solvd.airport.people.pilot.repo.PilotRepositoryImpl;
import com.solvd.airport.processes.buying.BuyingTicketsDesk;
import com.solvd.airport.services.flight.Flight;
import com.solvd.airport.services.flight.repo.FlightRepositoryImpl;
import com.solvd.airport.services.informational.arrival.Arrival;
import com.solvd.airport.services.informational.arrival.repo.ArrivalRepositoryImpl;
import com.solvd.airport.services.informational.departure.Departure;
import com.solvd.airport.services.informational.departure.repo.DepartureRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class SeedDataAdder {

    private static final Logger LOGGER = LogManager.getLogger(SeedDataAdder.class);

    public void fillWithData(){
        addGates();
        addTerminals();
        addAirports();
        addPlanes();
        addPilots();
        addEmployees();
        addDepartures();
        addArrivals();
        addFlights();
    }

    private void addGates() {
        GateRepositoryImpl gateRepository = GateRepositoryImpl.getGateRepositoryImpl();

        Gate gateA = new Gate("A");
        Gate gateB = new Gate("B");

        gateRepository.addGate(gateA);
        gateRepository.addGate(gateB);
    }

    private void addTerminals() {
        TerminalRepositoryImpl terminalRepository = TerminalRepositoryImpl.getTerminalRepositoryImpl();
        GateRepositoryImpl gateRepository = GateRepositoryImpl.getGateRepositoryImpl();

        Terminal terminalNorth = new Terminal("North", gateRepository.getGates());
        Terminal terminalSouth = new Terminal("South", gateRepository.getGates());

        terminalRepository.addTerminal(terminalNorth);
        terminalRepository.addTerminal(terminalSouth);
    }

    private void addAirports() {
        TerminalRepositoryImpl terminalRepository = TerminalRepositoryImpl.getTerminalRepositoryImpl();
        AirportRepositoryImpl airportRepository = AirportRepositoryImpl.getAirportRepositoryImpl();

        Airport boryspil = new Airport("Boryspil", "Ukraine", "Kyiv", terminalRepository.getTerminals());
        Airport chopina = new Airport("Chopin", "Poland", "Warsaw", terminalRepository.getTerminals());
        Airport fiumicino = new Airport("Fiumicino", "Italy", "Rome", terminalRepository.getTerminals());
        Airport charlesDeGaulle = new Airport("Charles de Gaulle", "Francs", "Paris", terminalRepository.getTerminals());

        airportRepository.addAirport(boryspil);
        airportRepository.addAirport(chopina);
        airportRepository.addAirport(fiumicino);
        airportRepository.addAirport(charlesDeGaulle);

    }

    private void addPlanes() {
        PlaneRepositoryImpl planeRepository = PlaneRepositoryImpl.getPlaneRepositoryImpl();

        Plane gulfstreamG100 = new Plane("Gulfstream G100", 7);
        Plane airbusA220 = new Plane("Airbus A220", 115);
        Plane boeing737NG = new Plane("Boeing 737 NG", 130);

        planeRepository.addPlane(gulfstreamG100);
        planeRepository.addPlane(airbusA220);
        planeRepository.addPlane(boeing737NG);
    }

    public void addPilots() {
        PilotRepositoryImpl pilotRepository = PilotRepositoryImpl.getPilotRepositoryImpl();

        Pilot pilot = new Pilot("1A", "Peter", "James", 15000);
        Pilot pilot2 = new Pilot("1B", "John", "Black", 25000);
        Pilot pilot3 = new Pilot("2B", "Lion", "Coles", 17000);

        pilotRepository.addPilot(pilot);
        pilotRepository.addPilot(pilot2);
        pilotRepository.addPilot(pilot3);
    }

    private void addEmployees() {
        EmployeeRepositoryImpl employeeRepository = EmployeeRepositoryImpl.getEmployeeRepositoryImpl();

        Employee employee = new Employee("1A", "Lucy", "Linn", "Receptionist",
                AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Chopin"), 12000);

        Employee employee1 = new Employee("11", "Darina", "Dan", "Administrator",
                AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Fiumicino"), 20000);

        Employee employee2 = new Employee("23", "Ivan", "Prost", "Security",
                AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Boryspil"), 15000);

        employeeRepository.addEmployee(employee);
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);
    }

    private void addDepartures() {
        DepartureRepositoryImpl departureRepository = DepartureRepositoryImpl.getDepartureRepositoryImpl();

        Departure departure = new Departure("1", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Fiumicino"),
                LocalDateTime.now().plusHours(5));

        Departure departure2 = new Departure("2", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Chopin"),
                LocalDateTime.now().plusHours(10));

        Departure departure3 = new Departure("3", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Boryspil"),
                LocalDateTime.now().plusHours(1));

        Departure departure4 = new Departure("4", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Charles de Gaulle"),
                LocalDateTime.now().plusHours(6));

        departureRepository.addDeparture(departure);
        departureRepository.addDeparture(departure2);
        departureRepository.addDeparture(departure3);
        departureRepository.addDeparture(departure4);
    }


    private void addArrivals() {
        ArrivalRepositoryImpl arrivalRepository = ArrivalRepositoryImpl.getArrivalRepositoryImpl();
        DepartureRepositoryImpl departureRepository = DepartureRepositoryImpl.getDepartureRepositoryImpl();

        Arrival arrival = new Arrival("1", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Fiumicino"),
                departureRepository.findDepartureByAirportName("Chopin").getTimeOfDeparture().plusHours(10));

        Arrival arrival1 = new Arrival("2", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Chopin"),
                departureRepository.findDepartureByAirportName("Boryspil").getTimeOfDeparture().plusHours(5));

        Arrival arrival2 = new Arrival("3", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Boryspil"),
                departureRepository.findDepartureByAirportName("Charles de Gaulle").getTimeOfDeparture().plusHours(7));

        Arrival arrival3 = new Arrival("4", AirportRepositoryImpl.getAirportRepositoryImpl().findAirportByName("Charles de Gaulle"),
                departureRepository.findDepartureByAirportName("Fiumicino").getTimeOfDeparture().plusHours(5));

        arrivalRepository.addArrival(arrival);
        arrivalRepository.addArrival(arrival1);
        arrivalRepository.addArrival(arrival2);
        arrivalRepository.addArrival(arrival3);
    }

    private void addFlights() {
        FlightRepositoryImpl flightRepository = FlightRepositoryImpl.getFlightRepositoryImpl();
        PlaneRepositoryImpl planeRepository = PlaneRepositoryImpl.getPlaneRepositoryImpl();
        DepartureRepositoryImpl departureRepository = DepartureRepositoryImpl.getDepartureRepositoryImpl();
        ArrivalRepositoryImpl arrivalRepository = ArrivalRepositoryImpl.getArrivalRepositoryImpl();

        Flight fromChopinToFiumicino = new Flight("CHF876",
                planeRepository.findPlaneByName("Airbus A220"),
                departureRepository.findDepartureByAirportName("Chopin"),
                arrivalRepository.findArrivalByAirportName("Fiumicino"), 200.00);

        Flight fromBoryspilToChopin = new Flight("BCH631",
                planeRepository.findPlaneByName("Gulfstream G100"),
                departureRepository.findDepartureByAirportName("Boryspil"),
                arrivalRepository.findArrivalByAirportName("Chopin"), 1500);

        Flight fromCharlesDeGaulleToBoryspil = new Flight("CHDB816",
                planeRepository.findPlaneByName("Gulfstream G100"),
                departureRepository.findDepartureByAirportName("Charles de Gaulle"),
                arrivalRepository.findArrivalByAirportName("Boryspil"), 500);

        Flight fromFiumicinoToCharlesDeGaulle = new Flight("CHDB816",
                planeRepository.findPlaneByName("Boeing 737 NG"),
                departureRepository.findDepartureByAirportName("Fiumicino"),
                arrivalRepository.findArrivalByAirportName("Charles de Gaulle"), 135.50);

        flightRepository.addFlight(fromChopinToFiumicino);
        flightRepository.addFlight(fromBoryspilToChopin);
        flightRepository.addFlight(fromCharlesDeGaulleToBoryspil);
        flightRepository.addFlight(fromFiumicinoToCharlesDeGaulle);

       LOGGER.info("from Ukraine" + flightRepository.findFlightByDepartureCountryName("Ukraine"));

    }
}
