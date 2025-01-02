package tutorial.java.collections.iterableinterface.queueinterface.deque.classes;

import java.util.Deque;
import java.util.Iterator;

/**
 * Refer: https://www.geeksforgeeks.org/arraydeque-in-java/
 *
 * The ArrayDeque in Java provides a way to apply resizable-array in addition to the implementation of the Deque interface. It is
 * also known as Array Double Ended Queue or Array Deck. This is a special kind of array that grows and allows users to add or
 * remove an element from both sides of the queue.
 * The ArrayDeque class in Java is an implementation of the Deque interface that uses a resizable array to store its elements.
 * This class provides a more efficient alternative to the traditional Stack class, which was previously used for double-ended
 * operations. The ArrayDeque class provides constant-time performance for inserting and removing elements from both ends of the
 * queue, making it a good choice for scenarios where you need to perform many add and remove operations.
 *
 * Few important features of ArrayDeque are as follows:
 * - Array deques have no capacity restrictions and they grow as necessary to support usage.
 * - They are not thread-safe which means that in the absence of external synchronization, ArrayDeque does not support concurrent
 * access by multiple threads.
 * - Null elements are prohibited in the ArrayDeque.
 * - ArrayDeque class is likely to be faster than Stack when used as a stack.
 * - ArrayDeque class is likely to be faster than LinkedList when used as a queue.
 *
 * Interfaces implemented by ArrayDeque:
 * The ArrayDeque class implements these two interfaces:
 * - Queue Interface: It is an Interface that is a FirstIn – FirstOut Data Structure where the elements are added from the back.
 * - Deque Interface: It is a Doubly Ended Queue in which you can insert the elements from both sides. It is an interface that
 * implements the Queue.
 * ArrayDeque implements both Queue and Deque. It is dynamically resizable from both sides. All implemented interfaces of
 * ArrayDeque in the hierarchy are Serializable, Cloneable, Iterable<E>, Collection<E>, Deque<E>, Queue<E>
 * */
public class ArrayDeque {

    public static void main(String[] args)
    {
        // Adding operation
        System.out.println("1.Add operation:");
        addOperation();
        // Accessing operation
        System.out.println("\n2.Access operation:");
        accessOperation();
        // Removing operations
        System.out.println("\n3.Remove operation:");
        removeOperation();
        // Iterating through the Deque
        System.out.println("\n4.Iterate operation:");
        iterateOperation();
    }

    /**
     * Operation 1: Adding Elements
     * In order to add an element to the ArrayDeque, we can use the methods  add(), addFirst(), addLast(), offer(), offerFirst(),
     * offerLast() methods.
     * add()
     * addFirst()
     * addLast()
     * offer()
     * offerFirst()
     * offerLast()
     * */
    private static void addOperation() {
        // Initializing a deque
        // since deque is an interface
        // it is assigned the
        // ArrayDeque class
        Deque<String> dq = new java.util.ArrayDeque<String>();

        // add() method to insert
        dq.add("The"); // adds at end
        dq.addFirst("To");
        dq.addLast("Geeks");

        // offer() method to insert
        dq.offer("For"); // adds at end
        dq.offerFirst("Welcome");
        dq.offerLast("Geeks");

        // Printing Elements of ArrayDeque to the console
        System.out.println("ArrayDeque : " + dq);
    }

    /**
     * Operation 2: Accessing the Elements
     * After adding the elements, if we wish to access the elements, we can use inbuilt methods like getFirst(), getLast(), etc.
     * getFirst()
     * getLast()
     * peek()
     * peekFirst()
     * peekLast()
     * */
    private static void accessOperation() {
        // Creating an empty ArrayDeque
        java.util.ArrayDeque<String> de_que
                = new java.util.ArrayDeque<String>();

        // Using add() method to add elements into the Deque
        // Custom input elements
        de_que.add("Welcome");
        de_que.add("To");
        de_que.add("Geeks");
        de_que.add("4");
        de_que.add("Geeks");

        // Displaying the ArrayDeque
        System.out.println("ArrayDeque: " + de_que);

        // Displaying the First element
        System.out.println("The first element is: "
                + de_que.getFirst());

        // Displaying the Last element
        System.out.println("The last element is: "
                + de_que.getLast());
    }

    /**
     * Operation 3. Removing Elements
     * In order to remove an element from a deque, there are various methods available. Since we can also remove from both
     * the ends, the deque interface provides us with removeFirst(), removeLast() methods. Apart from that, this interface also
     * provides us with the poll(), pop(), pollFirst(), pollLast() methods where pop() is used to remove and return the head of
     * the deque. However, poll() is used because this offers the same functionality as pop() and doesn’t return an exception
     * when the deque is empty. These sets of operations are as listed below as follows:
     * remove()
     * removeFirst()
     * removeLast()
     * poll()
     * pollFirst()
     * pollLast()
     * pop()
     * */
    private static void removeOperation() {
        // Initializing a deque
        Deque<String> dq = new java.util.ArrayDeque<String>();

        // add() method to insert
        dq.add("One");

        // addFirst inserts at the front
        dq.addFirst("Two");

        // addLast inserts at the back
        dq.addLast("Three");

        // print elements to the console
        System.out.println("ArrayDeque : " + dq);

        // remove element as a stack from top/front
        System.out.println(dq.pop());

        // remove element as a queue from front
        System.out.println(dq.poll());

        // remove element from front
        System.out.println(dq.pollFirst());

        // remove element from back
        System.out.println(dq.pollLast());

    }

    /**
     * Operation 4: Iterating through the Deque
     * Since a deque can be iterated from both directions, the iterator method of the deque interface provides us two ways to
     * iterate. One from the first and the other from the back. These sets of operations are listed below as follows:
     * iterator()
     * descendingIterator()
     * */
    private static void iterateOperation() {
        // Declaring and initializing an deque
        Deque<String> dq = new java.util.ArrayDeque<String>();

        // Adding elements at the back
        // using add() method
        dq.add("For");

        // Adding element at the front
        // using addFirst() method
        dq.addFirst("Geeks");

        // add element at the last
        // using addLast() method
        dq.addLast("Geeks");
        dq.add("is so good");

        // Iterate using Iterator interface
        // from the front of the queue
        for (Iterator itr = dq.iterator(); itr.hasNext();) {

            // Print the elements
            System.out.print(itr.next() + " ");
        }

        // New line
        System.out.println();

        // Iterate in reverse sequence in a queue
        for (Iterator itr = dq.descendingIterator();
             itr.hasNext();) {

            System.out.print(itr.next() + " ");
        }

    }
}
