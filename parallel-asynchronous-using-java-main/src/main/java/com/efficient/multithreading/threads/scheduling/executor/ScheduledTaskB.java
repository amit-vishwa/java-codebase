package com.efficient.multithreading.threads.scheduling.executor;

import com.efficient.multithreading.threads.scheduling.normal.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * TimerTask extension class
 * */
public class ScheduledTaskB implements Runnable {

    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public ScheduledTaskB(int sleepTime){
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ReturnedTaskB-" + instanceNumber;
    }

    @Override
    public void run() {
        Date startTime = new Date();
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] <" + taskId + "> Started at '" + dateFormatter.format(startTime) + "'");
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Date endTime = new Date();
        System.out.println("[" + threadName + "] <" + taskId + "> Completed at '" + dateFormatter.format(endTime)
                + "'\n\tRun duration '" + TimeUtils.getTimeDifferenceInSeconds(startTime, endTime) + "'\n");
    }

}
