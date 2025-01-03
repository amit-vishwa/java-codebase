package tutorial.java.multithreading.threadsafety;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Refer: https://www.geeksforgeeks.org/atomic-variables-in-java-with-examples/
 *
 * In multithreading, the shared entity mostly leads to a problem when concurrency is incorporated. A shared entity such as,
 * mutable object or variable, might be changed, which may result in the inconsistency of the program or database. So, it
 * becomes crucial to deal with the shared entity while accessed concurrently. An atomic variable can be one of the alternatives
 * in such a scenario.
 * Java provides atomic classes such as AtomicInteger, AtomicLong, AtomicBoolean and AtomicReference. Objects of these classes
 * represent the atomic variable of int, long, boolean, and object reference respectively. These classes contain the following methods.
 * - set(int value): Sets to the given value
 * - get(): Gets the current value
 * - lazySet(int value): Eventually sets to the given value
 * - compareAndSet(int expect, int update): Atomically sets the value to the given updated value if the current value == the
 * expected value
 * - addAndGet(int delta): Atomically adds the given value to the current value
 * - decrementAndGet(): Atomically decrements by one the current value
 * */
public class AtomicVariables {

    public static void main(
            String[] args) throws Exception
    {

        // Creating an instance of
        // Counter class
        Counter c = new Counter();

        // Creating an instance t1 of
        // Thread class
        Thread t1 = new Thread(
                new Runnable() {
                    public void run()
                    {
                        for (int i = 1; i <= 2000; i++) {
                            c.increment();
                        }
                    }
                });

        // Creating an instance t2
        // of Thread class
        Thread t2 = new Thread(
                new Runnable() {
                    public void run()
                    {
                        for (int i = 1; i <= 2000; i++) {
                            c.increment();
                        }
                    }
                });

        // Calling start() method with t1 and t2
        t1.start();
        t2.start();

        // Calling join method with t1 and t2
        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}

class Counter {

    // Creating a variable of
    // class type AtomicInteger
    AtomicInteger count
            = new AtomicInteger();

    // Defining increment() method
    // to change value of
    // AtomicInteger variable
    public void increment()
    {
        count.incrementAndGet();
    }
}
