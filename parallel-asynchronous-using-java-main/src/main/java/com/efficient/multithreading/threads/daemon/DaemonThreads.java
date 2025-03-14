package com.efficient.multithreading.threads.daemon;

/**
 * Daemon threads run in the background.
 * When user thread is stopped, program terminates without waiting for daemon thread completion.
 * Daemon thread can also complete before user thread of program termination,
 * it does not require to wait for program termination.
 * */
public class DaemonThreads {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+ threadName +"] Main thread starts here...");
        Thread thread1 = new Thread(new LoopTaskD(500), "Thread-1");
        Thread thread2 = new Thread(new LoopTaskD(400), "Thread-2");
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        System.out.println("["+ threadName +"] Main thread ends here...");
    }

}
