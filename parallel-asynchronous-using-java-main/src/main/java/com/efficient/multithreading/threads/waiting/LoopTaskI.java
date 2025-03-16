package com.efficient.multithreading.threads.waiting;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LoopTaskI implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private CountDownLatch countDownLatch;

    public LoopTaskI(CountDownLatch countDownLatch){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskI-" + instanceNumber;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        String threadType = Thread.currentThread().isDaemon() ? "Daemon" : "User";
        System.out.println("##### [" + Thread.currentThread().getName() + "," + threadType + "] <"
                + this.taskId + "> Starting #####");
        for(int i = 5; i > 0; i--){
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("[" + Thread.currentThread().getName() + "," + threadType + "] <"
                    + this.taskId + "> Tick tick: " + i);
        }
        System.out.println("##### [" + Thread.currentThread().getName() + "," + threadType + "] <"
                + this.taskId + "> Ending #####");
        if(countDownLatch != null){
            countDownLatch.countDown();

            System.out.println("[" + Thread.currentThread().getName() + "," + threadType + "] <"
                    + this.taskId + "> Latch count = " + countDownLatch.getCount());
        }
    }

}
