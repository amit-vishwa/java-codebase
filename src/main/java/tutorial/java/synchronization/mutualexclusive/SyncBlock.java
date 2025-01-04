package tutorial.java.synchronization.mutualexclusive;

/**
 * Refer: https://www.geeksforgeeks.org/importance-of-thread-synchronization-in-java/?ref=next_article
 *
 * B. Synchronized Block
 * If we declare a block as synchronized, only the code which is written inside that block is executed sequentially not the
 * complete code. This is used when we want sequential access to some part of code or to synchronize some part of code.
 *
 * Syntax:
 * synchronized (object reference)
 * {
 *    // Insert code here
 * }
 * */
public class SyncBlock {
    public static void main(String[] args)
    {

        // Creating instance for class 1 inside main()
        Print p = new Print();

        // Creating threads and
        // passing same object
        Threads1 t1 = new Threads1(p);
        Threads2 t2 = new Threads2(p);

        // Starting these thread using start() method
        t1.start();
        t2.start();
    }
}
// Java Program Illustrating Synchronized Code
// Using synchronized block

// Class 1
// Helper class extending Thread class
class Print extends Thread {

    // Method 1
    // To print the thread
    public void printThread(int n)
    {

        // Making synchronized block that makes the block
        // synchronized
        synchronized (this)
        {

            // Iterating using for loop
            for (int i = 1; i <= 3; i++) {

                // Print message when these thread are
                // executing
                System.out.println("Thread " + n
                        + " is working...");

                // Try block to check for exceptions
                try {

                    // Making thread to pause for 0.6
                    // seconds
                    Thread.sleep(600);
                }

                // Catch block to handle exceptions
                catch (Exception ex) {

                    // Print message when exception.s occur
                    System.out.println(ex.toString());
                }
            }
        }

        // Display message only
        System.out.println("--------------------------");

        try {

            // Making thread t osleep for 1 sec
            Thread.sleep(1000);
        }

        catch (Exception ex) {

            System.out.println(ex.toString());
        }
    }
}

// Class 2
// Helper class extending Thread class
class Threads1 extends Thread {

    Print test;
    Threads1(Print p) { test = p; }

    public void run() { test.printThread(1); }
}

// Class 3
// Helper class extending Thread class
class Threads2 extends Thread {

    Print test;
    Threads2(Print p) { test = p; }

    public void run() { test.printThread(2); }
}


