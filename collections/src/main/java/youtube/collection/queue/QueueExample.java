package youtube.collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Queue is an interface in collections framework that extends Collection interface. It is based on FIFO principle.
 * The interface provides various methods to perform queue operations for ease of coding.
 *
 * Queue implementation classes - LinkedList, PriorityQueue, BlockingQueue, ArrayBlockingQueue, LinkedBlockingQueue,
 * PriorityBlockingQueue, SynchronousQueue, DelayQueue, ConcurrentLinkedQueue.
 *
 * Queue performs below operations:
 * - Enqueue - methods -> add, offer
 * - Dequeue - methods -> remove, poll
 * - Peek - methods -> peek, element
 *
 * Queue:
 * 1.LinkedList - no thread safety
 * 2.PriorityQueue - no thread safety
 * 3.Deque interface - no thread safety
 *  3.1.ArrayDeque
 *  3.2.LinkedList
 * 4.ConcurrentLinkedDeque - non-blocking thread safe, double-ended queue
 * 5.BlockingQueue interface - blocking thread safety
 *  5.1.ArrayBlockingQueue
 *  5.2.LinkedBlockingQueue
 *  5.3.PriorityBlockingQueue
 *  5.5.SynchronousQueue
 *  5.6.DelayQueue
 * 6.ConcurrentLinkedQueue - non-blocking thread safety
 * */
public class QueueExample {

    public static void main(String[] args) {
//        simpleLinkedListUseCase();
//        simpleQueueOperations();
        arrayBlockingQueueExample();
    }

    private static void simpleLinkedListUseCase() {
        // 1. LinkedList as Stack
        linkedListAsStack();

        // 2. LinkedList as Queue
        linkedListAsQueue();
    }

    private static void simpleQueueOperations() {
        Queue<Integer> linkedListQueue = new LinkedList<>();
//        linkedListQueue.addLast(); // all such method are not present in Queue interface
        // enqueueing
        linkedListQueue.add(1);
        linkedListQueue.offer(1);
        // de-queueing
        System.out.println(linkedListQueue.poll()); // removes 1
        System.out.println(linkedListQueue.remove()); // removes last element 1
        System.out.println(linkedListQueue.poll()); // returns null since list is empty
//        System.out.println(linkedListQueue.remove()); // throws exception for empty list
        // peeking
        System.out.println(linkedListQueue.peek()); // returns null since list is empty
//        System.out.println(linkedListQueue.element()); // throws exception for empty list
    }

    private static void arrayBlockingQueueExample() {
        // ArrayBlockingQueue accepts required parameter capacity, it is not initial capacity which is updated later
        Queue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.add(1); // returns true after successful enqueue
        arrayBlockingQueue.add(2); // returns true after successful enqueue
//        arrayBlockingQueue.add(3); // throws exception when queue is full
        arrayBlockingQueue.offer(3); // won't throw any exception when queue is full, just returns false
        System.out.println(arrayBlockingQueue);
    }

    private static void linkedListAsStack(){
        LinkedList<Integer> stack = new LinkedList<>();
        // push
        stack.addFirst(1); // 1
        stack.addFirst(2); // 2,1
        stack.addFirst(3); // 3,2,1
        stack.addFirst(4); // 4,3,2,1
        stack.addFirst(5); // 5,4,3,2,1
        System.out.println("Stack: " + stack); // 5 on top(first) and 1 on bottom(last) as per stack logic
        // pop
        System.out.println("Element popped: " + stack.removeFirst()); // removed 5
        System.out.println("Element popped: " + stack.removeFirst()); // removed 4
        System.out.println("Stack: " + stack); // updated stack after removal of 2 elements from top
        System.out.println("Peek element: " + stack.peek()); // returns top element which will get popped next
    }

    private static void linkedListAsQueue(){
        LinkedList<Integer> queue = new LinkedList<>();
        // enqueue
        queue.addLast(1); // 1
        queue.addLast(2); // 1,2
        queue.addLast(3); // 1,2,3
        queue.addLast(4); // 1,2,3,4
        queue.addLast(5); // 1,2,3,4,5
        System.out.println("Queue: " + queue); // 1 at first and 5 at last as per queue logic
        // dequeue
        System.out.println("Element dequeued: " + queue.removeFirst()); // removed 1
        System.out.println("Element dequeued: " + queue.removeFirst()); // removed 2
        System.out.println("Element dequeued: " + queue.removeFirst()); // removed 3
        System.out.println("Queue: " + queue); // updated queue after removal of 2 elements from first
        System.out.println("Peek element: " + queue.peek()); // returns first element which will get dequeued next
    }

}
