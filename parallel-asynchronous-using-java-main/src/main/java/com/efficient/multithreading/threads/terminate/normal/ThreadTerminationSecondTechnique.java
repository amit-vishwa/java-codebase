package com.efficient.multithreading.threads.terminate.normal;

import java.util.concurrent.TimeUnit;

/**
 * Second technique to terminate a normal non-blocked thread using interrupt.
 * */
public class ThreadTerminationSecondTechnique {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");
        Thread thread1 = new Thread(new LoopTaskF(), "Thread-1");
        Thread thread2 = new Thread(new LoopTaskF(), "Thread-2");
        Thread thread3 = new Thread(new LoopTaskF(), "Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("[" + threadName + "] Interrupting "+thread1.getName()+"...");
        thread1.interrupt();
        System.out.println("[" + threadName + "] Interrupting "+thread2.getName()+"...");
        thread2.interrupt();
        System.out.println("[" + threadName + "] Interrupting "+thread3.getName()+"...");
        thread3.interrupt();
        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
