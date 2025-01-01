package tutorial.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Refer: https://www.geeksforgeeks.org/collection-interface-in-java-with-examples/?ref=next_article
 *
 * Collection Interface in Java
 * The Collection interface in Java is a core member of the Java Collections Framework located in the java.util package.
 * It is one of the root interfaces of the Java Collection Hierarchy. The Collection interface is not directly implemented
 * by any class. Instead, it is implemented indirectly through its sub-interfaces like List, Queue, and Set.
 * For Example, the ArrayList class implements the List interface, a sub-interface of the Collection interface.
 *
 * Collection Interface Declaration
 * public interface Collection<E> extends Iterable<E>
 * Here, E represents the type of elements stored in the collection.
 *
 * Note: In the above syntax, we can replace any class with ArrayList if that class implements the Collection interface.
 *
 * Hierarchy of Collection Interface
 * The Collection interface is part of a hierarchy that extends Iterable, means collections can be traversed.
 * The hierarchy also includes several key sub-interfaces:
 * - Iterable
 * - Collection
 *  -> List
 *  -> Set
 *  -> Queue
 *  -> Deque
 *  -> SortedSet
 *  -> NavigableSet
 * */
public class CollectionInterfaceExample {

    public static void main(String[] args) {
        System.out.println("1.Adding Elements to the Collection:");
        addElements();
        System.out.println("\n\n2.Removing Elements from a Collection:");
        removeElements();
        System.out.println("\n\n3.Iterating Elements in a Collection:");
        iterateElements();
    }

    /**
     * 1. Adding Elements to a Collection
     * The add(E e) and addAll(Collection c) methods provided by Collection can be used to add elements.
     * */
    private static void addElements() {
        // create an empty ArrayList
        // with an initial capacity
        Collection<Integer> l1 = new ArrayList<Integer>(5);
        // use add() method to
        // add elements in the list
        l1.add(15);
        l1.add(20);
        l1.add(25);
        // prints all the elements available in list
        for (Integer n : l1) {
            System.out.println("Number = " + n);
        }
        // Creating another empty ArrayList
        Collection<Integer> l2 = new ArrayList<Integer>();
        // Appending the collection to the list
        l2.addAll(l1);
        // displaying the modified ArrayList
        System.out.println("The new ArrayList is: " + l2);
    }

    /**
     * 2. Removing Elements from a Collections
     * The remove(E e) and removeAll(Collection c) methods can be used to remove a particular element or a Collection of elements
     * from a collection.
     * */
    private static void removeElements() {
        // Creating object of HashSet
        Collection<Integer> hs1 = new HashSet<Integer>();
        hs1.add(1);
        hs1.add(2);
        hs1.add(3);
        hs1.add(4);
        hs1.add(5);
        System.out.println("Initial set: " + hs1);
        // remove a particular element
        hs1.remove(4);
        System.out.println("Set after removing 4: " + hs1);
        // Creating another object of HashSet
        Collection<Integer> hs2 = new HashSet<Integer>();
        hs2.add(1);
        hs2.add(2);
        hs2.add(3);
        System.out.println("Collection Elements to be removed: " + hs2);
        // Removing elements from hs1
        // specified in hs2
        // using removeAll() method
        hs1.removeAll(hs2);
        System.out.println("Set 1 after removeAll() operation: " + hs1);
    }

    /**
     * 3. Iterating over a Collection
     * To iterate over the elements of Collection we can use iterator() method.
     * */
    private static void iterateElements() {
        // Create and populate the list
        Collection<String> l = new LinkedList<>();
        l.add("Geeks");
        l.add("for");
        l.add("Geeks");
        // Displaying the list
        System.out.println("The list is:" + l);
        // Create an iterator for the list
        // using iterator() method
        Iterator<String> it = l.iterator();
        // Displaying the values after iterating
        // through the list
        System.out.println("The iterator values of list are: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }

}
