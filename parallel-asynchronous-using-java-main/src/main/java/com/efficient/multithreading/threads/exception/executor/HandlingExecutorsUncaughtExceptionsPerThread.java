package com.efficient.multithreading.threads.exception.executor;

import com.efficient.multithreading.threads.exception.normal.ExceptionLeakingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Specific separate exception handler for each thread of executor service.
 * We have implemented logic to be handled by different exception handlers based on odd even millis.
 * */
public class HandlingExecutorsUncaughtExceptionsPerThread {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        ExecutorService executorService1 = Executors.newCachedThreadPool(new NamedExceptionHandlingThreadFactory());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());

        executorService1.shutdown();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
