package com.efficient.multithreading.threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The ExecutorService is more advanced and introduce in latest version of Java.
 * The service can be created using a cached thread pool.
 * Here no parameters required to create threads.
 * */
public class CachedThreadPool {

    public static void main(String[] args) {
        System.out.println("Main thread started");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++){
            executorService.execute(new LoopTaskB());
        }
        executorService.shutdown();
        System.out.println("Main thread ended");
    }

}

