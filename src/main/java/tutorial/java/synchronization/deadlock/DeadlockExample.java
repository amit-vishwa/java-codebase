package tutorial.java.synchronization.deadlock;

/**
 * Refer: https://www.geeksforgeeks.org/deadlock-in-java-multithreading/?ref=next_article
 *
 * synchronized keyword is used to make the class or method thread-safe which means only one thread can have the lock of the
 * synchronized method and use it, other threads have to wait till the lock releases and anyone of them acquire that lock.
 * It is important to use if our program is running in a multi-threaded environment where two or more threads execute
 * simultaneously. But sometimes it also causes a problem which is called Deadlock.
 *
 * Avoid Dead Lock condition
 * We can avoid dead lock condition by knowing its possibilities. It’s a very complex process and not easy to catch. But still
 * if we try, we can avoid this. There are some methods by which we can avoid this condition. We can’t completely remove its
 * possibility but we can reduce.
 * - Avoid Nested Locks : This is the main reason for dead lock. Dead Lock mainly happens when we give locks to multiple threads.
 * Avoid giving lock to multiple threads if we already have given to one.
 * - Avoid Unnecessary Locks : We should have lock only those members which are required. Having lock on unnecessarily can lead
 * to dead lock.
 * - Using thread join : Dead lock condition appears when one thread is waiting other to finish. If this condition occurs we can
 * use Thread.join with maximum time you think the execution will take.
 *
 * Important Points :
 * - If threads are waiting for each other to finish, then the condition is known as Deadlock.
 * - Deadlock condition is a complex condition which occurs only in case of multiple threads.
 * - Deadlock condition can break our code at run time and can destroy business logic.
 * - We should avoid this condition as much as we can.
 * */
public class DeadlockExample {

    public static void main(String[] args)
    {
        // creating one object
        Shared s1 = new Shared();
        Shared s2 = new Shared();
        // creating first thread and starting it
        Thread1 t1 = new Thread1(s1, s2);
        t1.setName("Thread1");
        t1.start();
        // creating second thread and starting it
        Thread2 t2 = new Thread2(s1, s2);
        t2.setName("Thread2");
        t2.start();
        Util.sleep(2000);
    }

}

class Util
{
    // Util class to sleep a thread
    static void sleep(long millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
// This class is shared by both threads
class Shared
{
    /**
     * Deadlock Scenario
     * Deadlock: A situation where two or more threads are blocked forever, waiting for each other. In this example:
     * Thread1 locks s1 and waits for s2.
     * Thread2 locks s2 and waits for s1.
     * Both threads are waiting for each other to release the lock, causing a deadlock.
     * */
    // first synchronized method
    synchronized void test1(Shared s2)
    {
        System.out.println(Thread.currentThread().getName() + " enters test1 of " + this);
        Util.sleep(1000);
        // taking object lock of s2 enters
        // into test2 method
        s2.test2();
        System.out.println(Thread.currentThread().getName() + " exits test1 of " + this);
    }
    synchronized void test2()
    {
        System.out.println(Thread.currentThread().getName() + " enters test2 of " + this);
        Util.sleep(1000);
        // taking object lock of s1 enters
        // into test1 method
        System.out.println(Thread.currentThread().getName() + " exits test2 of " + this);
    }
}
class Thread1 extends Thread
{
    private Shared s1;
    private Shared s2;
    // constructor to initialize fields
    public Thread1(Shared s1, Shared s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }
    // run method to start a thread
    @Override
    public void run()
    {
        s1.test1(s2);
    }
}
class Thread2 extends Thread
{
    private Shared s1;
    private Shared s2;
    // constructor to initialize fields
    public Thread2(Shared s1, Shared s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }
    // run method to start a thread
    @Override
    public void run()
    {
        s2.test1(s1);
    }
}