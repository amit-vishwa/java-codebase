package tutorial.java.multithreading.threadclass;

/**
 * Refer: https://www.geeksforgeeks.org/java-lang-thread-class-java/?ref=lbp
 *
 * Thread is a line of execution within a program. Each program can have multiple associated threads. Each thread has a
 * priority which is used by the thread scheduler to determine which thread must run first. Java provides a thread class that
 * has various method calls in order to manage the behavior of threads by providing constructors and methods to perform
 * operations on threads.
 *
 * Ways of creating threads
 * i.Creating own class which is extending to parent Thread class
 * ii.Implementing the Runnable interface.
 * */
public class SimpleThreadClass {
    public static void main(String[] args)
    {
        // Creating object of our thread class inside main()
        // method
        MyThread myThread = new MyThread();
        // Starting the thread
        myThread.start();
    }
}

// Way 1
// Creating thread By Extending To Thread class

class MyThread extends Thread {
    // Method 1
    // Run() method for our thread
    public void run()
    {
        // Print statement
        System.out.println("Thread is running created by extending to parent Thread class");
    }
}