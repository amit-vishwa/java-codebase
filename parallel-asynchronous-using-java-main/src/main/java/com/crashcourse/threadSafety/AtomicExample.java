package com.crashcourse.threadSafety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    /**
     * Atomic variables are thread safe which means at a time only one thread can access the variable.
     * In-built lock mechanism is implemented so we don't need to worry about synchronized and locks.
     * */
    private static AtomicInteger counter = new AtomicInteger();
//    private static int counter = 0;

    public static void increment(){
//        counter++;
        counter.incrementAndGet();
    }

    public static int getCounter(){
//        return counter;
        return counter.get();
    }

    public static void main(String... args) throws InterruptedException {
        Thread thread1 = new Thread(()-> {
            for(int i = 0; i < 1000; i++){
                increment();
            }
        });
        Thread thread2 = new Thread(()-> {
            for(int i = 0; i < 1000; i++){
                increment();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(getCounter());
    }

}
