package com.efficient.multithreading.threads.scheduling.normal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 *  Timer thread can take much time for termination hence it should be run as Daemon thread.
 *  By default Timer thread is Daemon thread.
 * */
public class SchedulingTasksForSingleExecution {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Timer timer = new Timer("Timer-thread", true);
        Date currentTime = new Date();
        Date scheduledTime = TimeUtils.getFutureTime(currentTime, 500);

        System.out.println("[" + threadName + "] Current time: " + dateFormatter.format(currentTime));
        timer.schedule(new ScheduledTaskA(8000), scheduledTime); // tasks may or may not delay other tasks
        System.out.println("[" + threadName + "] Task-1 scheduled to run at: " + dateFormatter.format(scheduledTime));

        /////////////////////////////////////Next Task////////////////////////////////////////

        long delayInMillis = 10000;
        ScheduledTaskA task2 = new ScheduledTaskA(4000);
        timer.schedule(task2, delayInMillis);
        System.out.println("[" + threadName + "] Task-2 scheduled to run after " + delayInMillis/1000
                + " seconds Initial-Delay at: " + dateFormatter.format(new Date(task2.scheduledExecutionTime())));

        /////////////////////////////////////Next Task////////////////////////////////////////

        long delayInMillis2 = 12000;
        ScheduledTaskA task3 = new ScheduledTaskA(0);
        timer.schedule(task3, delayInMillis2);
        System.out.println("[" + threadName + "] Task-3 scheduled to run after " + delayInMillis2/1000
                + " seconds Initial-Delay at: " + dateFormatter.format(new Date(task3.scheduledExecutionTime())));

        /////////////////////////////////////Last Task////////////////////////////////////////

        Date scheduledTime2 = TimeUtils.getFutureTime(currentTime, 30000);
        ScheduledTaskA task4 = new ScheduledTaskA(0);
        timer.schedule(task4, scheduledTime2);
        System.out.println("[" + threadName + "] Task-4 scheduled to run at: "
                + dateFormatter.format(new Date(task4.scheduledExecutionTime())));

        task4.cancel();

        TimeUnit.MILLISECONDS.sleep(32000);
        System.out.println("[" + threadName + "] Cancelling the timer now...");
        timer.cancel();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
