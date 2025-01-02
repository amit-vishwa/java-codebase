package tutorial.java.collections;

import java.util.*;

/**
 * Refer: https://www.geeksforgeeks.org/iterators-in-java/?ref=lbp
 *
 * An Iterator in Java is an interface used to traverse elements in a Collection sequentially. It provides methods like hasNext(),
 * next(), and remove() to loop through collections and perform manipulation. An Iterator is a part of the Java Collection
 * Framework, and we can use it with collections like ArrayList, LinkedList, and other classes that implement the
 * Collection interface.
 *
 * A Java Cursor is an Iterator, that is used to iterate or traverse or retrieve a Collection or Stream object’s elements one by one.
 * Types of Cursors in Java
 * There are 3 cursors in Java as mentioned below:
 * Iterator
 * Enumeration
 * ListIterator
 * Note: SplitIterator can also be considered as a cursor as it is a type of Iterator only.
 *
 * Important Point: Iterator is a concrete implementation of a cursor. The cursor refers to the general concept of traversing
 * a collection but the iterator is one specific implementation of that concept in Java.
 *
 * Types of Iterators
 * 1. ListIterator
 * The ListIterator extends Iterator and allows both forward and backward traversal. It also supports element modification
 * during iteration.
 * ListIterator<E> listItr = list.listIterator();
 * 2. Enumeration
 * An enumeration is an older interface from Java 1.0 used for iterating over collections. It only supports forward iteration
 * and does not allow element removal.
 * Enumeration<E> e = collection.elements();
 * */
public class IteratorInterfaceExample {

    public static void main(String[] args) {
        // Creating an ArrayList
        // object of Integer type
        ArrayList<Integer> al = new ArrayList<>();

        // Adding elements to the ArrayList
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }

        // Printing the original list
        System.out.println("Original List: " + al);
        iterator(al);
        listIterator(al);
        enumIterator(al);
    }

    static void iterator(ArrayList<Integer> al){
        // Creating an Iterator for the ArrayList
        Iterator<Integer> itr = al.iterator();
        // Iterating through the list
        // and removing odd elements
        while (itr.hasNext()) {
            // Getting the next element
            int i = itr.next();
            System.out.print(i + " ");
            // Removing odd elements
            if (i % 2 != 0) {
                itr.remove();
            }
        }
        // Moving to the next line
        System.out.println();
        // Printing the modified list
        // after removal of odd elements
        System.out.println("Modified List: " + al);

    }

    static void listIterator(ArrayList<Integer> al){
        // Creating an Iterator for the ArrayList
        ListIterator<Integer> itr = al.listIterator();
        // Iterating through the list
        // and removing odd elements
        while (itr.hasNext()) {
            // Getting the next element
            int i = itr.next();
            System.out.print(i + " ");
            // Removing odd elements
            if (i % 4 == 0) {
                itr.remove();
            }
        }
        // Moving to the next line
        System.out.println();
        // Printing the modified list
        // after removal of odd elements
        System.out.println("Modified List: " + al);
    }

    static void enumIterator(ArrayList<Integer> al){
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        // Creating an Iterator for the ArrayList
        Enumeration<Integer> itr = v.elements();
        // Iterating through the list
        // and removing odd elements
        while (itr.hasMoreElements()) {
            // Getting the next element
            int i = itr.nextElement();
            System.out.print(i + " ");
        }
        // Moving to the next line
        System.out.println();
        // Printing the modified list
        // after removal of odd elements
        System.out.println("Modified List: " + al);
    }

}