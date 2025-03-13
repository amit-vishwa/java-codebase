package com.efficient.multithreading.threads.naming;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public LoopTaskA(){

        this.instanceNumber = ++count;
        this.taskId = "LoopTaskA" + instanceNumber;
    }

    @Override
    public void run(){
        Thread.currentThread().setName("Worker-" + instanceNumber);
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.instanceNumber + "> Starting #####");
        for(int i = 5; i > 0; i--){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("[" + threadName + "] <" + this.instanceNumber + "> Tick tick: " + i);
        }
        System.out.println("##### [" + threadName + "] <" + this.instanceNumber + "> Ending #####");
    }

}
