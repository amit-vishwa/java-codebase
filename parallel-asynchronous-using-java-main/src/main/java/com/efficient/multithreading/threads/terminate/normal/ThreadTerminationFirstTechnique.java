package com.efficient.multithreading.threads.terminate.normal;

import java.util.concurrent.TimeUnit;

/**
 * First technique to terminate a normal thread.
 * */
public class ThreadTerminationFirstTechnique {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");
        LoopTaskE task1 = new LoopTaskE();
        LoopTaskE task2 = new LoopTaskE();
        LoopTaskE task3 = new LoopTaskE();
        LoopTaskE task4 = new LoopTaskE();
        new Thread(task1, "Thread-1").start();
        new Thread(task2, "Thread-2").start();
        new Thread(task3, "Thread-3").start();
        new Thread(task4, "Thread-4").start();
        TimeUnit.MILLISECONDS.sleep(5000);
        task1.cancel();
        task2.cancel();
        task3.cancel();
        task4.cancel();
        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
