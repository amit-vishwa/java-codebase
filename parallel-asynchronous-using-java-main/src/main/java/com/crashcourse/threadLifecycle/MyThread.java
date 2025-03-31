package com.crashcourse.threadLifecycle;

/**
 * Class to demonstrate the lifecycle of a Thread.
 * Thread class be used when a class is not extending any other class.
 * Runnable interface can be used when a class is already extending other class,
 * as Java don't support multiple inheritance.
 * */
public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.print("State: RUNNING, ");
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(1000); // 3.TIMED_WAITING state
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread(); // 1.NEW state
        System.out.println("State: " + thread.getState());
        thread.start(); // 2.RUNNABLE state
        System.out.println("State: " + thread.getState());
        // RUNNABLE will be shown if thread is running, since no RUNNING enum is there
//        System.out.println("State: " + Thread.currentThread().getState()); // RUNNING state
        Thread.sleep(100); // TIMED_WAITING state, made main thread to wait for other
        System.out.println("State: " + thread.getState());
        thread.join(); // TERMINATED state, waiting for thread to complete
        System.out.println("State: " + thread.getState());
    }

}
