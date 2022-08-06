package com.solvd.airport.people.pilot;

import com.solvd.airport.people.Person;

public class Pilot extends Person {
    private double salary;

    public Pilot() {
    }

    public Pilot(String id, String name, String lastName, double salary) {
        super(id, name, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void setDiscount(double discount) {
        if (discount < 85 && discount > 0) {
            this.setDiscount(discount + 15);
        } else {
            this.setDiscount(15);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pilot)) return false;
        if (!super.equals(o)) return false;

        Pilot pilot = (Pilot) o;

        return Double.compare(pilot.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
