package com.solvd.airport.services.informational.schedule.repo;

import com.solvd.airport.services.informational.arrival.Arrival;
import com.solvd.airport.services.informational.departure.Departure;
import com.solvd.airport.services.informational.schedule.Schedule;
import com.solvd.airport.services.flight.Flight;

import java.util.LinkedHashSet;
import java.util.Set;

public class ScheduleRepositoryImpl implements ScheduleRepository {

    private Set<Schedule> schedules = new LinkedHashSet<>();
    private static final ScheduleRepositoryImpl SCHEDULE_REPOSITORY = new ScheduleRepositoryImpl();

    private ScheduleRepositoryImpl() {
    }

    public static ScheduleRepositoryImpl getScheduleRepositoryImpl() {
        return SCHEDULE_REPOSITORY;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    @Override
    public Schedule addSchedule(String id, Flight flight, Departure departure, Arrival arrival) {
        Schedule schedule = new Schedule(id, flight, departure, arrival);
        schedules.add(schedule);
        return schedule;
    }

    @Override
    public Schedule addSchedule(Schedule schedule) {
        schedules.add(schedule);
        return schedule;
    }

    @Override
    public Set<Schedule> updateSchedule(Schedule schedule) {
        Schedule scheduleToUpdate = schedules.stream().filter(schedule1 -> schedule.getId().equals(schedule1.getId())).findAny().orElse(null);
        if (schedules.contains(scheduleToUpdate)) {
            schedules.remove(scheduleToUpdate);
            schedules.add(schedule);
        }
        return schedules;
    }

    @Override
    public Set<Schedule> deleteSchedule(Schedule schedule) {
        schedules.remove(schedule);
        return schedules;
    }
}
