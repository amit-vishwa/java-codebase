package com.efficient.multithreading.threads.executor;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {

    private static int count = 0;
    private int id;

    public LoopTaskB(){
        this.id = ++count;
    }

    @Override
    public void run(){
        System.out.println("##### <TASK-" + this.id + "> Starting #####");
        for(int i = 10; i > 0; i--){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("<" + this.id + "> Tick tick: " + i);
        }
        System.out.println("##### <TASK-" + this.id + "> Ending #####");
    }

}
