package com.solvd.airport.services.luggage.repo;

import com.solvd.airport.services.luggage.Luggage;

import java.util.ArrayList;
import java.util.List;

public class LuggageRepositoryImpl implements LuggageRepository {

    private List<Luggage> luggages = new ArrayList<>();
    private static final LuggageRepositoryImpl LUGGAGE_REPOSITORY = new LuggageRepositoryImpl();

    private LuggageRepositoryImpl() {
    }

    public static LuggageRepositoryImpl getLuggageRepositoryImpl() {
        return LUGGAGE_REPOSITORY;
    }

    public List<Luggage> getLuggages() {
        return luggages;
    }

    @Override
    public Luggage addLuggage(Luggage luggage) {
        luggages.add(luggage);
        return luggage;
    }

    @Override
    public List<Luggage> deleteLuggage(Luggage luggage) {
        luggages.remove(luggage);
        return luggages;
    }
}
