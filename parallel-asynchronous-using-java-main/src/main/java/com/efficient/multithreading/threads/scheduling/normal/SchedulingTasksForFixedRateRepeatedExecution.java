package com.efficient.multithreading.threads.scheduling.normal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 *  Execute scheduled tasks repeatedly with a fixed rate of execution.
 *  Here, timer method scheduleAtFixedRate() is used, it works similar to schedule()
 *  only the millis difference does not occur.
 * */
public class SchedulingTasksForFixedRateRepeatedExecution {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Timer timer = new Timer("Timer-thread", true);
        Date currentTime = new Date();

        System.out.println("[" + threadName + "] Current time: " + dateFormatter.format(currentTime));

        Date scheduledTime = TimeUtils.getFutureTime(currentTime, 3000); // run after 3s
        long intervalInMillis = 2000; // 2s interval of task 1
        timer.scheduleAtFixedRate(new ScheduledTaskA(1000), scheduledTime, intervalInMillis);

        System.out.println("[" + threadName + "] Task-1 first run scheduled for '" + dateFormatter.format(scheduledTime)
                + "' and then repeatedly at an interval of every " + TimeUtils.convertToFractionalSecondsStr(0, intervalInMillis));

        //////////////////////////////////////Next task///////////////////////////////////////////////

        long delayMillis = 4000; // run after 4s of current time
        long intervalMillis = 4000; // 4s interval for task 2
        timer.scheduleAtFixedRate(new ScheduledTaskA(1000), delayMillis, intervalMillis);
        System.out.println("[" + threadName + "] Task-2 first run scheduled for '" + TimeUtils.convertToFractionalSecondsStr(0, delayMillis)
                + " after " + dateFormatter.format(currentTime)
                + "' and then repeatedly at an interval of every " + TimeUtils.convertToFractionalSecondsStr(0, intervalMillis));

        TimeUnit.MILLISECONDS.sleep(10000); // cancels timer and terminates thread after 16s
        System.out.println("[" + threadName + "] Cancelling the timer now...");
        timer.cancel();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
