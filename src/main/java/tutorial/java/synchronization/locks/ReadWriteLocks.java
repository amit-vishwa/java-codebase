package tutorial.java.synchronization.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Refer: https://www.geeksforgeeks.org/readwritelock-interface-in-java/
 *
 * A lock is a device for commanding access to an assigned resource by multiple threads. Usually, a lock grants exclusive access
 * to a shared resource: just one thread at a flash can acquire the lock and everyone accesses to the shared resource requires
 * that the lock be acquired first. Though, some locks may allow side-by-side access to a shared resource, as the read lock of
 * a ReadWriteLock.
 * ReadWriteLock is an interface. ReadWriteLock is implemented by ReentrantReadWriteLock Class which is in
 * java.util.concurrent.locks package. So, to use a ReadWriteLock we have to use ReentrantReadWriteLock.
 * A java.util.concurrent.locks.ReadWriteLock is a high-level thread lock tool. It allows various threads to read a specific
 * resource but allows only one to write it, at a time.
 * The approach is, that multiple threads can read from a shared resource without causing concurrency errors. The concurrency
 * errors first occur when writes and reads to a shared resource occur simultaneously, or if multiple writes take place simultaneously.
 *
 * Rules:
 * Read lock and Write lock which allows a thread to lock the ReadWriteLock either for reading or writing.
 * - Read lock: If there is no thread that has requested the write lock and the lock for writing, then multiple threads can lock
 * the lock for reading. It means multiple threads can read the data at the very moment, as long as there’s no thread to write
 * the data or to update the data.
 * - Write Lock: If no threads are writing or reading, only one thread at a moment can lock the lock for writing. Other threads
 * have to wait until the lock gets released. It means, only one thread can write the data at the very moment, and other threads
 * have to wait.
 * */
public class ReadWriteLocks {

    public static void main(String[] args)
    {
        GFG<String> gfg = new GFG<>();

        gfg.setElement("Hi");
        gfg.setElement("Hey");
        gfg.setElement("Hello");

        System.out.println("Printing the last element : "
                + gfg.getElement(2));
    }
}

// Implementation of ReadWriteLock in Java
class GFG<O> {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final Lock readLock = readWriteLock.readLock();
    private final List<O> list = new ArrayList<>();

    // setElement function sets
    // i.e., write the element to the thread
    public void setElement(O o)
    {
        // acquire the thread for writing
        writeLock.lock();
        try {
            list.add(o);
            System.out.println(
                    "Element by thread "
                            + Thread.currentThread().getName()
                            + " is added");
        }
        finally {
            // To unlock the acquired write thread
            writeLock.unlock();
        }
    }

    // getElement function prints
    // i.e., read the element from the thread
    public O getElement(int i)
    {
        // acquire the thread for reading
        readLock.lock();
        try {
            System.out.println(
                    "Elements by thread "
                            + Thread.currentThread().getName()
                            + " is printed");
            return list.get(i);
        }
        finally {
            // To unlock the acquired read thread
            readLock.unlock();
        }
    }
}
