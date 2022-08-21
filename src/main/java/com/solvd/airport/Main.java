package com.solvd.airport;

import com.solvd.airport.processes.buying.BuyingTicketsDesk;
import com.solvd.airport.processes.seed_data.SeedDataAdder;

public class Main {
    public static void main(String[] args) {
        SeedDataAdder.fillWithData();
        BuyingTicketsDesk.proceedTicketBuying();

    }
}
