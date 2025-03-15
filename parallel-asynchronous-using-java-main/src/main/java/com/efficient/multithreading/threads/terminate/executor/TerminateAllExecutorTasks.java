package com.efficient.multithreading.threads.terminate.executor;

import com.efficient.multithreading.threads.executor.LoopTaskB;
import com.efficient.multithreading.threads.naming.LoopTaskA;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;
import com.efficient.multithreading.threads.returned.executors.CalculationTaskB;
import com.efficient.multithreading.threads.returned.executors.TaskResult;
import com.efficient.multithreading.threads.terminate.normal.LoopTaskF;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.*;

/**
 * Program demonstrates termination of all executor tasks in one go.
 * Blocked runnable - LoopTaskA, Non-blocked runnable - LoopTaskF
 * Blocked callable - FactorialTaskB, Non-blocked callable - CalculationTaskC, CalculationTaskB
 * */
public class TerminateAllExecutorTasks {

    public static void main(String[] args) throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        executorService.execute(new LoopTaskB());
        executorService.execute(new LoopTaskF());
        Future<Long> futureTask3 = executorService.submit(new FactorialTaskB(30, 500));
        Future<Long> futureTask4 = executorService.submit(new CalculationTaskC());
        Future<TaskResult<String,Integer>> futureTask5 = executorService.submit(new CalculationTaskB(2,3,9000));
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("[" + threadName + "] Shutting down now...");
        executorService.shutdownNow(); // except task 5, rest all interrupts with no issues
        System.out.println("[" + threadName + "] All threads terminated = "
                + executorService.awaitTermination(500, TimeUnit.MILLISECONDS));
        System.out.println("[" + threadName + "] 'FactorialTaskB-1' result = " + futureTask3.get());
        System.out.println("[" + threadName + "] 'CalculationTaskC-1' result = " + futureTask4.get());
        try{
            System.out.println("[" + threadName + "] 'CalculationTaskB-1' result = " + futureTask5.get());
        } catch (ExecutionException e) {
            System.out.println("[" + threadName + "] 'CalculationTaskB-1' result = Execution exception due to:");
            StringWriter sw = new StringWriter();
            e.getCause().printStackTrace(new PrintWriter(sw));
            System.out.println(sw);
        }
        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
