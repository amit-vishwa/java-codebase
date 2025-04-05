package com.crashcourse.countDownLatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class DependentLatchService implements Callable<String> {

    private final CountDownLatch countDownLatch;

    public DependentLatchService(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started...");
            Thread.sleep(1000);
        } finally {
            countDownLatch.countDown();
        }
        return "ok";
    }

}
