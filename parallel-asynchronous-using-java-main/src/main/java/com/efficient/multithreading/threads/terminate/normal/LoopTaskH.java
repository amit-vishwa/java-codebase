package com.efficient.multithreading.threads.terminate.normal;

import java.util.concurrent.TimeUnit;

public class LoopTaskH implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private boolean sleepInterrupted = false;

    public LoopTaskH(){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskH-" + instanceNumber;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Starting #####");
        for(int i = 1; ;i++){
            System.out.println("[" + threadName + "] <" + this.taskId + "> Tick tick: " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random()*3000));
            } catch (InterruptedException e) {
                System.out.println("##### [" + threadName
                        + "] <" + this.taskId + "> Sleep interrupted, setting the flag #####");
                sleepInterrupted = true;
            }
            doSomeMoreWork();
            if(sleepInterrupted || Thread.interrupted()){
                System.out.println("##### [" + threadName
                        + "] <" + this.taskId + "> Interrupted, cancelling #####");
                break;
            }
        }
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Ending #####");
    }

    private void doSomeMoreWork() {
        System.out.println("##### [" + Thread.currentThread().getName()
                + "] <" + this.taskId + "> Doing some more work #####");
    }

}
