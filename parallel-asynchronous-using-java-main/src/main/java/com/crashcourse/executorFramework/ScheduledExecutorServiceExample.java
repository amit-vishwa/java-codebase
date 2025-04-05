package com.crashcourse.executorFramework;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ScheduledExecutorService is an interface that extends ExecutorService.
 * It works similar to ExecutorService but allows you to schedule tasks to run after
 * a given delay or periodically.
 * */
public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {
//        executeSimpleScheduler();
//        executeSchedulerAtFixedRate();
        executeSchedulerWithFixedDelay();
    }

    /**
     * Simple schedule() method executes a task after a delay of specified time period
     * */
    private static void executeSimpleScheduler(){
        // cached threadPool can be used for short tasks, as it scales automatically terminates
        // non-required threads post 60s
//        ScheduledExecutorService scheduledExecutorService = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        AtomicInteger counter = new AtomicInteger(0);
        Callable<Integer> task = counter::incrementAndGet; // callable using method reference
        // Schedule the task to run after a delay of 2 seconds
        ScheduledFuture<Integer> scheduledFuture = scheduledExecutorService.schedule(task, 2, java.util.concurrent.TimeUnit.SECONDS);
        try {
            System.out.println(scheduledFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        scheduledExecutorService.shutdown();
    }

    /**
     * scheduleAtFixedRate() method executes a task repeatedly after at the rate of specified time period
     * it starts with the initial delay, period is the period between successive executions
     * */
    private static void executeSchedulerAtFixedRate(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduled task executed after 2 seconds");
        // Schedule the task to run after a delay of 2 seconds
        scheduledExecutorService.scheduleAtFixedRate(task, 2,2, java.util.concurrent.TimeUnit.SECONDS);
        // it prints thrice as period is of 2s, so 3 tasks will get executed withing 6s
        scheduledExecutorService.schedule(()->{
            System.out.println("Initiating shutdown...");
            scheduledExecutorService.shutdown();
        },6, TimeUnit.SECONDS);
    }

    /**
     * scheduleWithFixedDelay() method executes a task repeatedly after a delay of specified time between tasks
     * it starts with the initial delay, the delay between the termination of one execution and the commencement of the next
     * */
    private static void executeSchedulerWithFixedDelay(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduled task executed after 2 seconds");
        // Schedule the task to run after a delay of 2 seconds
        scheduledExecutorService.scheduleWithFixedDelay(task, 2,2, java.util.concurrent.TimeUnit.SECONDS);
        // it prints twice as delay is 2s, so 3 tasks will get executed withing 6s
        scheduledExecutorService.schedule(()->{
            System.out.println("Initiating shutdown...");
            scheduledExecutorService.shutdown();
        },6, TimeUnit.SECONDS);
    }

}
