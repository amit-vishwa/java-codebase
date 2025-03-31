package com.crashcourse.threadMethods;

/**
 * The class demonstrates various methods of Thread class.
 * Methods: run(), start(), sleep(), join(), interrupt(), yield(), getState(), setName(), getName(),
 * setPriority(), getPriority(), setDaemon(), isDaemon()
 * */
public class ThreadMethods extends Thread{

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        if(threadName.equals("T1")||threadName.equals("T2")){
            yieldDemo();
        }else{
            otherDemo();
        }
        // Program doesn't wait for the daemon thread once main thread is terminated
        String threadType = Thread.currentThread().isDaemon() ? "DAEMON" : "USER";
        System.out.println(threadName + " is a " + threadType + " thread");
    }

    private void otherDemo(){
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("Thread priority: " + Thread.currentThread().getPriority());
        try {
            Thread.sleep(1000); // RUNNABLE, below statement is printed first
            System.out.println("Thread state: " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void yieldDemo(){
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield(); // allow other thread to run, performs more context-switching
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethods threadMethods = new ThreadMethods();
        threadMethods.start();
        threadMethods.setName("Local thread");
        threadMethods.setPriority(10);
        Thread.sleep(500); // TIMED_WAITING, main sleeps and local waits
        System.out.println("Thread state: " + threadMethods.getState());
        threadMethods.interrupt(); // main will interrupt thread and stop further tasks
        threadMethods.join();

        ThreadMethods t1 = new ThreadMethods();
        t1.setName("T1");
        t1.setDaemon(true);
        t1.start();
        ThreadMethods t2 = new ThreadMethods();
        t2.setName("T2");
        t2.start();
    }

}
