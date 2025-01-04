package tutorial.java.synchronization.mutualexclusive;

/**
 * Refer: https://www.geeksforgeeks.org/importance-of-thread-synchronization-in-java/?ref=next_article
 *
 * A. Synchronized Method
 * We can declare a method as synchronized using the “synchronized” keyword. This will make the code written inside the method
 * thread-safe so that no other thread will execute while the resource is shared.
 *
 * Below program show use of synchronized keyword in method, comment uncomment lines 52 & 53 to check different behaviours
 * */
public class SyncMethod {
    public static void main(String[] args)
    {

        // Creating object of class 1 inside main() method
        PrintTest p = new PrintTest();

        // Passing the same object of class PrintTest to
        // both threads
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);

        // Start executing the threads
        // using start() method
        t1.start();
        t2.start();

        // This will print both the threads simultaneously
    }
}

// Class 1
// Helper class
// Extending Thread class
class PrintTest extends Thread {

    // Non synchronized Code

    // Method 1
    /**
     * We will be proposing prints the two threads simultaneously showing the asynchronous behavior without thread
     * synchronization.
     * Now using synchronized method, it will  lock the object for the shared resource and gives the consistent output.
     * */
    // synchronized code
    // synchronized method will lock the object and
    // releases when thread is terminated or completed its
    // execution.
    synchronized public void printThread(int n)
//    public void printThread(int n)
    {

        // This loop will print the currently executed
        // thread
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread " + n
                    + " is working...");

            // Try block to check for exceptions
            try {

                // Pause the execution of current thread
                // for 0.600 seconds using sleep() method
                Thread.sleep(600);
            }

            // Catch block to handle the exceptions
            catch (Exception ex) {

                // Overriding existing toString() method and
                // prints exception if occur
                System.out.println(ex.toString());
            }
        }

        // Display message for better readability
        System.out.println("--------------------------");

        try {

            // Pause the execution of current thread
            // for 0.1000 millisecond or 1sec using sleep
            // method
            Thread.sleep(1000);
        }

        catch (Exception ex) {

            // Printing the exception
            System.out.println(ex.toString());
        }
    }
}

// Class 2
// Helper class extending Thread Class
class Thread1 extends Thread {

    // Declaring variable of type Class1
    PrintTest test;

    // Constructor for class1
    Thread1(PrintTest p) { test = p; }

    // run() method of this class for
    // entry point for thread1
    public void run()
    {

        // Calling method 1 as in above class
        test.printThread(1);
    }
}

// Class 3
// Helper class extending Thread Class
class Thread2 extends Thread {

    // Declaring variable of type Class1
    PrintTest test;

    // Constructor for class2
    Thread2(PrintTest p) { test = p; }

    // run() method of this class for
    // entry point for thread2
    public void run() { test.printThread(2); }
}