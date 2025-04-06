package com.crashcourse.cyclicBarrier;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class DependentBarrierService implements Callable<String> {

    private final CyclicBarrier barrier;

    public DependentBarrierService(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started...");
        Thread.sleep(1000); // simulating some work
        System.out.println(Thread.currentThread().getName() + " is waiting at barrier...");
        barrier.await();
        return "ok";
    }

}
