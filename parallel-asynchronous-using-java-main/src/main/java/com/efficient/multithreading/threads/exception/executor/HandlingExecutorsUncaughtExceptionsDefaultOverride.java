package com.efficient.multithreading.threads.exception.executor;

import com.efficient.multithreading.threads.exception.normal.ExceptionLeakingTask;
import com.efficient.multithreading.threads.exception.normal.ThreadExceptionHandler;
import com.efficient.multithreading.threads.exception.normal.ThreadExceptionNotifier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * When no exception handler is specified then default one is used.
 * Alternate thread factory will handle exceptions with even names using notifier.
 * For rest default handler will be used.
 * */
public class HandlingExecutorsUncaughtExceptionsDefaultOverride {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        ExecutorService executorService1 = Executors.newCachedThreadPool(new NamedExceptionHandlingAlternateThreadFactory());
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
