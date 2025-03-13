package com.efficient.multithreading.threads.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor thread can be renamed by using a class implementing ThreadFactory interface.
 * newThread() of ThreadFactory must be overridden and naming logic must be added.
 * By default executor will have naming convention as pool-n-thread-m.
 * */
public class ExecutorThreadNaming {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread started");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        for(int i = 0; i < 3; i++){
            executorService.execute(new LoopTaskC());
        }
        executorService.shutdown();
        System.out.println("[" + threadName + "] Main thread ended");
    }

}
