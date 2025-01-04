package tutorial.java.synchronization.deadlock;

/**
 * To avoid the deadlock situation in the current file, we can use a technique called "lock ordering." This involves ensuring
 * that all threads acquire the locks in the same order. Below is the corrected code.
 *
 * In this corrected code, both Thread1 and Thread2 acquire the locks in the same order (s1 first, then s2), which prevents the
 * deadlock situation.
 * */
public class DeadlockSolution {

    public static void main(String[] args) {
        SharedResource s1 = new SharedResource();
        SharedResource s2 = new SharedResource();
        Threads1 t1 = new Threads1(s1, s2);
        t1.setName("Thread1");
        t1.start();
        Threads2 t2 = new Threads2(s1, s2);
        t2.setName("Thread2");
        t2.start();
        Util.sleep(2000);
    }
}

class SharedResource {
    synchronized void test1(SharedResource s2) {
        System.out.println(Thread.currentThread().getName() + " enters test1 of " + this);
        Util.sleep(1000);
        synchronized (s2) {
            s2.test2();
        }
        System.out.println(Thread.currentThread().getName() + " exits test1 of " + this);
    }

    synchronized void test2() {
        System.out.println(Thread.currentThread().getName() + " enters test2 of " + this);
        Util.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " exits test2 of " + this);
    }
}

class Threads1 extends Thread {
    private SharedResource s1;
    private SharedResource s2;

    public Threads1(SharedResource s1, SharedResource s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        synchronized (s1) {
            s1.test1(s2);
        }
    }
}

class Threads2 extends Thread {
    private SharedResource s1;
    private SharedResource s2;

    public Threads2(SharedResource s1, SharedResource s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        synchronized (s1) {
            s2.test1(s1);
        }
    }
}