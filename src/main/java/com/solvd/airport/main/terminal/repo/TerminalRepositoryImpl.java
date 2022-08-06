package com.solvd.airport.main.terminal.repo;

import com.solvd.airport.main.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class TerminalRepositoryImpl implements TerminalRepository {

    private List<Terminal> terminals = new ArrayList<>();
    private static final TerminalRepositoryImpl TERMINAL_REPOSITORY = new TerminalRepositoryImpl();

    private TerminalRepositoryImpl() {
    }

    public static TerminalRepositoryImpl getTerminalRepositoryImpl() {
        return TERMINAL_REPOSITORY;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    @Override
    public Terminal addTerminal(Terminal terminal) {
        terminals.add(terminal);
        return terminal;
    }

    @Override
    public List<Terminal> deleteTerminal(Terminal terminal) {
        terminals.remove(terminal);
        return terminals;
    }
}
