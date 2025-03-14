package com.efficient.multithreading.threads.daemon;

import com.efficient.multithreading.threads.naming.LoopTaskC;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JVM terminates daemon threads if it is not completed and user threads are completed,
 * before terminating the program.
 * */
public class ExecutorDaemonThreads {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread started");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedDaemonThreadsFactory());
        executorService.execute(new LoopTaskD(100));
        executorService.execute(new LoopTaskD(200));
        executorService.execute(new LoopTaskD(300));
        executorService.execute(new LoopTaskD(400));
        executorService.shutdown();
        System.out.println("[" + threadName + "] Main thread ended");
    }

}
