package tutorial.java.collections.setinterface.sortedsetinterface.classes;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Refer: https://www.geeksforgeeks.org/treeset-in-java-with-examples/?ref=lbp
 *
 * TreeSet is one of the most important implementations of the SortedSet interface in Java that uses a Tree(red – black tree) for
 * storage. The ordering of the elements is maintained by a set using their natural ordering whether or not an explicit
 * comparator is provided. This must be consistent with equals if it is to correctly implement the Set interface.
 * - TreeSet does not allow duplicate elements. Any attempt to add a duplicate element will be ignored.
 * - It doesn’t allow null values and throws NullPointerException null element is inserted in it.
 * - TreeSet implements the NavigableSet interface and provides additional methods to navigate the set (e.g., higher(), lower(),
 * ceiling(), and floor()).
 * - It is not thread safe. For concurrent access, it should be synchronized externally using Collections.synchronizedSet().
 *
 * It can also be ordered by a Comparator provided at set creation time, depending on which constructor is used. The TreeSet
 * implements a NavigableSet interface by inheriting AbstractSet class.
 *
 * Various Operations over TreeSet in Java
 * Here we will be performing various operations over the TreeSet object to get familiar with the methods and concepts of TreeSet in java. Let’s see how to perform a few frequently used operations on the TreeSet. They are listed as follows:
 * - Adding elements
 * - Accessing elements
 * - Removing elements
 * - Iterating through elements
 *
 * Features of a TreeSet
 * - TreeSet implements the SortedSet interface. So, duplicate values are not allowed.
 * - Objects in a TreeSet are stored in a sorted and ascending order.
 * - TreeSet does not preserve the insertion order of elements but elements are sorted by keys.
 * - If we are depending on the default natural sorting order, the objects that are being inserted into the tree should be homogeneous and comparable. TreeSet does not allow the insertion of heterogeneous objects. It will throw a classCastException at Runtime if we try to add heterogeneous objects.
 * - The TreeSet can only accept generic types which are comparable.
 * - For example, the StringBuffer class implements the Comparable interface.
 * */
public class TreeSetClassExample {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating a Set interface with
        // reference to TreeSet class
        // Declaring object of string type
        NavigableSet<String> ts = new TreeSet<>();

        // Operation 1: Adding Elements
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        // Print all elements inside object
        System.out.println(ts);

        // Operation 2: Accessing the Elements
        String check = "Geeks";
        // Check if the above string exists in
        // the treeset or not
        System.out.println("Contains " + check + " "
                + ts.contains(check));
        // Print the first element in
        // the TreeSet
        System.out.println("First Value " + ts.first());
        // Print the last element in
        // the TreeSet
        System.out.println("Last Value " + ts.last());
        String val = "Geek";
        // Find the values just greater
        // and smaller than the above string
        System.out.println("Higher " + ts.higher(val));
        System.out.println("Lower " + ts.lower(val));

        // Operation 3: Removing the Values
        // Removing a specific existing element inserted
        // above
        ts.remove("B");
        // Printing the updated TreeSet
        System.out.println("After removing element " + ts);
        // Now removing the first element
        // using pollFirst() method
        ts.pollFirst();
        // Again printing the updated TreeSet
        System.out.println("After removing first " + ts);
        // Removing the last element
        // using pollLast() method
        ts.pollLast();
        // Lastly printing the elements of TreeSet remaining
        // to figure out pollLast() method
        System.out.println("After removing last " + ts);

        // Operation 4: Iterating through the TreeSet
        // Now we will be using for each loop in order
        // to iterate through the TreeSet
        for (String value : ts)
            // Printing the values inside the object
            System.out.print(value + ", ");
        System.out.println();

        // Java code to illustrate What if Heterogeneous Objects are Inserted
        Set<StringBuffer> t = new TreeSet<>();
        // Adding elements to above object
        // using add() method
        t.add(new StringBuffer("A"));
        t.add(new StringBuffer("Z"));
        t.add(new StringBuffer("L"));
        t.add(new StringBuffer("B"));
        t.add(new StringBuffer("O"));
        t.add(new StringBuffer(1));
        // Note: StringBuffer implements Comparable
        // interface
        // Printing the elements
        System.out.println(t);
    }
}