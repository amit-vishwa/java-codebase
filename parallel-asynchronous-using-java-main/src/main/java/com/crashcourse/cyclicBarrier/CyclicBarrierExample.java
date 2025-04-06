package com.crashcourse.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Worker threads using CyclicBarrier will wait until all threads are terminated
 * await() can be used with barrier to make threads wait.
 * CyclicBarrier won't stop the main thread from execution, however it does its tasks.
 * */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        highLevelCyclicBarrierExample();
        inDepthCyclicBarrierExample();
    }

    /**
     * This is a simple use case of CyclicBarrier.
     * Here, multiple worker threads use cyclic barrier.
     * Then all thread awaits for termination of all threads at the barrier (consider a door).
     * */
    private static void highLevelCyclicBarrierExample(){
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
        executorService.submit(new DependentBarrierService(barrier));
        executorService.submit(new DependentBarrierService(barrier));
        executorService.submit(new DependentBarrierService(barrier));
        System.out.println("Number of parties/barrier threads: " + barrier.getParties());
        System.out.println("Number of threads waiting: " + barrier.getNumberWaiting());
        System.out.println("Is barrier broken: " + barrier.isBroken());
        System.out.println("All dependent barrier services finished, starting main service...");
        executorService.shutdown();
    }

    /**
     * CyclicBarrier created for provided number of systems/parties/threads.
     * The number of parties should not exceed the numbers of threads for proper execution.
     * The Runnable task can be added to barrier that will be executed by the last thread that
     * reaches barrier, after all already reached threads.
     * Now, created 4 different threads and started them for tasks execution.
     * */
    private static void inDepthCyclicBarrierExample(){
        int numberOfSubsystems = 4;
        // provided number of parties should be less than or equal to number of threads
        CyclicBarrier barrier = new CyclicBarrier (numberOfSubsystems, () ->
                // below will be executed at end by last thread reaching barrier after all reached threads
                System.out.println("All subsystems are up and running, system startup complete."));
        Thread webServerThread = new Thread(new SubSystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new SubSystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new SubSystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new SubSystem("Messaging Service", 3500, barrier));
        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();
    }

}
