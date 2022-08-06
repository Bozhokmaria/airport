package com.solvd.airport.services.informational;

import com.solvd.airport.main.airport.Airport;

public abstract class GeneralInfo {
    private String id;
    private Airport airport;

    public GeneralInfo() {
    }

    public GeneralInfo(String id, Airport airport) {
        this.id = id;
        this.airport = airport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralInfo that = (GeneralInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return airport != null ? airport.equals(that.airport) : that.airport == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeneralInfo{" +
                "id='" + id + '\'' +
                ", airport=" + airport +
                '}';
    }
}
