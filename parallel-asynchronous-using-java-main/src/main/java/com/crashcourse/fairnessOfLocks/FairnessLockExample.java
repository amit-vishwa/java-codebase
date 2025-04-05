package com.crashcourse.fairnessOfLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This example demonstrates the use of a fair lock in Java.
 * When argument is not passed, it is considered as false i.e. regular thread execution.
 * When fair is set to true, the lock will be acquired in the order of thread requests.
 *
 * Below disadvantages of synchronization are removed in lock mechanism:
 * - Unfairness: Threads may not get a chance to execute in the order they requested the lock.
 * - Blocking: There can be the situation of deadlock when thread waits for indefinite period.
 * - Interruptibility: Thread using synchronized lock (i.e.intrinsic) cannot be interrupted.
 * - Read/write lock: No differentiation between read and write locks.
 * */
public class FairnessLockExample {

    // setting fair as true ensures sequential execution of threads
    private static final Lock fairLock = new ReentrantLock(true);

    public static void accessResource(){
        fairLock.lock();
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println(threadName + " acquired the lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(threadName + " released the lock");
            fairLock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                accessResource();
            }
        };
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
