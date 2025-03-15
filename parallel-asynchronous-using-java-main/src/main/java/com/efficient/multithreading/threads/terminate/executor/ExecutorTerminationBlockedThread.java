package com.efficient.multithreading.threads.terminate.executor;

import com.efficient.multithreading.threads.executor.LoopTaskB;
import com.efficient.multithreading.threads.naming.LoopTaskA;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;
import com.efficient.multithreading.threads.terminate.normal.LoopTaskG;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * We can throw and catch exception for Blocked thread and break the loop.
 * */
public class ExecutorTerminationBlockedThread {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        Future<?> future1 = executorService.submit(new LoopTaskB());
        Future<?> future2 = executorService.submit(new LoopTaskG());
        Future<Long> future3 = executorService.submit(new FactorialTaskB(30, 500));
        executorService.shutdown();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("[" + threadName + "] Invoking cancel() on all tasks...");
        future1.cancel(true);
        future2.cancel(true);
        future3.cancel(true);
        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
