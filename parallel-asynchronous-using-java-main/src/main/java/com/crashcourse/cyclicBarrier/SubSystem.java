package com.crashcourse.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SubSystem implements Runnable {

    private final String name;
    private final int initializationTime;
    private final CyclicBarrier barrier;

    public SubSystem(String name, int initializationTime, CyclicBarrier barrier){
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " initialization started...");
            Thread.sleep(initializationTime); // simulate initialization
            System.out.println(name + " initialization completed.");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
