package com.crashcourse.completableFuture;

import java.util.concurrent.*;

/**
 * By default, CompletableFuture tasks often run on daemon threads due to the use
 * of ForkJoinPool.commonPool. Daemon threads do not prevent the JVM from exiting.
 * We can control thread type by providing a custom executor service.
 * We can use a custom Executor to run tasks on non-daemon threads.
 * The CompletableFuture task itself doesn't dictate whether its daemon or user thread.
 * */
public class CompletableFutureExample {

    public static void main(String[] args) {
//        simpleCFExample();
//        multipleCFExample();
        exceptionCFExample();
    }

    /**
     * Simple use case of CompletableFuture.
     * It takes a supplier in the argument and returns CompletableFuture.
     * get() or join() can be used with it to get the returned result.
     * */
    private static void simpleCFExample(){
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Worker thread executing...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "OK";
        });
        // join() works similar to get() only exception is not thrown
//        System.out.println(completableFuture.join());
        try {
            // getNow() returns provided parameter result if thread is not completed its task yet
            System.out.println(completableFuture.getNow("Result in progress..."));
            System.out.println(completableFuture.get());
            System.out.println("Executing main thread...");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * We can use allOf() or anyOf() on list of CompletableFuture.
     * allOf() will wait for completion of all execution threads.
     * anyOf() will wait for completion of any one thread.
     * */
    private static void multipleCFExample(){
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Worker thread1 executing...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "OK";
        });
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Worker thread2 executing...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "OK";
        });
        // allOf() waits for all tasks to get finished
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(task1, task2);
        // anyOf() waits for only any one task to get finished
//        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(task1, task2);
        System.out.println(completableFuture.join()); // leave this to wait for all tasks to finish
        System.out.println(task1.join() + " " + task2.join()); // get individual results
        System.out.println("Executing main thread...");
    }

    /**
     * Simple orTimeout() will throw TimeoutException, that can be handled in exceptionally()
     * */
    private static void exceptionCFExample(){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Worker thread1 executing...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "OK";
        }, executor); // if threadPool is already created then it can also be used for thread management
        CompletableFuture<String> result = task
                // thenApply() will work with CompletableFuture result to perform operations on it
                .thenApply(res -> res + " " + res)
                .orTimeout(1500, TimeUnit.MILLISECONDS)
                .exceptionally(s -> "Timeout occurred");
        System.out.println(result.join());
        executor.shutdown(); // shutdown the executor
    }

}
