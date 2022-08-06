package com.solvd.airport.services.luggage;

public class Luggage {
    private String luggageId;

    public Luggage() {
    }

    public Luggage(String luggageId) {
        this.luggageId = luggageId;
    }

    public String getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(String luggageId) {
        this.luggageId = luggageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Luggage)) return false;

        Luggage luggage = (Luggage) o;

        return luggageId != null ? luggageId.equals(luggage.luggageId) : luggage.luggageId == null;
    }

    @Override
    public int hashCode() {
        return luggageId != null ? luggageId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "luggageId='" + luggageId + '\'' +
                '}';
    }
}
