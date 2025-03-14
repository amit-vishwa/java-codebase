package com.efficient.multithreading.threads.returned.executors;

import com.efficient.multithreading.threads.returned.ResultListener;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Interface can be used to return result after calculation is completed
 * */
public class CalculationTaskA implements Callable<Integer> {

    private int a;
    private int b;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public CalculationTaskA(int a, int b, int sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "CalculationTaskA-" + instanceNumber;
    }

    @Override
    public Integer call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] <" + taskId + "> Starting");
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        System.out.println("[" + threadName + "] <" + taskId + "> Ending");
        return a+b;
    }

}
