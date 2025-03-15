package com.efficient.multithreading.threads.terminate.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskB implements Callable<Long> {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private long a, sleepTime, factorial;

    public FactorialTaskB(long a, long sleepTime){
        this.a = a;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "FactorialTaskB-" + instanceNumber;
    }

    @Override
    public Long call(){
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Starting #####");
        factorial = 1L;
        for(long i = 1; i <= a; i++){
            factorial *= i;
            System.out.println("[" + threadName + "] <" + this.taskId + "> Iteration - "
                    + i + " Intermediate result = " + factorial);
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("##### [" + threadName + "] <" + this.taskId + "> Sleep interrupted, cancelling #####");
                factorial = -1;
                break;
            }
        }
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Ending #####");
        return factorial;
    }

}
