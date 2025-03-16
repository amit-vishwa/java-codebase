package com.efficient.multithreading.threads.exception.normal;

/**
 * Exceptions thrown by Threads cannot be caught using exception handlers.
 * Separate class needs to be created that implements UncaughtExceptionHandler.
 * Instance of that class needs to be passed in setDefaultUncaughtExceptionHandler().
 * Handling uncaught exceptions for each thread.
 * */
public class HandlingUncaughtExceptionsPerThread {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Thread thread1 = new Thread(new ExceptionLeakingTask(), "Thread-1");
        thread1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        Thread thread4 = new Thread(new ExceptionLeakingTask(), "Thread-4");
        thread4.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        Thread thread2 = new Thread(new ExceptionLeakingTask(), "Thread-2");
        thread2.setUncaughtExceptionHandler(new ThreadExceptionNotifier());
        Thread thread3 = new Thread(new ExceptionLeakingTask(), "Thread-3");
        thread3.setUncaughtExceptionHandler(new ThreadExceptionNotifier());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
