package com.crashcourse.threadLocks;

/**
 * Locks are of 2 types - intrinsic and explicit.
 * Intrinsic is automatic lock, used by synchronized keyword.
 * Explicit can be created using Lock interface manually to perform more operation.
 * */
public class ThreadLockDemo {

    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Thread person1 = new Thread(runnable,"Person 1");
        Thread person2 = new Thread(runnable,"Person 2");
        person2.start();
        person1.start();
    }

}
