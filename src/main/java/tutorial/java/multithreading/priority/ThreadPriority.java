package tutorial.java.multithreading.priority;

/**
 * Refer: https://www.geeksforgeeks.org/java-thread-priority-multithreading/?ref=lbp
 *
 * As we already know java being completely object-oriented works within a multithreading environment in which thread scheduler
 * assigns the processor to a thread based on the priority of thread. Whenever we create a thread in Java, it always has some
 * priority assigned to it. Priority can either be given by JVM while creating the thread or it can be given by the
 * programmer explicitly.
 * Priorities in threads is a concept where each thread is having a priority which in layman’s language one can say every object
 * is having priority here which is represented by numbers ranging from 1 to 10.
 *
 * The default priority is set to 5 as excepted.
 * Minimum priority is set to 1.
 * Maximum priority is set to 10.
 *
 * Here 3 constants are defined in it namely as follows:
 * public static int NORM_PRIORITY
 * public static int MIN_PRIORITY
 * public static int MAX_PRIORITY
 *
 *  Output explanation:
 * - Thread with the highest priority will get an execution chance prior to other threads. Suppose there are 3 threads t1, t2, and
 * t3 with priorities 4, 6, and 1. So, thread t2 will execute first based on maximum priority 6 after that t1 will execute and
 * then t3.
 * - The default priority for the main thread is always 5, it can be changed later. The default priority for all other threads
 * depends on the priority of the parent thread.
 * - If two threads have the same priority then we can’t expect which thread will execute first. It depends on the thread
 * scheduler’s algorithm(Round-Robin, First Come First Serve, etc)
 * - If we are using thread priority for thread scheduling then we should always keep in mind that the underlying platform should
 * provide support for scheduling based on thread priority.
 * */
public class ThreadPriority {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating random threads
        // with the help of above class
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        ThreadDemo t3 = new ThreadDemo();

        // Thread 1
        // Display the priority of above thread
        // using getPriority() method
        System.out.println("t1 thread priority : "
                + t1.getPriority());

        // Thread 1
        // Display the priority of above thread
        System.out.println("t2 thread priority : "
                + t2.getPriority());

        // Thread 3
        System.out.println("t3 thread priority : "
                + t3.getPriority());

        // Setting priorities of above threads by
        // passing integer arguments
        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);

        // t3.setPriority(21); will throw
        // IllegalArgumentException

        // 2
        System.out.println("t1 thread priority : "
                + t1.getPriority());

        // 5
        System.out.println("t2 thread priority : "
                + t2.getPriority());

        // 8
        System.out.println("t3 thread priority : "
                + t3.getPriority());

        // Main thread

        // Displays the name of
        // currently executing Thread
        System.out.println(
                "Currently Executing Thread : "
                        + Thread.currentThread().getName());

        System.out.println(
                "Main thread priority : "
                        + Thread.currentThread().getPriority());

        // Main thread priority is set to 10
        Thread.currentThread().setPriority(10);

        System.out.println(
                "Main thread priority : "
                        + Thread.currentThread().getPriority());

        t1.start();
        t2.start();

        ThreadDemo t4 = new ThreadDemo();
        t4.setPriority(8);
        t4.start();
        t3.start();
    }
}

// Main class
class ThreadDemo extends Thread {

    // Method 1
    // run() method for the thread that is called
    // as soon as start() is invoked for thread in main()
    public void run()
    {
        // Print statement
        System.out.println("Inside run method of " + Thread.currentThread().getName()
                + " with priority " + Thread.currentThread().getPriority());
    }
}
