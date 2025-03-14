package com.efficient.multithreading.threads.returned;

import java.util.concurrent.TimeUnit;

/**
 * Synchronization process is used for task completion
 * wait() is used to make thread wait
 * notify() is used to notify when task is completed
 * */
public class ReturnedTaskA implements Runnable {

    private int a;
    private int b;
    private int sum;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private volatile boolean done = false;

    public ReturnedTaskA(int a, int b, int sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
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
        done = true; // set boolean to true after calculation
        synchronized (this){ // sync is used to wait for the task completion
            System.out.println("[" + threadName + "] <" + taskId + "> Notifying");
            this.notify(); // notify must be called when wait is invoked
        }
    }

    public int getSum(){
        // wait until the task is done
        synchronized (this){
            if (!done){ // not true, then wait
                try {
                    System.out.println("[" + Thread.currentThread().getName() + "] <"
                            + taskId + "> Waiting");
                    this.wait(); // notify must be called after wait
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return sum; // return after sync
    }

}
