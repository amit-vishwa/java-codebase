package com.efficient.multithreading.threads.exception.normal;

public class ExceptionLeakingTask implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
