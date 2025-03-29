package com.crashcourse.threadCreation;

public class ThreadExample extends Thread{

    @Override
    public void run(){
        for (int i = 1; i <= 100; i++){
            System.out.println("Extended Thread Class: " + Thread.currentThread().getName());
        }
    }

}
