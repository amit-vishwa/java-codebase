package com.efficient.multithreading.threads.scheduling.executor;

import com.efficient.multithreading.threads.scheduling.normal.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Interface can be used to return result after calculation is completed
 * */
public class CalculationTaskD implements Callable<Integer> {

    private int a;
    private int b;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public CalculationTaskD(int a, int b, int sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "CalculationTaskD-" + instanceNumber;
    }

    @Override
    public Integer call() throws Exception {
        Date startTime = new Date();
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] <" + taskId + "> Started at " + dateFormatter.format(startTime));
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        Date endTime = new Date();
        System.out.println("[" + threadName + "] <" + taskId + "> Ended at " + dateFormatter.format(endTime)
                + "'\n\tRun duration '" + TimeUtils.getTimeDifferenceInSeconds(startTime, endTime) + "'\n");
        return a+b;
    }

}
