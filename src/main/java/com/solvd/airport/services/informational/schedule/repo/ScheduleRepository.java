package com.solvd.airport.services.informational.schedule.repo;

import com.solvd.airport.services.informational.arrival.Arrival;
import com.solvd.airport.services.informational.departure.Departure;
import com.solvd.airport.services.informational.schedule.Schedule;
import com.solvd.airport.services.flight.Flight;

import java.util.Set;

public interface ScheduleRepository {
    /**
     * Adds schedule to the schedules repository
     */
    Schedule addSchedule(String id, Flight flight, Departure departure, Arrival arrival);

    /**
     * Adds schedule to the schedules repository
     */
    Schedule addSchedule(Schedule schedule);

    /**
     * Updates schedule with the id that is currently present in the schedules repository
     */
    Set<Schedule> updateSchedule(Schedule schedule);

    /**
     * Deletes schedule from the schedules' repository if it is present
     */
    Set<Schedule> deleteSchedule(Schedule schedule);
}
