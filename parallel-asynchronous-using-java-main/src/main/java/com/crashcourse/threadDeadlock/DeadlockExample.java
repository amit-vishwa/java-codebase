package com.crashcourse.threadDeadlock;

/**
 * Deadlock occurs when two or more threads are blocked forever, waiting for each other.
 *
 * Deadlocks typically occur when four conditions are met:
 * 1. Mutual Exclusion: At least one resource must be held in a non-shareable mode.
 * Only one thread can use the resource at any given time.
 * 2. Hold and Wait: A process holding at least one resource is waiting to acquire additional
 * resources that are currently being held by other processes.
 * 3. No Preemption: A resource can be released only voluntarily by the process holding it.
 * 4. Circular Wait: There exists a set of processes such that each process is waiting for a resource.
 * A set of threads is waiting for each other in a circular chain.
 * */
public class DeadlockExample {

    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();

        /**
         * thread1 is using pen and waiting for thread2 to use its paper
         * task1 got Pen object and calls its method that acquires Pen's lock
         * now task1 calls Paper's method which already has Paper's lock
         * so it waits till indefinite period of time for unlock, results in deadlock
         * */
        Thread thread1 = new Thread(new Task1(pen, paper), "Thread 1");
        /**
         * thread2 is using paper and waiting for thread1 to use its pen
         * task2 got Paper object and calls its method that acquires Paper's lock
         * now task2 calls Pen's method which already has Pen's lock
         * so it waits till indefinite period of time for unlock, results in deadlock
         * */
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread 2");

        thread1.start();
        thread2.start();

    }

}
