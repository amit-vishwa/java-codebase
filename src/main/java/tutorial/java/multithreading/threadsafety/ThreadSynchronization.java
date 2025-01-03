package tutorial.java.multithreading.threadsafety;

/**
 * Refer: https://www.geeksforgeeks.org/synchronization-in-java/
 *
 * Multi-threaded programs may often come to a situation where multiple threads try to access the same resources and finally
 * produce erroneous and unforeseen results.
 *
 * Why use Java Synchronization?
 * Java Synchronization is used to make sure by some synchronization method that only one thread can access the resource at a
 * given point in time.
 *
 * Synchronization is the process of allowing only one thread at a time to complete the particular task. It means when multiple
 * threads executing simultaneously, and want to access the same resource at the same time, then the problem of inconsistency
 * will occur. so synchronization is used to resolve inconsistency problem by allowing only one thread at a time.
 * Synchronization uses a synchronized keyword. Synchronized is the modifier that creates a block of code known as a critical section.
 *
 * Types of Synchronization
 * There are two synchronizations in Java mentioned below:
 *
 * Process Synchronization
 * Thread Synchronization
 * 1. Process Synchronization in Java
 * Process Synchronization is a technique used to coordinate the execution of multiple processes. It ensures that the shared
 * resources are safe and in order.
 *
 * 2. Thread Synchronization in Java
 * Thread Synchronization is used to coordinate and ordering of the execution of the threads in a multi-threaded program.
 * There are two types of thread synchronization are mentioned below:
 * i.Mutual Exclusive
 * ii.Cooperation (Inter-thread communication in Java)
 *
 * Mutual Exclusive
 * Mutual Exclusive helps keep threads from interfering with one another while sharing data. There are three types of Mutual
 * Exclusive mentioned below:
 * a.Synchronized method.
 * b.Synchronized block.
 * c.Static synchronization.
 *
 * */
public class ThreadSynchronization {

    public static void main(String args[])
    {
        Sender send = new Sender();
        ThreadedSend S1 = new ThreadedSend("Hi", send);
        ThreadedSend S2 = new ThreadedSend("Bye", send);
        // Start two threads of ThreadedSend type
        S1.start();
        S2.start();
        // wait for threads to end
        try {
            S1.join();
            S2.join();
        }
        catch (Exception e) {
            System.out.println("Interrupted");
        }

        // only one object
        final Test obj = new Test();
        Thread a = new Thread() {
            public void run() { obj.test_function(15); }
        };
        Thread b = new Thread() {
            public void run() { obj.test_function(30); }
        };
        a.start();
        b.start();
    }
}

// A Class used to send a message
class Sender {
    public void send(String msg)
    {
        System.out.print("Sending " + msg + ": ");
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println(msg + " Sent");
    }
}

// Class for send a message using Threads
class ThreadedSend extends Thread {
    private String msg;
    Sender sender;

    // Receives a message object and a string
    // message to be sent
    ThreadedSend(String m, Sender obj)
    {
        msg = m;
        sender = obj;
    }

    public void run()
    {
        // Only one thread can send a message
        // at a time.
        synchronized (sender)
        {
            // synchronizing the send object
            sender.send(msg);
        }
    }

}

class Test {
    // An alternate implementation to demonstrate that we can use synchronized with method also.
    synchronized void test_function(int n)
    {
        // synchronized method
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            System.out.println(n + i);
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}