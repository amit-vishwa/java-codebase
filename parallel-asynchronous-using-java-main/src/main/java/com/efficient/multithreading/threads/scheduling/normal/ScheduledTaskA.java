package com.efficient.multithreading.threads.scheduling.normal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * TimerTask extension class
 * */
public class ScheduledTaskA extends TimerTask {

    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public ScheduledTaskA(int sleepTime){
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ReturnedTaskA-" + instanceNumber;
    }

    @Override
    public void run() {
        Date startTime = new Date();
        Date scheduledTime = new Date(super.scheduledExecutionTime());
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] <" + taskId + "> Scheduled to run at '"
                + dateFormatter.format(scheduledTime) + "', actually started at '" + dateFormatter.format(startTime) + "'");
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Date endTime = new Date();
        System.out.println("[" + threadName + "] <" + taskId + "> Completed at '" + dateFormatter.format(endTime)
                + "'\n\t Delayed start by '" + TimeUtils.getTimeDifferenceInSeconds(scheduledTime, startTime)
                + "'\n\t Run duration '" + TimeUtils.getTimeDifferenceInSeconds(startTime, endTime) + "'\n");
    }

}
