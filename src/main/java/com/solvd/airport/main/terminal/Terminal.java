package com.solvd.airport.main.terminal;

import com.solvd.airport.main.gate.Gate;

import java.util.List;

public class Terminal {
    private String name;
    private List<Gate> gateList;

    public Terminal() {
    }

    public Terminal(String name, List<Gate> gateList) {
        this.name = name;
        this.gateList = gateList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Terminal)) return false;

        Terminal terminal = (Terminal) o;

        if (name != null ? !name.equals(terminal.name) : terminal.name != null) return false;
        return gateList != null ? gateList.equals(terminal.gateList) : terminal.gateList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gateList != null ? gateList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "name='" + name + '\'' +
                ", gateList=" + gateList +
                '}';
    }
}
