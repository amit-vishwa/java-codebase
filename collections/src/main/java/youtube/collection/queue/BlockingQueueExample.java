package youtube.collection.queue;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * BlockingQueue interface is thread-safe unlike other queue implementations.
 * It is useful where queue want to wait to become non-empty for de-queueing process, or wait to make space for
 * enqueueing process when queue is full.
 * It simplifies concurrency problems like producer-consumer.
 *
 * Standard queues won't wait for any operation, they execute all operations immediately. If queue is empty and
 * remove operation is in progress, no waiting will be done. Similarly, when queue is full and insertion is being
 * performed, it won't wait and execute the next statement of giving error or ignoring.
 *
 * BlockingQueue methods:
 * - put: blocks if queue is full until space becomes available
 * - take: blocks if queue is empty until an element becomes available
 * - offer: waits for space to become available, up to the specified timeout
 *
 * Class implementations - ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue.
 * */
public class BlockingQueueExample {

    public static void main(String[] args) {
//        arrayBlockingQueue();
//        linkedBlockingQueue();
        priorityBlockingQueue();
    }

    private static void arrayBlockingQueue() {
        // ArrayBlockingQueue is a bounded queue (capacity is required), it is backed by circular array
        // low memory overhead, uses single lock for enqueue and dequeue operations, problems with more threads
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        concurrencyInBlockingQueue(arrayBlockingQueue);
    }

    private static void linkedBlockingQueue() {
        // LinkedBlockingQueue is optionally bounded (i.e. capacity is not mandatory), it is backed by linked list
        // uses separate locks for enqueue and dequeue operations, better performance with more threads
        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(); // capacity is int max value
        concurrencyInBlockingQueue(linkedBlockingQueue);
    }

    private static void priorityBlockingQueue() {
        /**
         * PriorityBlockingQueue is unbounded so put operation won't get blocked.
         * It uses BinaryHeap as array and can grow dynamically. Head is based on their natural
         * ordering or a provided custom Comparator like PriorityQueue. Elements won't be sorted only head is.
         * */
        BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>(); // default capacity is 11
        // we can provide initial capacity and custom comparator
//        BlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(20, Comparator.reverseOrder());
//        concurrencyInBlockingQueue(priorityBlockingQueue);
        priorityBlockingQueue.add("banana");
        priorityBlockingQueue.add("mango");
        priorityBlockingQueue.add("apple"); // highest priority as per sorting logic
        System.out.println(priorityBlockingQueue);
    }

    ////////////////////////////    Helper method      ////////////////////////////////////
    /**
     * This method is used to demonstrate the concurrency in BlockingQueue.
     * It creates a producer and consumer thread and starts them.
     * The producer thread produces elements and puts them in the queue.
     * The consumer thread takes elements from the queue and consumes them.
     * */
    private static void concurrencyInBlockingQueue(BlockingQueue<Integer> blockingQueue){
        Thread producer = new Thread(new Producer(blockingQueue));
        Thread consumer = new Thread(new Consumer(blockingQueue));
        producer.start();
        consumer.start();
    }

    ////////////////////////////    Helper classes      ////////////////////////////////////

    static class Producer implements Runnable{

        private BlockingQueue<Integer> queue;
        private int value = 0;

        public Producer(BlockingQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Producer produced: " + value + ", at " + LocalTime.now());
//                queue.offer(value++); // doesn't wait for queue availability to produce something
                    queue.put(value++); // waits until queue becomes available to produce something
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Producer interrupted!");
                }
            }
        }
    }

    static class Consumer implements Runnable{

        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Integer value = queue.take(); // waits until producer produces something to consume
                    System.out.println("Consumer consumed: " + value + ", at " + LocalTime.now());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Consumer interrupted!");
                }
            }
        }
    }

}
