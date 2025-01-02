package tutorial.java.collections.iterableinterface.queueinterface.deque;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Refer: https://www.geeksforgeeks.org/deque-interface-java-example/?ref=lbp
 *
 * Deque Interface present in java.util package is a subtype of the queue interface. The Deque is related to the double-ended
 * queue that supports adding or removing elements from either end of the data structure. It can either be used as a
 * queue(first-in-first-out/FIFO) or as a stack(last-in-first-out/LIFO). Deque is the acronym for double-ended queue.
 * - Null Handling: Most implementations do not allow null elements, as null is used as a special return value to indicate the
 * absence of elements.
 * - Thread-Safe Alternatives: Use ConcurrentLinkedDeque or LinkedBlockingDeque for thread-safe operations and avoid ArrayDeque
 * in concurrent environments as it is not thread-safe.
 * */
public class InterfaceExample {

    public static void main(String[] args)
    {
        Deque<String> deque
                = new LinkedList<String>();

        // 1. Adding Elements
        // We can add elements to the queue
        // in various ways
        // Add at the last
        deque.add("Element 1 (Tail)");
        // Add at the first
        deque.addFirst("Element 2 (Head)");
        // Add at the last
        deque.addLast("Element 3 (Tail)");
        // Add at the first
        deque.push("Element 4 (Head)");
        // Add at the last
        deque.offer("Element 5 (Tail)");
        // Add at the first
        deque.offerFirst("Element 6 (Head)");
        System.out.println(deque + "\n");

        // 2. Removing Elements
        // We can remove the first element
        // or the last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing "
                + "first and last: "
                + deque);
        System.out.println(deque.pop());
        System.out.println(deque.poll());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());

        // 3. Iterating through the Deque
        deque.add("For");
        deque.addFirst("Geeks");
        deque.addLast("Geeks");
        deque.add("is so good");
        for (Iterator itr = deque.iterator();
             itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        for (Iterator itr = deque.descendingIterator();
             itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }
    }

}