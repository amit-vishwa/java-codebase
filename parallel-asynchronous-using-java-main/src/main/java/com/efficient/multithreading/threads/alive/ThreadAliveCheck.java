package com.efficient.multithreading.threads.alive;

import com.efficient.multithreading.threads.naming.LoopTaskC;

import java.util.concurrent.TimeUnit;

/**
 * Threads are alive if they are running or waiting,
 * they are dead when execution is completed normally or abnormally.
 * */
public class ThreadAliveCheck {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Thread thread1 = new Thread(new LoopTaskC(), "Thread-1");
        Thread thread2 = new Thread(new LoopTaskC(), "Thread-2");

        boolean thread1IsAlive = thread1.isAlive();
        boolean thread2IsAlive = thread2.isAlive();

        System.out.println("[" + threadName + "] Before starting: Is '" + thread1.getName() + "' alive = " + thread1IsAlive);
        System.out.println("[" + threadName + "] Before starting: Is '" + thread2.getName() + "' alive = " + thread2IsAlive);

        thread1.start();
        thread2.start();

        while (true){
            TimeUnit.MILLISECONDS.sleep(500);

            thread1IsAlive = thread1.isAlive();
            thread2IsAlive = thread2.isAlive();

            System.out.println("[" + threadName + "] Is '" + thread1.getName() + "' alive = " + thread1IsAlive);
            System.out.println("[" + threadName + "] Is '" + thread2.getName() + "' alive = " + thread2IsAlive);

            if(!thread1IsAlive && !thread2IsAlive) break;
        }

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
