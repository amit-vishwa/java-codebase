package com.crashcourse.countDownLatch;

import java.util.concurrent.*;

/**
 * CountDownLatch is a synchronization aid that allows one or more threads to wait until a
 * set of operations being performed in other threads completes.
 * Once the count reaches 0, it cannot be reset.
 * Thus, CountDownLatch can be used once.
 * It can be used with simple thread.
 * */
public class CountDownLatchExample {

    public static void main(String[] args) {
        simpleExecutorExample();
        countDownLatchExample();
    }

    private static void simpleExecutorExample(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependentService());
        Future<String> future2 = executorService.submit(new DependentService());
        Future<String> future3 = executorService.submit(new DependentService());
        try {
            future1.get();
            future2.get();
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("All dependent services finished, starting main service...");
            executorService.shutdown();
        }
    }

    private static void countDownLatchExample(){
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch countDownLatch = new CountDownLatch(numberOfServices);
        // we can create threads using Thread class and perform the latch operations
        executorService.submit(new DependentLatchService(countDownLatch));
        executorService.submit(new DependentLatchService(countDownLatch));
        executorService.submit(new DependentLatchService(countDownLatch));
        try {
            countDownLatch.await();
            // we can set a waiting period for the latch
//            countDownLatch.await(500,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("All dependent latch services finished, starting main service...");
            executorService.shutdown();
        }
    }

}
