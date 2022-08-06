package com.solvd.airport.services.luggage.repo;

import com.solvd.airport.services.luggage.Luggage;

import java.util.List;

public interface LuggageRepository {
    /**
     * Adds luggage to the luggage's repository
     */
    Luggage addLuggage(Luggage luggage);

    /**
     * Deletes luggage from the luggage's repository if it is present
     */
    List<Luggage> deleteLuggage(Luggage luggage);
}
