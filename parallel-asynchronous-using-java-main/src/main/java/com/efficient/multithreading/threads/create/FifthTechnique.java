package com.efficient.multithreading.threads.create;

import java.util.concurrent.TimeUnit;

/**
 * In fifth technique, the anonymous class is passed
 * as an argument to Thread constructor.
 * */
public class FifthTechnique {

    public static void main(String[] args) {
        System.out.println("Main thread started");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 10; i > 0; i--){
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Tick tick: " + i);
                }
            }
        });
        thread.start();
        System.out.println("Main thread ended");
    }

}
