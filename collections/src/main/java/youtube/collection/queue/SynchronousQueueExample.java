package youtube.collection.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * In SynchronousQueue class, each insert operation must wait for a corresponding remove operation by another
 * thread and vice versa. It cannot store elements, max capacity is one.
 * */
public class SynchronousQueueExample {

    public static void main(String[] args) {
        simpleSynchronousQueueExample();
    }

    private static void simpleSynchronousQueueExample() {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

        Thread producer = new Thread(()->{
            try {
                System.out.println("Producer is waiting to transfer...");
                synchronousQueue.put("Hello from producer!");
                System.out.println("Producer has transferred the message.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer get interrupted!");
            }
        });

        Thread consumer = new Thread(()->{
            try {
                System.out.println("Consumer is waiting to receive...");
                String message = synchronousQueue.take();
                System.out.println("Consumer received: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer get interrupted!");
            }
        });

        producer.start();
        consumer.start();
    }

}
