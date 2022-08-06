package com.solvd.airport.people.passanger;

import com.solvd.airport.people.Person;

public class Passenger extends Person {

    public Passenger() {
    }

    public Passenger(String id, String name, String lastName) {
        super(id, name, lastName);
    }

    @Override
    public void setDiscount(double discount) {
        if (discount < 97 && discount > 0) {
            this.setDiscount(discount + 3);
        } else {
            this.setDiscount(3);
        }
    }

    @Override
    public String toString() {
        return "Passenger{" + super.toString() + "}";
    }
}
