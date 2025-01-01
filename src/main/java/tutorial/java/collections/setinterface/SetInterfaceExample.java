package tutorial.java.collections.setinterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Refer: https://www.geeksforgeeks.org/set-in-java/?ref=lbp
 *
 * The Set Interface is present in java.util package and extends the Collection interface. It is an unordered collection of
 * objects in which duplicate values cannot be stored. It is an interface that implements the mathematical set. This interface
 * adds a feature that restricts the insertion of the duplicate elements.
 *
 * - No Specific Order: Does not maintain any specific order of elements (Exceptions: LinkedHashSet and TreeSet).
 * - Allows One Null Element: Most Set implementations allow a single null element.
 * - Implementation Classes: HashSet , LinkedHashSet and TreeSet.
 * - Thread-Safe Alternatives: For thread-safe operations, use ConcurrentSkipListSet or wrap a set using
 * Collections.synchronizedSet().
 * There are two interfaces that extend the set implementation namely SortedSet and NavigableSet.
 *
 * Operations on the Set Interface
 * The set interface allows the users to perform the basic mathematical operation on the set. Let’s take two arrays to understand these basic operations. Let set1 = [1, 3, 2, 4, 8, 9, 0] and set2 = [1, 3, 7, 5, 4, 0, 7, 5]. Then the possible operations on the sets are:
 * 1. Intersection: This operation returns all the common elements from the given two sets. For the above two sets, the intersection would be:
 * Intersection = [0, 1, 3, 4]
 * 2. Union: This operation adds all the elements in one set with the other. For the above two sets, the union would be:
 * Union = [0, 1, 2, 3, 4, 5, 7, 8, 9]
 * 3. Difference: This operation removes all the values present in one set from the other set. For the above two sets, the difference would be:
 * Difference = [2, 8, 9]
 *
 * Performing Various Operations on SortedSet
 * After the introduction of Generics in Java 1.5, it is possible to restrict the type of object that can be stored in the Set. Since Set is an interface, it can be used only with a class that implements this interface. HashSet is one of the widely used classes which implements the Set interface. Now, let’s see how to perform a few frequently used operations on the HashSet. We are going to perform the following operations as follows:
 *
 * Adding elements
 * Accessing elements
 * Removing elements
 * Iterating elements
 * Iterating through Set
 * */
public class SetInterfaceExample {

    // Main driver method
    public static void main(String args[])
    {
        System.out.println("Set operations: ");
        setOperations();
        System.out.println("\nMathematical Set operations: ");
        mathematicalSetOperations();
    }

    private static void setOperations() {
        Set<String> hs = new HashSet<String>();

        // Operations 1: Adding Elements
        hs.add("B");
        hs.add("B");
        hs.add("C");
        hs.add("A");
        // Printing the elements inside the Set object
        System.out.println(hs);

        // Operation 2: Accessing the Elements
        // Declaring a string
        String check = "D";
        // Check if the above string exists in
        // the SortedSet or not
        // using contains() method
        System.out.println("Contains " + check + " "
                + hs.contains(check));

        // Operation 3: Removing the Values
        // Removing custom element
        // using remove() method
        hs.remove("B");
        // Printing Set elements after removing an element
        // and printing updated Set elements
        System.out.println("After removing element " + hs);

        // Operation 4: Iterating through the Set
        // Iterating through the Set
        // via for-each loop
        for (String value : hs)
            // Printing all the values inside the object
            System.out.print(value + ", ");
        System.out.println();
    }

    static void mathematicalSetOperations(){
        // Creating an object of Set class
        // Declaring object of Integer type
        Set<Integer> a = new HashSet<Integer>();

        // Adding all elements to List
        a.addAll(Arrays.asList(
                new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));

        // Again declaring object of Set class
        // with reference to HashSet
        Set<Integer> b = new HashSet<Integer>();

        b.addAll(Arrays.asList(
                new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));
        System.out.println("Set1: "+a);
        System.out.println("Set2: "+b);


        // To find union
        Set<Integer> union = new HashSet<Integer>(a);
        union.addAll(b);
        System.out.print("Union of the two Set: ");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set: ");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<Integer>(a);
        difference.removeAll(b);
        System.out.print("Difference of the elements of set two from set one: ");
        System.out.println(difference);        
    }
}
