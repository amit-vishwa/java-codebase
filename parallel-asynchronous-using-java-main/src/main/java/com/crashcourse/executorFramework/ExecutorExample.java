package com.crashcourse.executorFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        executionUsingExecutor();
    }

    /**
     * Thread execution can be done with Executor interface.
     * This cannot be shutdown, manual intervention required.
     * It uses execute().
     * */
    private static void executionUsingExecutor(){
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executor.execute(() -> System.out.println(ExecutorServiceExample.factorial(finalI)));
        }
    }
}
