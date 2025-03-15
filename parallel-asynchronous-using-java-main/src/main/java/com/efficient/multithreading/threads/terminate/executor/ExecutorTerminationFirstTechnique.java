package com.efficient.multithreading.threads.terminate.executor;

import com.efficient.multithreading.threads.naming.NamedThreadsFactory;
import com.efficient.multithreading.threads.terminate.normal.LoopTaskE;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Terminate a non-blocked thread of executor service using the first technique.
 * ExecutorService can run the Callable or Runnable and can stop both.
 * A flag can be set to break the execution of thread when cancel() is called.
 * */
public class ExecutorTerminationFirstTechnique {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        LoopTaskE task1 = new LoopTaskE();
        FactorialTaskA task2 = new FactorialTaskA(30, 1000);
        executorService.execute(task1);
        executorService.submit(task2);
        executorService.shutdown();
        TimeUnit.MILLISECONDS.sleep(3000);
        task1.cancel();
        task2.cancel();
        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
