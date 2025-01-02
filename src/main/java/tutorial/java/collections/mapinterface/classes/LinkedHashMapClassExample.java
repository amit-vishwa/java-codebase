package tutorial.java.collections.mapinterface.classes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Refer: https://www.geeksforgeeks.org/linkedhashmap-class-in-java/?ref=lbp
 *
 * LinkedHashMap in Java implements the Map interface of the Collections Framework. It stores key-value pairs while maintaining
 * the insertion order of the entries. It maintains the order in which elements are added.
 * - Stores unique key-value pairs.
 * - Maintains insertion order.
 * - Allows one null key and multiple null values.
 * - Fast performance for basic operations.
 *
 * Application: Since the LinkedHashMap makes use of Doubly LinkedList to maintain the insertion order, we can implement LRU
 * Cache functionality by overriding the removeEldestEntry() method to impose a policy for automatically removing stale when
 * new mappings are added to the map. This lets you expire data using some criteria that you define.
 * */
public class LinkedHashMapClassExample {

    public static void main(String args[])
    {
        // No need to mention the
        // Generic type twice
        LinkedHashMap<Integer, String> hm1 = new LinkedHashMap<>();

        // Initialization of a HashMap
        // using Generics
        HashMap<Integer, String> hm2
                = new HashMap<Integer, String>();

        /**
         * 1. Adding Elements in HashMap in Java
         * Time: O(1)
         * Space: O(N)
         * */
        // Add Elements using put method
        hm1.put(1, "Geeks");
        hm1.put(2, "Gor");
        hm1.put(3, "Geeks");

        hm2.put(1, "Geeks");
        hm2.put(2, "For");
        hm2.put(3, "Geeks");

        System.out.println("Mappings of HashMap hm1 are : "
                + hm1);
        System.out.println("Mapping of HashMap hm2 are : "
                + hm2);

        /**
         * 2. Changing Elements in HashMap in Java
         * Time: O(1)
         * Space: O(N)
         * */
        hm1.put(2, "For");
        System.out.println("Updated Map " + hm1);

        /**
         * 3. Removing Element from Java HashMap
         * Time: O(1)
         * Space: O(N)
         * */
        // remove element with a key
        // using remove method
        hm2.remove(1);
        // Final HashMap
        System.out.println("Mappings after removal are : "
                + hm2);

        /**
         * 4. Search in Java HashMap
         * Time: O(1)
         * Space: O(1)
         * */
        System.out.println("Mappings after removal are : "
                + hm2.get(2));

        /**
         * 5. Traversal of Java HashMap
         * Time: O(N)
         * Space: O(N)
         * */
        // Iterate the map using
        // for-each loop
        for (Map.Entry<Integer, String> e : hm1.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());

    }

}
