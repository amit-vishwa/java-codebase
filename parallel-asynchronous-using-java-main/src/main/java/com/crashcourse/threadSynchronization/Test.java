package com.crashcourse.threadSynchronization;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);
        thread1.start();
        thread2.start();
        System.out.println(counter.getCount()); // 0
        thread1.join();
        thread2.join();
        System.out.println(counter.getCount()); // can be random value within 2000
    }

}
