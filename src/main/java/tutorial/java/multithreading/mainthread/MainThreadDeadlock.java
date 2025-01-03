package tutorial.java.multithreading.mainthread;

/**
 * Refer: https://www.geeksforgeeks.org/main-thread-java/?ref=lbp
 *
 * Deadlocking with use of Main Thread(only single thread)
 * We can create a deadlock by just using the Main thread, i.e. by just using a single thread.
 *
 * Output explanation:
 * The statement “Thread.currentThread().join()”, will tell Main thread to wait for this thread(i.e. wait for itself) to die.
 * Thus, Main thread wait for itself to die, which is nothing but a deadlock.
 * */
public class MainThreadDeadlock {

    public static void main(String[] args) {
        // Try block to check for exceptions
        try {
            // Print statement
            System.out.println("Entering into Deadlock");
            // Joining the current thread
            Thread.currentThread().join();
            // This statement will never execute
            System.out.println("This statement will never execute");
        }
        // Catch block to handle the exceptions
        catch (InterruptedException e) {
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }

}
