package tutorial.java.collections.setinterface.classes;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Refer: https://www.geeksforgeeks.org/linkedhashset-in-java-with-examples/?ref=lbp
 *
 * LinkedHashSet in Java implements the Set interface of the Collection Framework. It combines the functionality of a HashSet
 * with a LinkedList to maintain the insertion order of elements.
 * - Stores unique elements only.
 * - Maintains insertion order.
 * - Provides faster iteration compared to HashSet.
 * - Allows null elements.
 *
 * The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements. When the iteration
 * order is needed to be maintained this class is used. When iterating through a HashSet the order is unpredictable, while a
 * LinkedHashSet lets us iterate through the elements in the order in which they were inserted. When cycling through LinkedHashSet
 * using an iterator, the elements will be returned in the order in which they were inserted.
 * */
public class LinkedHashSetClassExample {

    public static void main(String[] args) {

        // Creating an empty LinkedHashSet
        LinkedHashSet<String> lh = new LinkedHashSet<String>();

        // 1. Adding Elements in LinkedHashSet
        lh.add("Geek");
        lh.add("For");
        lh.add("Geeks");
        lh.add("A");
        lh.add("B");
        lh.add("Z");
        System.out.println("LinkedHashSet : " + lh);

        // 2. Removing Elements in LinkedHashSet
        // Removing the element from above Set
        lh.remove("B");
        // Again removing the element
        System.out.println("After removing element " + lh);
        // Returning false if the element is not present
        System.out.println(lh.remove("A"));

        // 3. Iterating through the LinkedHashSet
        // Iterating though the LinkedHashSet
        // using iterators
        Iterator itr = lh.iterator();
        while (itr.hasNext())
            System.out.print(itr.next() + ", ");
        System.out.println();
        // Using enhanced for loop for iteration
        for (String s : lh)
            System.out.print(s + ", ");
        System.out.println();

    }

}
