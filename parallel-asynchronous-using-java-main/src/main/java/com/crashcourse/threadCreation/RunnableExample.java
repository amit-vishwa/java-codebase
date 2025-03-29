package com.crashcourse.threadCreation;

public class RunnableExample implements Runnable{

    @Override
    public void run(){
        for (int i = 1; i <= 100; i++){
            System.out.println("Implemented Runnable Interface: " + Thread.currentThread().getName());
        }
    }

}
