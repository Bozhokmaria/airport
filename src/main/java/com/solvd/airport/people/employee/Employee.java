package com.solvd.airport.people.employee;

import com.solvd.airport.people.Person;
import com.solvd.airport.main.airport.Airport;

public class Employee extends Person {
    private String workPosition;
    private Airport airport;
    private double salary;

    public Employee() {
    }

    public Employee(String id, String name, String lastName, String workPosition, Airport airport, double salary) {
        super(id, name, lastName);
        this.workPosition = workPosition;
        this.airport = airport;
        this.salary = salary;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void setDiscount(double discount) {
        if (discount < 95 && discount > 0) {
            this.setDiscount(discount + 5);
        } else {
            this.setDiscount(5);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.salary, salary) != 0) return false;
        if (workPosition != null ? !workPosition.equals(employee.workPosition) : employee.workPosition != null)
            return false;
        return airport != null ? airport.equals(employee.airport) : employee.airport == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (workPosition != null ? workPosition.hashCode() : 0);
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workPosition='" + workPosition + '\'' +
                ", airport=" + airport +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
