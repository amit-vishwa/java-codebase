package youtube.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque interface is double ended queue that extends Queue interface, various classes provides its implementation.
 * It allows insertion and deletion from both ends. It is versatile than regular queues and stacks as it provides
 * support for all of their operations.
 *
 * Classes implementing Deque interface:
 * - ArrayDeque
 * - LinkedList
 *
 * Queue methods:
 * Insertion:
 * - addFirst(E e): inserts specified element at the front
 * - addLast(E e): inserts specified element at the end
 * - offerFirst(E e): inserts specified element at the front if possible
 * - offerLast(E e): inserts specified element at the end if possible
 * Removal:
 * - removeFirst(): retrieves and removes the first element
 * - removeLast(): retrieves and removes the last element
 * - pollFirst(): retrieves and removes the first element, or returns null if empty
 * - pollLast(): retrieves and removes the last element, or returns null if empty
 *
 * Stack methods:
 * - push(E e): adds an element at the front (equivalent to addFirst(E e))
 * - pop(): removes and returns the first element (equivalent to removeFirst())
 * */
public class DequeExample {

    public static void main(String[] args) {
        simpleDequeExample();
    }

    private static void simpleDequeExample() {
        /**
         * 1. Deque using ArrayDeque - faster iteration, low memory, null not allowed.
         * It can be used for simple read operations and iterations with less insertion and deletion at end.
         * No need to shift elements like ArrayList, just shifts head and tail pointers.
         * ArrayDeque uses circular array internally to store elements. It uses head and tail pointers to
         * point to elements. When both head and tail becomes equal then ArrayDeque size increases.
         * */
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(10); // 10
        arrayDeque.addLast(20); // 10,20
        arrayDeque.offerFirst(5); // 5,10,20
        arrayDeque.offerLast(25); // 5,10,20,25
//        arrayDeque.offerFirst(null); // throws NullPointerException
        System.out.println("ArrayDeque: " + arrayDeque);

        /**
         * 2. Deque using LinkedList - slower iteration, requires more memory, null allowed
         * It can be used for insertion and deletion operations in middle
         * */
        Deque<Integer> linkedListDeque = new LinkedList<>();
        linkedListDeque.addFirst(10); // 10
        linkedListDeque.addLast(20); // 10,20
        linkedListDeque.offerFirst(5); // 5,10,20
        linkedListDeque.offerLast(25); // 5,10,20,25
//        linkedListDeque.offerFirst(null); // no exception is thrown
        System.out.println("LinkedList: " + linkedListDeque);
    }

}
