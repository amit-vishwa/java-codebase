package com.efficient.multithreading.threads.returned.executors;

import com.efficient.multithreading.threads.naming.LoopTaskA;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

import java.util.concurrent.*;

/**
 * Returning values using Executors (second technique)
 * Result will be displayed in order of completion
 * */
public class ExecutorsSecondTechnique {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+ threadName +"] Main thread starts here...");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        CompletionService<TaskResult<String,Integer>> completionService = new ExecutorCompletionService<TaskResult<String,Integer>>(executorService);
        completionService.submit(new CalculationTaskB(2,3,2000));
        completionService.submit(new CalculationTaskB(3,4,1000));
        completionService.submit(new CalculationTaskB(4,5,500));
        completionService.submit(new LoopTaskA(), new TaskResult<String,Integer>("LoopTaskA-1",999));
        executorService.shutdown();
        for(int i = 1; i < 5; i++){
            System.out.println(completionService.take().get());
        }
        System.out.println("["+ threadName +"] Main thread ends here...");
    }

}
