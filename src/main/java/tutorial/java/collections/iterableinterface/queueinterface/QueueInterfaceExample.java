package tutorial.java.collections.iterableinterface.queueinterface;

import java.util.*;

/**
 * Refer: https://www.geeksforgeeks.org/queue-interface-java/?ref=lbp
 *
 * Queue Interface In Java
 * The Queue Interface is present in java.util package and extends the Collection interface. It stores and processes the data in
 * FIFO(First In First Out) order. It is an ordered list of objects limited to inserting elements at the end of the list and
 * deleting elements from the start of the list.
 * - No Null Elements: Most implementations like PriorityQueue do not allow null elements.
 * - Implementation Classes: LinkedList , PriorityQueue, ArrayDeque, ConcurrentLinkedQueue (for thread-safe operations).
 * - Use Cases: Commonly used for Task scheduling, Message passing, and Buffer management in applications.
 * - Iteration: Supports iterating through elements. The order of iteration depends on the implementation.
 *
 * Being an interface the queue needs a concrete class for the declaration and the most common classes are the PriorityQueue and
 * LinkedList in Java. Note that neither of these implementations is thread-safe. PriorityBlockingQueue is one alternative
 * implementation if the thread-safe implementation is needed.
 *
 * The Queue interface provides several methods for adding, removing, and inspecting elements in the queue.
 * Here are some of the most commonly used methods:
 * - add(element): Adds an element to the rear of the queue. If the queue is full, it throws an exception.
 * - offer(element): Adds an element to the rear of the queue. If the queue is full, it returns false.
 * - remove(): Removes and returns the element at the front of the queue. If the queue is empty, it throws an exception.
 * - poll(): Removes and returns the element at the front of the queue. If the queue is empty, it returns null.
 * - element(): Returns the element at the front of the queue without removing it. If the queue is empty, it throws an exception.
 * - peek(): Returns the element at the front of the queue without removing it. If the queue is empty, it returns null.
 * */
public class QueueInterfaceExample {

    public static void main(String args[])
    {
//        Queue<String> pq = new PriorityQueue<>(); // Ascending Priority Queue
//        Queue<String> pq = new PriorityQueue<>(Collections.reverseOrder()); // Descending Priority Queue
        Queue<String> pq = new LinkedList<>();

        // 1. Adding Elements:
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
        System.out.println("Initial Queue " + pq);
        // Peek
        System.out.println("head of queue-" + pq.peek());

        // 2. Removing Elements:
        pq.remove("Geeks");
        System.out.println("After Remove " + pq);
        System.out.println("Poll Method " + pq.poll());
        System.out.println("Final Queue " + pq);

        // 3. Iterating the Queue:
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
        Iterator iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}