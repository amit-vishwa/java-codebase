package com.efficient.multithreading.threads.returned;

import java.util.concurrent.TimeUnit;

/**
 * Interface can be used to return result after calculation is completed
 * */
public class ReturnedTaskB implements Runnable {

    private int a;
    private int b;
    private int sum;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private ResultListener<Integer> resultProcessor;

    public ReturnedTaskB(int a, int b, int sleepTime, ResultListener<Integer> resultProcessor){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.resultProcessor = resultProcessor;
        this.taskId = "ReturnedTaskA-" + instanceNumber;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] <" + taskId + "> Starting");
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sum = a + b;
        System.out.println("[" + threadName + "] <" + taskId + "> Ending");
        resultProcessor.notifyResult(sum);
    }

}
