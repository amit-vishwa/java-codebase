package com.crashcourse.threadCommunication;

/**
 * Thread communication is used to save non-required CPU utilization.
 * The consumer thread will always check for data to consume, it will make CPU calls.
 * Now since producer is busy in producing data or doing some tasks then no response.
 * Consumer will make calls multiple times until it gets the data from producer.
 * So, thread communication can be used here where producer will notify consumer
 * when data is produced or and consumer will consume it, while producer will wait.
 * Then consumer notifies producer after data consumption and now producer can produce
 * data while consumer will wait for new data.
 * In this way, no unnecessary CPU calls will be made and CPU utilization will be saved.
 *
 * Below methods are used with synchronized methods or blocks to control the access
 * of multiple threads to a shared resource.:
 * - wait() - causes the current thread to wait until another thread invokes the
 * notify() method or the notifyAll() method for this object.
 * - notify() - wakes up a single thread that is waiting on this object's monitor.
 * - notifyAll() - wakes up all threads that are waiting on this object's monitor.
 *
 * Thread safety:
 * - Thread safety is a property of a program or data structure that guarantees
 * no unexpected results will occur when multiple threads access shared data.
 * - While implementing multi-threading it is important to ensure that object is thread safe.
 * - synchronized, locks, wait(), notify(), and notifyAll() are used to achieve thread safety.
 * */
public class ThreadCommunicationExample {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }

}
