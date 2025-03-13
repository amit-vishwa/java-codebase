package com.efficient.multithreading.threads.create;

import java.util.concurrent.TimeUnit;

/**
 * In third technique, the class implements Runnable interface.
 * After overriding the run(), the thread object is created in constructor
 * and class implementing Runnable object is passed to thread and start() is called.
 * Here no thread object can be created or ref can be captured in main() as it implements Runnable.
 * */
public class ThirdTechnique {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        new ThirdTask();
        new ThirdTask();
        System.out.println("Main thread ended");
    }

}

class ThirdTask implements Runnable {

    private static int count = 0;
    private int id;

    public ThirdTask(){
        this.id = ++count;
        new Thread(this).start();
    }

    @Override
    public void run(){
        for(int i = 10; i > 0; i--){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("<" + this.id + "> Tick tick: " + i);
        }
    }

}
