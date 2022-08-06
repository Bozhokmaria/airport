package com.solvd.airport.main.airport;

import com.solvd.airport.main.terminal.Terminal;

import java.util.List;

public class Airport {
    private String name;
    private String country;
    private String city;
    private List<Terminal> terminals;

    public Airport() {
    }

    public Airport(String name, String country, String city, List<Terminal> terminals) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.terminals = terminals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        if (name != null ? !name.equals(airport.name) : airport.name != null) return false;
        if (country != null ? !country.equals(airport.country) : airport.country != null) return false;
        if (city != null ? !city.equals(airport.city) : airport.city != null) return false;
        return terminals != null ? terminals.equals(airport.terminals) : airport.terminals == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (terminals != null ? terminals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", terminals=" + terminals +
                '}';
    }
}
