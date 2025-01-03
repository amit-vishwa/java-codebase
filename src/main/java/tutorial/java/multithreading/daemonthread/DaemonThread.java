package tutorial.java.multithreading.daemonthread;

/**
 * Refer: https://www.geeksforgeeks.org/daemon-thread-java/
 *
 * In Java, daemon threads are low-priority threads that run in the background to perform tasks such as garbage collection or
 * provide services to user threads. The life of a daemon thread depends on the mercy of user threads, meaning that when all
 * user threads finish their execution, the Java Virtual Machine (JVM) automatically terminates the daemon thread.
 * To put it simply, daemon threads serve user threads by handling background tasks and have no role other than supporting the
 * main execution.
 *
 * Example of Daemon Thread in Java
 * Some examples of daemon threads in Java include garbage collection (gc) and finalizer. These threads work silently in the
 * background, performing tasks that support the main execution without interfering with the user’s operations.
 *
 *  Properties of Java Daemon Thread
 * - No Preventing JVM Exit: Daemon threads cannot prevent the JVM from exiting when all user threads finish their execution. If
 * all user threads complete their tasks, the JVM terminates itself, regardless of whether any daemon threads are running.
 * - Automatic Termination: If the JVM detects a running daemon thread, it terminates the thread and subsequently shuts it down.
 * The JVM does not check if the daemon thread is actively running; it terminates it regardless.
 * - Low Priority: Daemon threads have the lowest priority among all threads in Java.
 *
 * Default Nature of Daemon Thread
 * By default, the main thread is always a non-daemon thread. However, for all other threads, their daemon nature is inherited
 * from their parent thread. If the parent thread is a daemon, the child thread is also a daemon, and if the parent thread is a
 * non-daemon, the child thread is also a non-daemon.
 *
 * Note: Whenever the last non-daemon thread terminates, all the daemon threads will be terminated automatically.
 *
 * Output: This clearly shows that we cannot call the setDaemon() method after starting the thread.
 *
 * Daemon vs. User Threads
 * - Priority: When only daemon threads remain in a process, the JVM exits. This makes sense because when only daemon threads are
 * running, there is no need for a daemon thread to provide a service to another thread.
 * - Usage: Daemon threads are primarily used to provide background support to user threads. They handle tasks that support the main
 * execution without interfering with the user’s operations.
 *
 * Understanding daemon threads is essential for Java developers to effectively manage thread behavior and optimize application performance.
 * */
public class DaemonThread extends Thread {
    public void run()
    {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("Check if " + Thread.currentThread().getName() +" is DaemonThread: "
                + Thread.currentThread().isDaemon());
    }

    public static void main(String[] args)
    {
        DaemonThread t1 = new DaemonThread();
        DaemonThread t2 = new DaemonThread();
        t1.start();

//        t1.setDaemon(true); // Exception as the thread is already started
        t2.setDaemon(true);

        t2.start();
    }
}
