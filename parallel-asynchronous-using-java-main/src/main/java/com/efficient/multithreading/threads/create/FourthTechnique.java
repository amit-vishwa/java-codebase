package com.efficient.multithreading.threads.create;

import java.util.concurrent.TimeUnit;

/**
 * In fourth technique, the class implements Runnable interface.
 * After overriding the run(), the thread object is created in main()
 * and class implementing Runnable object is passed to thread and start() is called.
 * Here the thread object or reference can be created in main().
 * */
public class FourthTechnique {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        new Thread(new FourthTask()).start();
        Thread thread = new Thread(new FourthTask());
        thread.start();
        thread.join();
        System.out.println("Main thread ended");
    }

}

class FourthTask implements Runnable {

    private static int count = 0;
    private int id;

    public FourthTask(){
        this.id = ++count;
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
