package com.crashcourse.countDownLatch;

import java.util.concurrent.Callable;

public class DependentService implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started...");
        Thread.sleep(1000);
        return "ok";
    }

}
