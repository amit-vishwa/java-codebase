package youtube.collection.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ConcurrentLinkedDeque class is a non-blocking, thread-safe double-ended queue.
 * It follows CAS (Compare and Swap) approach.
 *
 * Similar to Deque, it throws exception for 'add' when queue is full, so 'offer' is better. Also, 'poll'
 * can be used instead of 'remove' as it throws exception when queue is empty.
 * */
public class ConcurrentLinkedDequeExample {

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque.add("A"); // A
        concurrentLinkedDeque.addFirst("C"); // C,A
        concurrentLinkedDeque.addLast("E"); // C,A,E
        concurrentLinkedDeque.offer("B"); // C,A,E,B
        concurrentLinkedDeque.addLast("D"); // C,A,E,B,D
//        concurrentLinkedDeque.addLast(null); // throws NullPointerException
//        concurrentLinkedDeque.offer(null); // throws NullPointerException
        System.out.println(concurrentLinkedDeque);

        System.out.println(concurrentLinkedDeque.remove());
        System.out.println(concurrentLinkedDeque.removeFirst());
        System.out.println(concurrentLinkedDeque.removeLast());
        System.out.println(concurrentLinkedDeque.remove());
        System.out.println(concurrentLinkedDeque.remove());
        System.out.println(concurrentLinkedDeque.poll());
    }

}
