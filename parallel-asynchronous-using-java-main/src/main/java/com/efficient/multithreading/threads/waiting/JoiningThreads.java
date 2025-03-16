package com.efficient.multithreading.threads.waiting;

import com.efficient.multithreading.threads.daemon.LoopTaskD;

/**
 * We can wait for threads completion using below:
 * - isAlive() -> wastage of CPU cycles when called every time
 * - wait() & notify() -> manual coding is required
 * - join() -> best technique, no manual coding is required and
 * it uses wait and notify internally
 * */
public class JoiningThreads {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Main thread starts here...");

        Thread thread1 = new Thread(new LoopTaskD(100), "Thread-1");
        // all tasks will get completed before thread2 but 3 and 4 will print join only after 2
        Thread thread2 = new Thread(new LoopTaskD(600), "Thread-2");
        Thread thread3 = new Thread(new LoopTaskD(300), "Thread-3");
        Thread thread4 = new Thread(new LoopTaskD(400), "Thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        System.out.println("[" + threadName + "] joined " + thread1.getName());
        thread2.join();
        System.out.println("[" + threadName + "] joined " + thread2.getName());
        thread3.join();
        System.out.println("[" + threadName + "] joined " + thread3.getName());
        thread4.join();
        System.out.println("[" + threadName + "] joined " + thread4.getName());

        System.out.println("[" + threadName + "] Main thread ends here...");
    }

}
