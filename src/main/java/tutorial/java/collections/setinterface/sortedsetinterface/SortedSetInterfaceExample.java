package tutorial.java.collections.setinterface.sortedsetinterface;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Refer: https://www.geeksforgeeks.org/sortedset-java-examples/?ref=lbp
 *
 * SortedSet Interface in Java with Examples
 * The SortedSet interface is present in java.util package extends the Set interface present in the collection framework. It is
 * an interface that implements the mathematical set. This interface contains the methods inherited from the Set interface and
 * adds a feature that stores all the elements in this interface to be stored in a sorted manner.
 * - Automatic Sorting: Elements are stored in ascending order by default. Allows a custom order using a Comparator.
 * - Unique Elements: Ensures that no duplicate elements are present, consistent with the Set interface.
 * - Null Handling: Typically, null elements are not allowed, especially if natural ordering or a custom comparator is used.
 *
 * The navigable set extends the sorted set interface. Since a set doesn’t retain the insertion order, the
 * navigable set interface provides the implementation to navigate through the Set. The class which implements the navigable set
 * is a TreeSet which is an implementation of a self-balancing tree. Therefore, this interface provides us with a way to navigate
 * through this tree.
 *
 * Note: All the elements of a SortedSet must implement the Comparable interface (or be accepted by the specified Comparator)
 * and all such elements must be mutually comparable. Mutually Comparable simply means that two objects accept each other as the
 * argument to their compareTo method.
 * */
public class SortedSetInterfaceExample {

    public static void main(String[] args)
    {
        SortedSet<String> ts = new TreeSet<String>();

        // 1. Adding Elements:
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("A");
        // Adding the duplicate
        // element
        ts.add("C");
        // Displaying the TreeSet
        System.out.println(ts);

        // 2. Accessing the Elements:
        String check = "D";
        // Check if the above string exists in
        // the SortedSet or not
        System.out.println("Contains " + check + " "
                + ts.contains(check));
        // Print the first element in
        // the SortedSet
        System.out.println("First Value " + ts.first());
        // Print the last element in
        // the SortedSet
        System.out.println("Last Value " + ts.last());

        // 3. Removing the Values:
        ts.remove("B");
        System.out.println("Set after removing B:" + ts);

        // 4. Iterating through the SortedSet:
        System.out.println("Iterating over set:");
        Iterator<String> i = ts.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}