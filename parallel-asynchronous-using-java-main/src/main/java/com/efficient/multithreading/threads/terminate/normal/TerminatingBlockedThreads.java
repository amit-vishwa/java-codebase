package com.efficient.multithreading.threads.terminate.normal;

import java.util.concurrent.TimeUnit;

/**
 * Terminate a normal blocked thread.
 * Threads can be interrupted while they are on sleep and can be terminated.
 * We can also set a flag and perform some task after blocked thread's
 * sleep interruption and add a check to interrupt of terminate the thread
 * as coded in LoopTaskH.
 * */
public class TerminatingBlockedThreads {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");
        Thread thread1 = new Thread(new LoopTaskG(), "Thread-1");
        Thread thread2 = new Thread(new LoopTaskG(), "Thread-2");
        Thread thread3 = new Thread(new LoopTaskG(), "Thread-3");
        Thread thread4 = new Thread(new LoopTaskH(), "Thread-4");
        Thread thread5 = new Thread(new LoopTaskH(), "Thread-5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("[" + threadName + "] Interrupting "+thread1.getName()+"...");
        thread1.interrupt();
        System.out.println("[" + threadName + "] Interrupting "+thread2.getName()+"...");
        thread2.interrupt();
        System.out.println("[" + threadName + "] Interrupting "+thread3.getName()+"...");
        thread3.interrupt();
        System.out.println("[" + threadName + "] Interrupting "+thread4.getName()+"...");
        thread4.interrupt();
        System.out.println("[" + threadName + "] Interrupting "+thread5.getName()+"...");
        thread5.interrupt();
        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
