package com.crashcourse.threadLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    // using synchronized lock can result in indefinite waiting period
    /*public synchronized void withdraw(int amount){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": attempting to withdraw " + amount);
        if(balance >= amount){
            System.out.println(threadName + ": proceeding with withdrawal");
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) { }
            balance -= amount;
            System.out.println(threadName + ": completed withdrawal, balance is " + balance);
        }else{
            System.out.println(threadName + ": insufficient balance");
        }
    }*/

    public void withdraw(int amount){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": attempting to withdraw " + amount);
        try{
            /**
             * lock.lock() -> tries to acquire a lock if unlocked, else wait till it is unlocked
             * lock.tryLock() -> tries to acquire a lock if unlocked, else proceed further
             * below tries to acquire a lock, if it is unlocked else wait for specified period
             * */
            if(lock.tryLock(3000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try {
                        System.out.println(threadName + ": proceeding with withdrawal");
                        Thread.sleep(2000);
                        balance -= amount;
                        System.out.println(threadName + ": completed withdrawal, balance is " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // interrupt thread for good practice
                    }
                    finally {
                        lock.unlock(); // unlock everytime to avoid indefinite waiting period
                    }
                }else{
                    System.out.println(threadName + ": insufficient balance");
                }
            }else{
                System.out.println(threadName + ": could not acquire the lock, will try again later");
            }
        }catch (Exception e){
            Thread.currentThread().interrupt(); // interrupt thread in exception for good practice
        }
        if (Thread.currentThread().isInterrupted()){
            System.out.println(threadName + ": thread got interrupted");
        }
    }

}
