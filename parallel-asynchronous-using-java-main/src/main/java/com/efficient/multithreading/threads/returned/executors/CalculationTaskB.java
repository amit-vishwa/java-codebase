package com.efficient.multithreading.threads.returned.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Interface can be used to return result after calculation is completed
 * */
public class CalculationTaskB implements Callable<TaskResult<String, Integer>> {

    private int a;
    private int b;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public CalculationTaskB(int a, int b, int sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "CalculationTaskA-" + instanceNumber;
    }

    @Override
    public TaskResult<String, Integer> call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] <" + taskId + "> Starting");
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        System.out.println("[" + threadName + "] <" + taskId + "> Ending");
        return new TaskResult<String, Integer>(taskId,a+b);
    }

}
