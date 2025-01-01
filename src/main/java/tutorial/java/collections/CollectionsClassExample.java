package tutorial.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Refer: https://www.geeksforgeeks.org/collections-class-in-java/?ref=lbp
 *
 * Collections class in Java is one of the utility classes in Java Collections Framework. The java.util package contains the
 * Collections class in Java. Java Collections class is used with the static methods that operate on the collections or return
 * the collection. All the methods of this class throw the NullPointerException if the collection or object passed to the methods
 * is null.
 *
 * The Collection classes in Java are mentioned below (i.e. classes from Collection framework):
 * 1. ArrayList
 * ArrayList is a class implemented using a list interface, in that provides the functionality of a dynamic array where the size of the array is not fixed.
 * Syntax: ArrayList<_type_> var_name = new ArrayList<_type_>();
 *
 * 2. Vector
 * Vector is a Part of the collection class that implements a dynamic array that can grow or shrink its size as required.
 * Syntax: public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
 *
 * 3. Stack
 * Stack is a part of Java collection class that models and implements a Stack data structure. It is based on the basic principle of last-in-first-out(LIFO).
 * Syntax: public class Stack<E> extends Vector<E>
 *
 * 4. LinkedList
 * LinkedList class is an implementation of the LinkedList data structure. It can store the elements that are not stored in contiguous locations and every element is a separate object with a different data part and different address part.
 * Syntax: LinkedList<_type_> var_name = new LinkedList<_type_>();
 *
 * 5. HashSet
 * HashSet is implemented using the Hashtable data structure. It offers constant time performance for the performing operations like add, remove, contains, and size.
 * Syntax: public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable
 *
 * 6. LinkedHashSet
 * LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements.
 * Syntax: public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable
 *
 * 7. TreeSet
 * TreeSet class is implementations of the SortedSet interface in Java that uses a Tree for storage. The ordering of the elements is maintained by a set using their natural ordering whether an explicit comparator is provided or not.
 * Syntax: TreeSet<E> set = new TreeSet<>();
 *
 * 8. PriorityQueue
 * The PriorityQueue is based on the priority heap. The elements of the priority queue are ordered according to the natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used.
 * Syntax: public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable
 *
 * 9. ArrayDeque
 * The ArrayDeque class in Java is an implementation of the Deque interface that uses a resizable array to store its elements. The ArrayDeque class provides constant-time performance for inserting and removing elements from both ends.
 * Syntax: public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable,Serializable
 *
 * 10. HashMap
 * HashMap Class is similar to HashTable but the data unsynchronized. It stores the data in (Key, Value) pairs, and you can access them by an index of another type.
 * Syntax: public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
 *
 * 11. EnumMap
 * EnumMap extends AbstractMap and implements the Map interface in Java.
 * Syntax: public class EnumMap<K extends Enum<K>,V> extends AbstractMap<K,V> implements Serializable, Cloneable
 *
 * 12. AbstractMap
 * The AbstractMap class is a part of the Java Collection Framework. It implements the Map interface to provide a structure to it, by doing so it makes the further implementations easier.
 * Syntax: public abstract class AbstractMap<K,V> implements Map<K,V>
 *
 * 13. TreeMap
 * A TreeMap is implemented using a Red-Black tree.TreeMap provides an ordered collection of key-value pairs, where the keys are ordered based on their natural order or a custom Comparator passed to the constructor.
 * Syntax: SortedMap<K, V> m = Collections.synchronizedSortedMap(new TreeMap<>());
 *
 * Java Collections Example
 * Examples of Collections Classes in Java are mentioned below:
 * - Adding Elements to the Collections
 * - Sorting a Collection
 * - Searching in a Collection
 * - Copying Elements
 * - Disjoint Collection
 * */
public class CollectionsClassExample {

    public static void main(String[] args) {
        System.out.println("1.Adding Elements to the Collections:");
        addElements();
        System.out.println("\n\n2.Sorting a Collection:");
        sortElements();
        System.out.println("\n\n3.Searching in a Collection:");
        searchElement();
        System.out.println("\n\n4.Copying Elements:");
        copyElements();
        System.out.println("\n\n5.Disjoint Collection:");
        disjointedElements();
    }

    /**
     * 1. Adding Elements to the Collections Class Object
     * The addAll() method of java.util.Collections class is used to add all the specified elements to the specified
     * collection. Elements to be added may be specified individually or as an array.
     * */
    static void addElements(){
        List<String> l = new ArrayList<>();
        // Adding elements to the list
        l.add("Shoes");
        l.add("Toys");
        // Add one or more elements
        Collections.addAll(l, "Fruits", "Bat", "Ball");
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
    }

    /**
     * 2. Sorting a Collection
     * Collections.sort() is used to sort the elements present in the specified list of Collections in ascending order.
     * Collections.reverseOrder() is used to sort in descending order.
     * */
    static void sortElements(){
        List<String> l = new ArrayList<>();
        // Adding elements to the list
        // using add() method
        l.add("Shoes");
        l.add("Toys");
        // Adding one or more
        // element using addAll()
        Collections.addAll(l, "Fruits", "Bat", "Mouse");
        // Sorting according to default ordering
        // using sort() method
        Collections.sort(l);
        // Printing the elements
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
        System.out.println();
        // Sorting according to reverse ordering
        Collections.sort(l, Collections.reverseOrder());
        // Printing the reverse order
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
    }

    /**
     * 3. Searching in a Collection
     * Collections.binarySearch() method returns the position of an object in a sorted list. To use this method, the list
     * should be sorted in ascending order, otherwise, the result returned from the method will be wrong. If the element
     * exists in the list, the method will return the position of the element in the sorted list, otherwise, the result
     * returned by the method would be the – (insertion point where the element should have been present if exist)-1).
     * */
    static void searchElement(){
        List<String> l = new ArrayList<>();
        // Adding elements to object
        // using add() method
        l.add("Shoes");
        l.add("Toys");
        l.add("Horse");
        l.add("Ball");
        l.add("Grapes");
        // Sort the List
        Collections.sort(l);
        // BinarySearch on the List
        System.out.println(
                "The index of Horse is: "
                        + Collections.binarySearch(l, "Horse"));
        // BinarySearch on the List
        System.out.println(
                "The index of Dog is: "
                        + Collections.binarySearch(l, "Dog"));
    }

    /**
     * 4. Copying Elements
     * The copy() method of Collections class is used to copy all the elements from one list into another. After the operation,
     * the index of each copied element in the destination list will be identical to its index in the source list. The
     * destination list must be at least as long as the source list. If it is longer, the remaining elements in the destination
     * list are unaffected.
     * */
    static void copyElements(){
        List<String> l1 = new ArrayList<>();
        // Add elements
        l1.add("Shoes");
        l1.add("Toys");
        l1.add("Horse");
        l1.add("Tiger");
        // Print the elements
        System.out.println(
                "The Original Destination list is: ");
        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) + " ");
        }
        System.out.println();
        // Create source list
        List<String> l2 = new ArrayList<>();
        // Add elements
        l2.add("Bat");
        l2.add("Frog");
        l2.add("Lion");
        // Copy (& replace destination elements) the elements from source l2 to destination l1
        Collections.copy(l1, l2);
        // Printing the modified list
        System.out.println(
                "The Destination List After copying is: ");
        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) + " ");
        }
    }

    /**
     * 5. Disjoint Collection
     * Collections.disjoint() is used to check whether two specified collections are disjoint or not. More formally, two
     * collections are disjoint if they have no elements in common. It returns true if the two collections do not have any
     * element in common.
     * */
    static void disjointedElements(){
        List<String> l1 = new ArrayList<>();
        // Add elements to l1
        l1.add("Shoes");
        l1.add("Toys");
        l1.add("Horse");
        l1.add("Tiger");
        List<String> l2 = new ArrayList<>();
        // Add elements to l2
        l2.add("Bat");
        l2.add("Frog");
        l2.add("Lion");
        // Check if disjoint or not
        System.out.println(
                Collections.disjoint(l1, l2));
        l2.add("Tiger");
        // Check if disjoint or not
        System.out.println(
                Collections.disjoint(l1, l2));
    }

}
