package com.efficient.multithreading.threads.terminate.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskA implements Callable<Long> {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private volatile boolean shutdown = false;

    private long a, sleepTime, factorial;

    public FactorialTaskA(long a, long sleepTime){
        this.a = a;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "FactorialTaskA-" + instanceNumber;
    }

    @Override
    public Long call() throws Exception{
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Starting #####");
        factorial = 1L;
        for(long i = 1; i <= a; i++){
            factorial *= i;
            System.out.println("[" + threadName + "] <" + this.taskId + "> Iteration - "
                    + i + " Intermediate result = " + factorial);
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            synchronized (this){
                if (shutdown){
                    factorial = -1;
                    break;
                }
            }
        }
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Ending #####");
        return factorial;
    }

    public void cancel(){
        System.out.println("##### [" + Thread.currentThread().getName() + "] <"
                + this.taskId + "> Shutting down #####");
        synchronized (this){
            shutdown = true;
        }
    }

}
