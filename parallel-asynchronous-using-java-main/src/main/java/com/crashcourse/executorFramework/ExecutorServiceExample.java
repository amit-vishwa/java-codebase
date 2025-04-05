package com.crashcourse.executorFramework;

import java.util.concurrent.*;

/**
 * Executor framework was introduced in Java 5.
 *
 * It was mainly created to overcome below issues:
 * - manual thread management
 * - difficulty in resource management
 * - overhead during scalability
 * - thread cannot be reused
 * - error handling is not proper
 *
 * Executor framework consists of 3 core interfaces
 * - Executor
 * - ExecutorService
 * - ScheduledExecutorService
 *
 * Below methods visited from ExecutorService:
 * - submit(runnable), submit(callable), submit(runnable,result)
 * - shutdown(), shutdownNow()
 * - awaitTermination(time,unit)
 * - isShutdown(), isTerminated()
 * - invokeAll(callableList), invokeAny(callableList)
 * */
public class ExecutorServiceExample {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        simpleExecution();
//        executionUsingThread();
//        executionUsingThreadArray();
        executionUsingExecutorService();
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime));
    }

    /**
     * Simple factorial calculation of 10 numbers.
     * Time taken is maximum here.
     * */
    private static void simpleExecution(){
        for (int i = 1; i <= 10; i++) {
            System.out.println(factorial(i));
        }
    }

    /**
     * Creates 10 threads to calculate factorial of 10 numbers.
     * Total time taken is inappropriate as it does not wait for thread completion.
     * */
    private static void executionUsingThread(){
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            Thread t1 = new Thread(() -> System.out.println(factorial(finalI)));
            t1.start();
            // when we don't wait for thread by calling join, then time taken will be inaccurate
//            try {
//                t1.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    /**
     * Creates 10 threads for factorial of 10 numbers.
     * Waits for threads to get completed.
     * Only time taken is to execute single thread.
     * */
    private static void executionUsingThreadArray(){
        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            threads[i-1] = new Thread(() -> System.out.println(factorial(finalI)));
            threads[i-1].start();
        }
        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * ExecutorService does all tasks related to threads.
     * It creates, starts and terminates the threads without any manual intervention.
     * We can specify thread pool size (i.e. number of threads to be used)
     * It uses submit() method to execute the task, similar to start() of thread.
     * It can be shut down using shutdown(), shutdownNow() can be used to close all spontaneously.
     * We can also use awaitTermination() to wait to service complete shutdown along with all thread termination.
     * */
    private static void executionUsingExecutorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executorService.submit(() -> System.out.println(factorial(finalI)));
        }
        // control comes direct here, if await termination not used then further statements are executed
        executorService.shutdown();
        try {
            // await termination will wait for termination then execute next steps
            while (!executorService.awaitTermination(50, TimeUnit.MILLISECONDS)){
                // if timeout occurs before thread termination then it returns false, which means wait
                System.out.println("Waiting...");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Calculates and returns factorial of a number.
     * */
    public static int factorial(int n) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int fact = 1;
        for(int i = 1; i <= n; i++){
            fact *= i;
        }
        return fact;
    }

}
