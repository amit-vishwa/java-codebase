package com.efficient.multithreading.threads.naming;

/**
 * Thread naming is done from Task (LoopTaskA) itself i.e. while running the thread
 * */
public class FirstNamingTechnique {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread started");
        new Thread(new LoopTaskA()).start();
        Thread thread = new Thread(new LoopTaskA());
        thread.start();
        System.out.println("[" + threadName + "] Main thread ended");
    }

}
