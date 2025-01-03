package tutorial.java.multithreading.threadclass;

public class RunnableThreadClass {

    public static void main(String[] args) {

        // Making objects of class 1 and 2 in main() method
        Test obj = new Test();
        Helper obj2 = new Helper();

        // Creating 2 threads in main() method
        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj2);

        // Moving thread to runnable states
        thread1.start();
        thread2.start();

        // Loading thread 1 in class 1
        ClassLoader loader = thread1.getContextClassLoader();

        // Creating 3rd thread in main() method
        Thread thread3 = new Thread(new Helper());

        // Getting number of active threads
        System.out.println(Thread.activeCount());
//        thread1.checkAccess(); // deprecated

        // Fetching an instance of this thread
        Thread t = Thread.currentThread();

        // Print and display commands
        System.out.println(t.getName());

        System.out.println("Thread1 name: " + thread1.getName());
        System.out.println("Thread1 ID: " + thread1.getId());

        // Fetching the priority and state of thread1
        System.out.println("Priority of thread1 = " + thread1.getPriority());

        // Getting the state of thread 1 using getState() method
        // and printing the same
        System.out.println(thread1.getState());

        thread2 = new Thread(obj2);
        thread2.start();
        thread2.interrupt();
        System.out.println("Is thread2 interrupted? " + thread2.interrupted() );
        System.out.println("Is thread2 alive? " + thread2.isAlive());

        thread1 = new Thread(obj);
        thread1.setDaemon(true);
        System.out.println("Is thread1 a daemon thread? " + thread1.isDaemon());
        System.out.println("Is thread1 interrupted? " + thread1.isInterrupted());

        // Waiting for thread2 to complete its execution
        System.out.println("thread1 waiting for thread2 to join");

        try {
            thread2.join();
        }

        catch (InterruptedException e) {

            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        // Now setting the name of thread1
        thread1.setName("child thread xyz");

        // Print and display command
        System.out.println("New name set for thread 1 " + thread1.getName());

        // Setting the priority of thread1
        thread1.setPriority(5);

        thread2.yield();

        // Fetching the string representation of thread1
        System.out.println(thread1.toString());

        // Getting list of active thread in current thread's group
        Thread[] tarray = new Thread[3];

        Thread.enumerate(tarray);

        // Display commands
        System.out.println("List of active threads: ");
        System.out.println("[");

        // Looking out using for each loop
        for (Thread thread : tarray) {

            System.out.println(thread);
        }

        // Display commands
        System.out.println("]");

        System.out.println(Thread.getAllStackTraces());

        ClassLoader classLoader = thread1.getContextClassLoader();
        System.out.println(classLoader.toString());
        System.out.println(thread1.getDefaultUncaughtExceptionHandler());

        thread2.setUncaughtExceptionHandler(thread1.getDefaultUncaughtExceptionHandler());
        thread1.setContextClassLoader(thread2.getContextClassLoader());
        thread1.setDefaultUncaughtExceptionHandler(thread2.getUncaughtExceptionHandler());

        thread1 = new Thread(obj);
        StackTraceElement[] trace = thread1.getStackTrace();

        System.out.println("Printing stack trace elements for thread1: ");

        for (StackTraceElement e : trace) {
            System.out.println(e);
        }

        ThreadGroup grp = thread1.getThreadGroup();
        System.out.println("ThreadGroup to which thread1 belongs " + grp.toString());
        System.out.println(thread1.getUncaughtExceptionHandler());
        System.out.println("Does thread1 holds Lock? " + thread1.holdsLock(obj2));


        Thread.dumpStack();

    }

}

// Class 1
// Helper class implementing Runnable interface
class Helper implements Runnable {

    //
    public void run() {

        // Try block to check for exceptions
        try {

            // Print statement
            System.out.println("thread2 going to sleep for 5000");

            // Making thread sleep for 0.5 seconds
            Thread.sleep(5000);

        }

        // Catch block to handle exception
        catch (InterruptedException e) {

            // Print statement
            System.out.println("Thread2 interrupted");
        }
    }
}

// Class 2
// Helper class extending Runnable interface
class Test implements Runnable {

    // Method 1
    // run() method of this class
    public void run() {

        // Thread run() method
    }

}
