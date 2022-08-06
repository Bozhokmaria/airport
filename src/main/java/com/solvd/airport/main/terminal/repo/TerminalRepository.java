package com.solvd.airport.main.terminal.repo;

import com.solvd.airport.main.terminal.Terminal;

import java.util.List;

public interface TerminalRepository {
    /**
     * Adds terminal to the terminals repository
     */
    Terminal addTerminal(Terminal terminal);

    /**
     * Deletes terminal from the terminal's repository if it is present
     */
    List<Terminal> deleteTerminal(Terminal terminal);
}
