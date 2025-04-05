package com.crashcourse.executorFramework;

import java.util.List;
import java.util.concurrent.*;

/**
 * Future is returned by ExecutorService when we submit a task.
 * Below methods, we checked with Future:
 * - get(), get(time)
 * - isDone(),
 * - isCancelled()
 * */
public class FutureExample {

    public static void main(String[] args) {
//        getFutureFromExecutorService();
//        invokeAllExample();
//        invokeAnyExample();
//        futureMethods();
        cancelExample();
    }

    /**
     * Get results as Future type from executor service.
     * Runnable returns void, whereas Callable returns an object
     * get() can be used on future result to fetch the response.
     * */
    private static void getFutureFromExecutorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> System.out.println("Hello from runnable");
        Callable<String> callable = () -> "Hello from callable";
        Future<?> runnableResult = executorService.submit(runnable,"Returned runnable result");
        Future<?> runnableNoResult = executorService.submit(runnable);
        Future<?> callableResult = executorService.submit(callable);
        try {
            // Runnable returns void
            runnableNoResult.get();
            // executes runnable and returns provided result
            System.out.println(runnableResult.get());
            // Callable returns an object type
            System.out.println(callableResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        // shutdownNow() can be used above as further statements can be executed
        executorService.shutdownNow();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }

    private static void invokeAllExample(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };
        try {
            // invokeAll blocks further tasks until current ones are done
            List<Future<Integer>> futures = executorService.invokeAll(List.of(callable1,callable2,callable3));
            // we can also use time period till which invoke will work, rest thread tasks are ignored
//            List<Future<Integer>> futures = executorService.invokeAll(List.of(callable1,callable2,callable3),1,TimeUnit.SECONDS);
            futures.forEach(future -> {
                try {
                    System.out.println("Result: " + future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdownNow();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }

    private static void invokeAnyExample(){
        // 2 threads will run in parallel and after completion next will execute
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };
        try {
            // invokeAny blocks further tasks until any current one is done, returns direct result
            Integer result = executorService.invokeAny(List.of(callable1,callable2,callable3));
            // as 2 threads executed, result of any one is printed after first completion
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdownNow();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }

    private static void futureMethods(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(()->{
            // as Callable's call() throws Exception, here we don't need to handle
            Thread.sleep(2000);
            System.out.println("Hello");
            return 42;
        });
        try {
//            System.out.println(future.get());
            // below waits for 1 second to get result, else throws TimeoutException
            System.out.println(future.get(3,TimeUnit.SECONDS));
//            Thread.sleep(1000);
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdownNow();
        }
    }

    private static void cancelExample(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(()->{
            // as Callable's call() throws Exception, here we don't need to handle
            Thread.sleep(2000);
            System.out.println("Hello");
            return 42;
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // when cancel is called, isCancelled() returns true
            future.cancel(true);
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());
            executorService.shutdown();
        }
    }

}
