package com.solvd.airport.processes.enums;

public enum Discount {
    EMPLOYEE(15),
    PILOT(20),
    ORDINARY(0),
    REGULAR(15);

    private final double discount;

    Discount(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
