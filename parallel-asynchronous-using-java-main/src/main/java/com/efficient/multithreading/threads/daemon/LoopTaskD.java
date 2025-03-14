package com.efficient.multithreading.threads.daemon;

import java.util.concurrent.TimeUnit;

public class LoopTaskD implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private long sleepTime;

    public LoopTaskD(long sleepTime){
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskD" + instanceNumber;
    }

    @Override
    public void run(){
        String threadType = Thread.currentThread().isDaemon() ? "Daemon" : "User";
        System.out.println("##### [" + Thread.currentThread().getName() + "," + threadType + "] <"
                + this.instanceNumber + "> Starting #####");
        for(int i = 5; i > 0; i--){
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("[" + Thread.currentThread().getName() + "," + threadType + "] <"
                    + this.instanceNumber + "> Tick tick: " + i);
        }
        System.out.println("##### [" + Thread.currentThread().getName() + "," + threadType + "] <"
                + this.instanceNumber + "> Ending #####");
    }

}
