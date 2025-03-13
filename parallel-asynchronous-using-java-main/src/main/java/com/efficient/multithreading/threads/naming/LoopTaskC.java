package com.efficient.multithreading.threads.naming;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public LoopTaskC(){

        this.instanceNumber = ++count;
        this.taskId = "LoopTaskA" + instanceNumber;
    }

    @Override
    public void run(){
//        String threadName = Thread.currentThread().getName();
        // fetching Thread from reference instead of stored variable
        System.out.println("##### [" + Thread.currentThread().getName() + "] <"
                + this.instanceNumber + "> Starting #####");
        for(int i = 5; i > 0; i--){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("[" + Thread.currentThread().getName() + "] <"
                    + this.instanceNumber + "> Tick tick: " + i);
        }
        System.out.println("##### [" + Thread.currentThread().getName() + "] <"
                + this.instanceNumber + "> Ending #####");
    }

}
