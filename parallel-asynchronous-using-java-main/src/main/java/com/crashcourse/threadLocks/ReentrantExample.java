package com.crashcourse.threadLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * When normal lock is used here, then there will be a deadlock situation.
 * As outerMethod() acquired a lock, then innerMethod() is again trying to acquire.
 * In this situation inner one will wait for outer one for indefinite time period.
 *
 * Whereas in ReentrantLock, the lock unlock count is maintained.
 * Hence, n number of locks and unlocks can be implemented, only the count should match
 *
 * Reentrant lock methods visited:
 * lock() - waits to get unlocked for indefinite period of time, TIMED_WAITING state
 * unlock() - unlocks the lock, RUNNABLE state
 * tryLock() - checks if lock can be acquired else proceeds, RUNNABLE state
 * tryLock(time, unit) - checks if lock can be acquired within given time else proceeds, TIMED_WAITING state
 * lockInterruptibly() - works similar to lock() whereas this can be interrupted and lock() cannot
 * */
public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
//        lock.lockInterruptibly();
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.outerMethod();
    }

}
