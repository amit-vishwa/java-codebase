package youtube.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue is the part of the Queue interface. It orders elements based on their natural ordering (comparable).
 * Custom comparator can be used for custom ordering. Only primitives wrapper like (Integer,String,etc.) implements
 * Comparable so natural ordering is possible. For custom objects, custom comparator can be used if it not
 * implements Comparable.
 *
 * PriorityQueue is only concerned with the top element, so all ordering are done in such manner that top element
 * is the most sorted one from the queue. It doesn't allow null elements.
 *
 * Internal working of PriorityQueue:
 * - It uses min-heap internally to store elements.
 * - In min-heap, the parent node is always less than or equal to its child nodes.
 * - Hence, the most sorted element will be on top.
 *
 * Time complexity:
 * Insertion - O(log(n))
 * Deletion - O(log(n))
 * Peek - O(1)
 * */
public class PriorityQueueExample {

    public static void main(String[] args) {
        simplePriorityQueueExample();
    }

    private static void simplePriorityQueueExample() {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        // we can provide custom comparator to sort the elements in reverse order
//        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(0);
        priorityQueue.add(10);
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(9);
        System.out.println(priorityQueue); // return un-order not sorted list, as peek gives most sorted element
        // loop can be used along with peek to display elements in sorted order
        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.remove() + " "); // removes in natural sorted order
        }
        System.out.println();
    }

}
