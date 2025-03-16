package com.efficient.multithreading.threads.returned;

import java.util.concurrent.TimeUnit;

/**
 * Will be using join() to return values.
 * */
public class ReturnedTaskC implements Runnable {

    private int a;
    private int b;
    private int sum;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public ReturnedTaskC(int a, int b, int sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ReturnedTaskC-" + instanceNumber;
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
    }

    public int getSum(){
        return sum; // return after sync
    }

}
