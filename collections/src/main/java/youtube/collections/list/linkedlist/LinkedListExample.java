package youtube.collections.list.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList data structure stores the data and the address of next node.
 * There are 3 types of LinkedList:
 * - Singly LinkedList: It stores data and address of next node, last node will point to null
 * - Doubly LinkedList: It stores data and address of prev and next node, last node's next and first's prev
 * will point to null
 * - Circular LinkedList: It can be of Singly and Doubly LinkedList
 * i.Singly Circular LinkedList: Similar to Singly LinkedList, only last node will point to first node
 * ii.Double Circular LinkedList: Similar to Doubly LinkedList, only last node's next and first's prev will
 * point to first and last node respectively
 *
 * The LinkedList class in Java is a part of Collection framework and implements the List interface.
 * Unlike ArrayList which uses a dynamic array to store elements, LinkedList stores its elements as nodes in
 * Doubly Linked List.
 * This provides different performance characteristics and usage scenarios compared to ArrayList.
 *
 * Performance Considerations:
 * - Insertions and deletions in middle of list is better than ArrayList as only reference pointer is updated.
 * - Random access is slower than ArrayList as it requires list traversal.
 * - Memory overhead as it stores data as well as object references of next and previous node.
 * */
public class LinkedListExample {

    public static void main(String[] args) {
        simpleLinkedListOperations();
    }

    private static void simpleLinkedListOperations() {
        // Reference of List (i.e. parent class) can be used but to access all methods use LinkedList reference
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2,3); // add 3 at index 2
        list.add(2); // O(n)
        list.addLast(4); // O(1)
        list.addFirst(0); // O(1)
        System.out.println("Original LinkedList: " + list);
        System.out.println("First element: " + list.getFirst() + ", Last element: " + list.getLast());
        list.remove(1);
        System.out.println("LinkedList after removal of element at index 1: " + list);
        list.removeLastOccurrence(2); // if found then remove else do nothing
        System.out.println("LinkedList after removal last occurrence of 2: " + list);
        list.removeIf(x-> x % 2 == 0);
        System.out.println("LinkedList after removing even numbers: " + list);

        List<Integer> newList = new LinkedList<>(Arrays.asList(4,5,6));
        System.out.println("Another List: " + newList);
        list.addAll(newList);
        System.out.println("LinkedList after adding another list: " + list);
        List<Integer> elementsToRemove = new LinkedList<>(Arrays.asList(46,6,90));
        list.removeAll(elementsToRemove);
        System.out.println("LinkedList after removing another list elements: " + list);
    }

}
