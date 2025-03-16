package com.efficient.multithreading.threads.waiting;

import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * We can wait for tasks to get finished using CountDownLatch.
 * We can put the count equal to number of tasks and await for tasks to finish.
 * Once count is reduced to 0, it gives signal to continue.
 * */
public class JoiningExecutorTasks {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+ threadName +"] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CountDownLatch countDownLatch = new CountDownLatch(4);
        // await() will wait for first 2 tasks to finish and give go ahead signal
//        CountDownLatch countDownLatch = new CountDownLatch(2);

        executorService.execute(new LoopTaskI(countDownLatch));
        // when countDownLatch is null then count down is not decremented
//        executorService.execute(new LoopTaskI(null));
        executorService.execute(new LoopTaskI(countDownLatch));
        executorService.execute(new LoopTaskI(countDownLatch));
        // when countDownLatch is null then count down is not updated
//        executorService.execute(new LoopTaskI(null));
        executorService.execute(new LoopTaskI(countDownLatch));

        executorService.shutdown();

        try{
            // count should be less than or equal to tasks else
            // program won't stop as it will wait for count 0
            countDownLatch.await();
            System.out.println("[" + threadName + "] Got the signal to continue...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("["+ threadName +"] Main thread ends here...");
    }

}
