package tutorial.java.collections.iterableinterface.queueinterface.classes;

import java.util.Iterator;

/**
 * Refer: https://www.geeksforgeeks.org/priority-queue-class-in-java/?ref=lbp
 *
 * The PriorityQueue class in Java is part of the java.util package. It is known that a Queue follows the FIFO(First-In-First-Out)
 * Algorithm, but the elements of the Queue are needed to be processed according to the priority, that’s when the PriorityQueue
 * comes into play.
 * - The PriorityQueue is based on the Priority Heap.
 * - The elements of the priority queue are ordered according to the natural ordering, or by a Comparator provided at queue
 * construction time, depending on which constructor is used.
 * - No Null Elements are available in PriorityQueue it will throw NullPointerException in such a case.
 * - Size of the Priority Queue is dynamic , means will increase or decrease as required.
 *
 * A few important points on Priority Queue are as follows:
 * - PriorityQueue doesn’t permit null.
 * - We can’t create a PriorityQueue of Objects that are non-comparable
 * - PriorityQueue are unbound queues.
 * - The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for the
 * least value, the head is one of those elements — ties are broken arbitrarily.
 * - Since PriorityQueue is not thread-safe, java provides PriorityBlockingQueue class that implements the BlockingQueue
 * interface to use in a java multithreading environment.
 * - The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.
 * - It provides O(log(n)) time for add and poll methods.
 * - It inherits methods from AbstractQueue, AbstractCollection, Collection, and Object class.
 * */
public class PriorityQueue {

    public static void main(String[] args) {

        // Create a priority queue with initial capacity 10
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(10);

        // Add elements to the queue => O(log n)
        pq.add(3);
        pq.add(1);
        pq.add(2);
        pq.add(5);
        pq.add(4);

        // Iterate the queue => O(n)
        Iterator iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Peek at the top element of the queue => O(1)
        System.out.println("Peek: " + pq.peek());

        // Remove the top element of the queue => O(log n)
        pq.poll();

        // Print the queue again
        System.out.println("Priority queue after removing top element: " + pq);

        // Check if the queue contains a specific element => O(log n)
        System.out.println("Does the queue contain 3? " + pq.contains(3));

        // Get the size of the queue => O(1)
        System.out.println("Size of queue: " + pq.size());

        // Check if the queue is empty => O(1)
        System.out.println("Is the queue empty? " + pq.isEmpty());

        // Remove all elements from the queue => O(n)
        pq.clear();

        // Check if the queue is empty => O(1)
        System.out.println("After clear, is queue empty? " + pq.isEmpty());
    }
}