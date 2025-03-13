package com.efficient.multithreading.threads.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Threads are re-used in CachedThreadPool when they are available.
 * */
public class CachedThreadPoolExecution {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread started");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        for(int i = 0; i < 2; i++){
            executorService.execute(new LoopTaskC());
        }
        // Threads when get completed then those will be utilised for other scheduled tasks
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("Executing 4 new tasks");
        for(int i = 0; i < 4; i++){
            executorService.execute(new LoopTaskC());
        }
        executorService.shutdown();
        System.out.println("[" + threadName + "] Main thread ended");
    }

}
