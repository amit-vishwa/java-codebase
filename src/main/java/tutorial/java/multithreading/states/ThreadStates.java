package tutorial.java.multithreading.states;

/**
 * Refer: https://www.geeksforgeeks.org/lifecycle-and-states-of-a-thread-in-java/?ref=lbp
 *
 * A thread in Java at any point of time exists in any one of the following states. A thread lies only in one of the shown
 * states at any instant:
 * - New State
 * - Runnable State (Active state and can be Running)
 * - Blocked State
 * - Waiting State
 * - Timed Waiting State
 * - Terminated State
 *
 * Life Cycle of a Thread
 * There are multiple states of the thread in a lifecycle as mentioned below:
 * i.New Thread: When a new thread is created, it is in the new state. The thread has not yet started to run when the thread
 * is in this state. When a thread lies in the new state, its code is yet to be run and hasn’t started to execute.
 * ii.Runnable State: A thread that is ready to run is moved to a runnable state. In this state, a thread might actually be
 * running or it might be ready to run at any instant of time. It is the responsibility of the thread scheduler to give the
 * thread, time to run.
 * A multi-threaded program allocates a fixed amount of time to each individual thread. Each and every thread runs for a short
 * while and then pauses and relinquishes the CPU to another thread so that other threads can get a chance to run. When this
 * happens, all such threads that are ready to run, waiting for the CPU and the currently running thread lie in a runnable state.
 * iii.Blocked: The thread will be in blocked state when it is trying to acquire a lock but currently the lock is acquired by
 * the other thread. The thread will move from the blocked state to runnable state when it acquires the lock.
 * iv.Waiting state: The thread will be in waiting state when it calls wait() method or join() method. It will move to the
 * runnable state when other thread will notify or that thread will be terminated.
 * v.Timed Waiting: A thread lies in a timed waiting state when it calls a method with a time-out parameter. A thread lies in
 * this state until the timeout is completed or until a notification is received. For example, when a thread calls sleep or a
 * conditional wait, it is moved to a timed waiting state.
 * vi.Terminated State: A thread terminates because of either of the following reasons:
 *  - Because it exits normally. This happens when the code of the thread has been entirely executed by the program.
 *  - Because there occurred some unusual erroneous event, like a segmentation fault or an unhandled exception.
 *
 *  Explanation of the below Program
 * When a new thread is created, the thread is in the NEW state. When the start() method is called on a thread, the thread
 * scheduler moves it to the Runnable state. Whenever the join() method is called on a thread instance, the current thread
 * executing that statement will wait for this thread to move to the Terminated state. So, before the final statement is
 * printed on the console, the program calls join() on thread2 making the thread1 wait while thread2 completes its execution
 * and is moved to the Terminated state. thread1 goes to the Waiting state because it is waiting for thread2 to complete its
 * execution as it has called join on thread2.
 * */
public class ThreadStates {

    public static void main(String[] args)
    {
        Test.initiateProcess();
    }
}

// Java program to demonstrate thread states
class thread implements Runnable
{
    // Overriding the run method
    @Override
    public void run()
    {
        // Moving thread2 to timed waiting state
        try {
            Thread.sleep(1500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread1 while it called"
                + " join() method on thread2 - "
                + Test.thread1.getState());

        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test implements Runnable {
    public static Thread thread1;
    public static Test obj;

    // Overriding the run method
    @Override
    public void run()
    {
        thread myThread = new thread();
        Thread thread2 = new Thread(myThread);

        // thread2 created and is currently in the NEW
        // state.
        System.out.println("State of thread2 after creating it - "
                + thread2.getState());

        thread2.start();

        // thread2 moved to Runnable state
        System.out.println("State of thread2 after calling .start()"
                + " method on it - " + thread2.getState());

        // moving thread2 to timed waiting state
        try {
            // moving thread2 to timed waiting state
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread2 after calling .sleep()"
                + " method on it - " + thread2.getState());

        try {
            // waiting for thread2 to die
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread2 when it has finished "
                + "it's execution - " + thread2.getState());
    }

    public static void initiateProcess(){
        obj = new Test();
        thread1 = new Thread(obj);

        // thread1 created and is currently in the NEW
        // state.
        System.out.println("State of thread1 after creating it - "
                + thread1.getState());

        thread1.start();

        // thread1 moved to Runnable state
        System.out.println("State of thread1 after calling .start()"
                + " method on it - " + thread1.getState());
    }
}