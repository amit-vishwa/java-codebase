package com.efficient.multithreading.threads.create;

import java.util.concurrent.TimeUnit;

/**
 * In second technique of creating and running a thread,
 * start() is called by class object as Thread is super class.
 * */
public class SecondTechnique {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        Thread thread = new SecondTask();
        thread.start();
        thread.join(); // waits to complete this thread task
        new SecondTask().start();
        System.out.println("Main thread ended");
    }

}

class SecondTask extends Thread {

    private static int count = 0;
    private int id;

    public SecondTask(){
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
