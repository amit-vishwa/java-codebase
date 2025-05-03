package youtube.collection.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ConcurrentLinkedQueue is an implementation of the Queue interface that supports lock-free, thread-safe operations.
 * In ConcurrentLinkedQueue, simultaneous put operations or take operations or both can be performed.
 * */
public class ConcurrentLinkedQueueExample {

    public static void main(String[] args) {
//        blockingThreadSafety();
        nonBlockingThreadSafety();
    }

    private static void blockingThreadSafety(){
        BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>(); // applies locks for every operation
        Thread producer = new Thread(()->{
            while (true){
                try {
                    taskQueue.put("Task " + System.currentTimeMillis()); // adds task (uses locks internally)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            while (true){
                try {
                    String task = taskQueue.take(); // takes task (uses locks internally)
                    System.out.println("Processing: " + task);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }

    private static void nonBlockingThreadSafety() {
        // similar to ConcurrentHashMap, it uses compare and swap technique internally
        ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>(); // no locks for any operation
        Thread producer = new Thread(()->{
            while (true){
                taskQueue.add("Task " + System.currentTimeMillis()); // lock free add task using compare and swap
            }
        });

        Thread consumer = new Thread(()->{
            while (true){
                String task = taskQueue.poll(); // lock free take task using compare and swap
                System.out.println("Processing: " + task);
            }
        });

        producer.start();
        consumer.start();
    }

}
