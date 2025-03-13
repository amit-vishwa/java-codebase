package com.efficient.multithreading.threads.naming;

import java.util.concurrent.TimeUnit;

/**
 * Thread naming is done from method invoking the task.
 * Thread name can be passed along with Task object or use setName().
 * Thread name is updated and always fetched from its reference.
 * Updating thread name at runtime is not recommended (only extreme exceptions)
 * as thread name in task should be fetched from direct reference.
 * */
public class SecondNamingTechnique {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread started");
        new Thread(new LoopTaskC(), "Worker-1").start();
        Thread thread = new Thread(new LoopTaskC());
        thread.start();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Renaming Thread-0 to Worker-2");
        thread.setName("Worker-2"); // setting thread name at runtime
        System.out.println("[" + threadName + "] Main thread ended");
    }

}
