package com.efficient.multithreading.threads.exception.normal;

/**
 * When ExceptionHandlers are specified then those are used else Default one is used.
 * */
public class HandlingUncaughtExceptionsDefaultOverrides {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        // Below will be used for all threads that do not have their own exception handler
        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));
        Thread thread1 = new Thread(new ExceptionLeakingTask(), "Thread-1");
        thread1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        Thread thread2 = new Thread(new ExceptionLeakingTask(), "Thread-2");
        Thread thread3 = new Thread(new ExceptionLeakingTask(), "Thread-3");
        thread3.setUncaughtExceptionHandler(new ThreadExceptionNotifier());
        Thread thread4 = new Thread(new ExceptionLeakingTask(), "Thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
