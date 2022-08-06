package com.solvd.airport.main.gate.repo;

import com.solvd.airport.main.gate.Gate;

import java.util.ArrayList;
import java.util.List;

public class GateRepositoryImpl implements GateRepository {

    private List<Gate> gates = new ArrayList<>();
    private static final GateRepositoryImpl GATE_REPOSITORY = new GateRepositoryImpl();

    private GateRepositoryImpl() {
    }

    public static GateRepositoryImpl getGateRepositoryImpl() {
        return GATE_REPOSITORY;
    }

    public List<Gate> getGates() {
        return gates;
    }

    @Override
    public Gate addGate(String name) {
        Gate gate = new Gate(name);
        gates.add(gate);
        return gate;
    }

    @Override
    public Gate addGate(Gate gate) {
        gates.add(gate);
        return gate;
    }

    @Override
    public List<Gate> deleteGate(Gate gate) {
        gates.remove(gate);
        return gates;
    }
}
