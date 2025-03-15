package com.efficient.multithreading.threads.terminate.executor;

import com.efficient.multithreading.threads.naming.NamedThreadsFactory;
import com.efficient.multithreading.threads.terminate.normal.LoopTaskE;
import com.efficient.multithreading.threads.terminate.normal.LoopTaskF;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Terminate a non-blocked thread of executor service using the second technique.
 * ExecutorService can run the Callable or Runnable and can stop both.
 * Future instance can be used to cancel the thread and interrupted flag
 * to fetch current status of the thread.
 * */
public class ExecutorTerminationSecondTechnique {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");
//        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        ExecutorService executorService = Executors.newFixedThreadPool(2, new NamedThreadsFactory());
        Future<Long> futureTask1 = executorService.submit(new CalculationTaskC());
        Future<?> futureTask2 = executorService.submit(new LoopTaskF());
        Future<?> futureTask3 = executorService.submit(new LoopTaskF());
        executorService.shutdown();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("[" + threadName + "] Interrupting 'CalculationTaskC-1'...");
        System.out.println("Result of cancelling task 'CalculationTaskC-1': "
                + futureTask1.cancel(true));
        System.out.println("[" + threadName + "] Interrupting 'LoopTaskF-1'...");
        System.out.println("Result of cancelling task 'LoopTaskF-1': "
                + futureTask2.cancel(true));
        System.out.println("[" + threadName + "] Interrupting 'LoopTaskF-2'...");
        // since pool consist of size 2, so 3rd task is removed with no errors and cancel returns true
        System.out.println("Result of cancelling task 'LoopTaskF-2': "
                + futureTask3.cancel(true));
        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
