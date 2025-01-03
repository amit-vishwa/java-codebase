package tutorial.java.multithreading.runnableinterface;

/**
 * Refer: https://www.geeksforgeeks.org/runnable-interface-in-java/?ref=lbp
 *
 * java.lang.Runnable is an interface that is to be implemented by a class whose instances are intended to be executed by a
 * thread. There are two ways to start a new Thread – Subclass Thread and implement Runnable. There is no need of subclassing
 * a Thread when a task can be done by overriding only run() method of Runnable.
 *
 * Steps to create a new thread using Runnable
 * - Create a Runnable implementer and implement the run() method.
 * - Instantiate the Thread class and pass the implementer to the Thread, Thread has a constructor which accepts Runnable instances.
 * - Invoke start() of Thread instance, start internally calls run() of the implementer. Invoking start() creates a new Thread
 * that executes the code written in run(). Calling run() directly doesn’t create and start a new Thread, it will run in the
 * same thread. To start a new line of execution, call start() on the thread.
 * */
public class SimpleRunnableInterface {
    public static void main(String[] args)
    {
        // Creating object of our thread class inside main()
        // method
        ThreadUsingInterface obj = new ThreadUsingInterface();
        // Passing the object to thread in main()
        Thread myThread = new Thread(obj);
        // Starting the thread
        myThread.start();
    }
}

class ThreadUsingInterface implements Runnable {
    // Method 1
    // run() method for the thread
    public void run()
    {
        // Print statement
        System.out.println("Thread is created using Runnable interface");
    }
}