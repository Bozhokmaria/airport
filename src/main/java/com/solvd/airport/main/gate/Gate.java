package com.solvd.airport.main.gate;

public class Gate {
    private String name;

    public Gate() {
    }

    public Gate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gate gate = (Gate) o;

        return name != null ? name.equals(gate.name) : gate.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "name='" + name + '\'' +
                '}';
    }
}
