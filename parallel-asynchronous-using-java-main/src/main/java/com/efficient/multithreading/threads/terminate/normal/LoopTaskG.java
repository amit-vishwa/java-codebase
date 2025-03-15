package com.efficient.multithreading.threads.terminate.normal;

import java.util.concurrent.TimeUnit;

public class LoopTaskG implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public LoopTaskG(){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskG-" + instanceNumber;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Starting #####");
        for(int i = 1; ;i++){
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random()*3000));
            } catch (InterruptedException e) {
                System.out.println("##### [" + threadName
                        + "] <" + this.taskId + "> Sleep interrupted, cancelling #####");
                break;
            }
            System.out.println("[" + threadName + "] <" + this.taskId + "> Tick tick: " + i);
        }
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Ending #####");
    }

}
