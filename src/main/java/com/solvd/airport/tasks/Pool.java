package com.solvd.airport.tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Pool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello 1");
        });
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello 2");
        });
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello 3");
        });

        //first will be executed main thread
        System.out.println(executor.getPoolSize()); //can see pool size
        System.out.println(executor.getQueue().size()); //one task in queue, because we have 3 tasks to do
    }
}
