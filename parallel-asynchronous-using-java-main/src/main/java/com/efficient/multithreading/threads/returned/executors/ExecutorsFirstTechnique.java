package com.efficient.multithreading.threads.returned.executors;

import com.efficient.multithreading.threads.naming.LoopTaskA;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Returning values using Executors (first technique)
 * Result will be displayed in order which we are retrieving them
 * */
public class ExecutorsFirstTechnique {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+ threadName +"] Main thread starts here...");
        ExecutorService service = Executors.newCachedThreadPool(new NamedThreadsFactory());
        Future<Integer> result1 = service.submit(new CalculationTaskA(2,3,2000));
        Future<Integer> result2 = service.submit(new CalculationTaskA(3,4,1000));
        Future<Integer> result3 = service.submit(new CalculationTaskA(4,5,500));
        Future<?> result4 = service.submit(new LoopTaskA());
        Future<Double> result5 = service.submit(new LoopTaskA(), 999.888);
        service.shutdown();
        System.out.println("Result 1: " + result1.get());
        System.out.println("Result 2: " + result2.get());
        System.out.println("Result 3: " + result3.get());
        System.out.println("Result 4: " + result4.get());
        System.out.println("Result 5: " + result5.get());
        System.out.println("["+ threadName +"] Main thread ends here...");
    }

}
