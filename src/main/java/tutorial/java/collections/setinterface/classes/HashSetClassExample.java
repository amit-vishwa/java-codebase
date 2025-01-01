package tutorial.java.collections.setinterface.classes;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Refer: https://www.geeksforgeeks.org/hashset-in-java/?ref=lbp
 *
 * Java HashSet
 * HashSet in Java implements the Set interface of Collections Framework. It is used to store the unique elements and it
 * doesn’t maintain any specific order of elements.
 * - Can store the Null values.
 * - Uses HashMap (implementation of hash table data structure) internally.
 * - Also implements Serializable and Cloneable interfaces.
 * - HashSet is not thread-safe. So to make it thread-safe, synchronization needed externally.
 *
 * Internal Working of a HashSet
 * All the classes of the Set interface are internally backed up by Map. HashSet uses HashMap for storing its object internally.
 * You must be wondering that to enter a value in HashMap we need a key-value pair, but in HashSet, we are passing only one value.
 * Storage in HashMap: Actually the value we insert in HashSet acts as a key to the map Object and for its value, java uses a
 * constant variable. So in the key-value pair, all the values will be the same.
 * */
public class HashSetClassExample {

    public static void main(String[] args)
    {
        // Creating an empty HashSet of string entities
        HashSet<String> hs = new HashSet<String>();

        // 1.Adding Elements in HashSet
        hs.add("Geek");
        hs.add("For");
        hs.add("Geeks");
        hs.add("A");
        hs.add("B");
        hs.add("Z");
        // Printing all string entries inside the Set
        System.out.println("HashSet : " + hs);

        // 2. Removing Elements in HashSet
        // Removing the element B
        hs.remove("B");
        // Printing the updated HashSet elements
        System.out.println("HashSet after removing element : " + hs);
        // Returns false if the element is not present
        System.out.println("B exists in Set : " + hs.remove("B"));

        // 3. Iterating through the HashSet
        System.out.print("Using iterator : ");
        Iterator<String> iterator = hs.iterator();
        // Traversing HashSet
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
        System.out.println();
        // Using enhanced for loop to iterate
        // Over the HashSet
        System.out.print("Using enhanced for loop : ");
        for (String element : hs)
            System.out.print(element + " , ");
    }
}
