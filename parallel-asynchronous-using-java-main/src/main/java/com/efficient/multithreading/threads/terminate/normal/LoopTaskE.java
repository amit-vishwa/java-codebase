package com.efficient.multithreading.threads.terminate.normal;

import java.util.concurrent.TimeUnit;

public class LoopTaskE implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private volatile boolean shutdown = false;

    public LoopTaskE(){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskE-" + instanceNumber;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Starting #####");
        for(int i = 1; ;i++){
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random()*3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("[" + threadName + "] <" + this.taskId + "> Tick tick: " + i);
            synchronized (this){
                if (shutdown) break;
            }
        }
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Ending #####");
    }

    public void cancel(){
        System.out.println("##### [" + Thread.currentThread().getName() + "] <"
                + this.taskId + "> Shutting down #####");
        synchronized (this){
            shutdown = true;
        }
    }

}
