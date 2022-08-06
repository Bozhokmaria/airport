package com.solvd.airport.main.gate.repo;

import com.solvd.airport.main.gate.Gate;

import java.util.List;

public interface GateRepository {
    /**
     * Adds gate to the gates repository
     */
    Gate addGate(String name);

    /**
     * Adds gate to the gates repository
     */
    Gate addGate(Gate gate);

    /**
     * Deletes gate from the gate`s repository if it is present
     */
    List<Gate> deleteGate(Gate gate);
}
