package tutorial.java.collections.iterableinterface.listinterface.classes;

import java.util.Vector;

/**
 * Refer: https://www.geeksforgeeks.org/java-util-vector-class-java/?ref=next_article
 *
 * The Vector class implements a growable array of objects. Vectors fall in legacy classes, but now it is fully compatible with
 * collections. It is found in java.util package and implement the List interface.
 * Thread-Safe: All methods are synchronized, making it suitable for multi-threaded environments. However, this can lead to
 * performance overhead in single-threaded scenarios.
 * Allows Nulls: Can store null elements.
 * Enumeration Support: Provides backward compatibility with Enumeration, a legacy way of iterating over elements.
 *
 * Few more points about Vector are mentioned below:
 * They are very similar to ArrayList, but Vector is synchronized and has some legacy methods that the collection framework does not contain.
 * It also maintains an insertion order like an ArrayList. Still, it is rarely used in a non-thread environment as it is
 * synchronized, and due to this, it gives a poor performance in adding, searching, deleting, and updating its elements.
 * The Iterators returned by the Vector class are fail-fast. In the case of concurrent modification, it fails and throws the
 * ConcurrentModificationException.
 *
 * Performing Various Operations on Vector class in Java:
 * Adding elements
 * Updating elements
 * Removing elements
 * Iterating over elements
 */
public class VectorClassExample {
    public static void main(String[] args)
    {

        // Create a new vector
        Vector<Integer> v = new Vector<>(3, 2);

        // Add elements to the vector
        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        System.out.println("Vector after adding 3 elements: " + v);

        // Insert an element at index 1
        v.insertElementAt(0, 1);
        System.out.println("Vector after inserting 0 at index 1: " + v);

        // Remove the element at index 2
        v.removeElementAt(2);
        System.out.println("Vector after removing index 2 element: " + v);

        // Print the elements of the vector
        for (int i = 0; i < v.size(); i++) {
            System.out.println("Vector element at index " + i + ": " + v.get(i));
        }

        v.add(4);
        System.out.println("Vector after adding 4: " + v);
        v.remove(1);
        System.out.println("Vector after removing index 1 element: " + v);
    }
}
