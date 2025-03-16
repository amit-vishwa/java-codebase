package com.efficient.multithreading.threads.exception.normal;

/**
 * Exceptions thrown by Threads cannot be caught using exception handlers.
 * Separate class needs to be created that implements UncaughtExceptionHandler.
 * Instance of that class needs to be passed in setDefaultUncaughtExceptionHandler().
 * */
public class HandlingUncaughtExceptionsForEveryThread {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));
        new Thread(new ExceptionLeakingTask(), "Thread-1").start();
        new Thread(new ExceptionLeakingTask(), "Thread-2").start();
        new Thread(new ExceptionLeakingTask(), "Thread-3").start();
        new Thread(new ExceptionLeakingTask(), "Thread-4").start();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
