package com.efficient.multithreading.threads.exception.executor;

import com.efficient.multithreading.threads.exception.normal.ExceptionLeakingTask;
import com.efficient.multithreading.threads.exception.normal.ThreadExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Common default exception handler for all executor service.
 * */
public class HandlingExecutorsUncaughtExceptionsForEveryThread {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());

        executorService1.shutdown();
        executorService2.shutdown();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
