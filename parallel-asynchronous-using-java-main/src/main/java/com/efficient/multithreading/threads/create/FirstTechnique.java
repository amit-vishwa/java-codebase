package com.efficient.multithreading.threads.create;

import java.util.concurrent.TimeUnit;

/**
 * In first technique, the start() method is called in constructor.
 * So while creating the class object the thread starts executing.
 * */
public class FirstTechnique {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        new FirstTask();
        Thread thread = new FirstTask();
        thread.join(); // waits to complete this thread task
        System.out.println("Main thread ended");
    }

}

class FirstTask extends Thread {

    private static int count = 0;
    private int id;

    public FirstTask(){
        this.id = ++count;
        this.start();
    }

    @Override
    public void run(){
        for(int i = 10; i > 0; i--){
            try {
                TimeUnit.MILLISECONDS.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("<" + this.id + "> Tick tick: " + i);
        }
    }

}
