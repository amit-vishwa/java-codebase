package tutorial.java.collections.mapinterface.classes;

import java.util.Hashtable;
import java.util.Map;

/**
 * Refer: https://www.geeksforgeeks.org/hashtable-in-java/?ref=lbp
 *
 * Hashtable class, introduced as part of the Java Collections framework, implements a hash table that maps keys to values.
 * Any non-null object can be used as a key or as a value. To successfully store and retrieve objects from a hashtable,
 * the objects used as keys must implement the hashCode method and the equals method. The java.util.Hashtable class is a class
 * in Java that provides a key-value data structure, similar to the Map interface.
 * - It is similar to HashMap, but is synchronized.
 * - Hashtable stores key/value pair in hash table.
 * - In Hashtable we specify an object that is used as a key, and the value we want to associate to that key. The key is then
 * hashed, and the resulting hash code is used as the index at which the value is stored within the table.
 * - The initial default capacity of Hashtable class is 11 whereas loadFactor is 0.75.
 * - HashMap doesn’t provide any Enumeration, while Hashtable provides not fail-fast Enumeration.
 *
 * Note: While the Hashtable class still exists in Java and can still be used, it’s generally recommended to use the Map
 * interface or one of its implementations instead.
 * */
public class HashTableClassExample {

    public static void main(String args[])
    {
        // No need to mention the
        // Generic type twice
        Hashtable<Integer, String> ht1 = new Hashtable<>();

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2
                = new Hashtable<Integer, String>();

        // Inserting the Elements
        ht1.put(1, "Geeks");
        ht1.put(2, "Gor");
        ht1.put(3, "Geeks");

        ht2.put(1, "Geeks");
        ht2.put(2, "For");
        ht2.put(3, "Geeks");

        // Print mappings to the console
        System.out.println("Mappings of ht1 : " + ht1);
        System.out.println("Mappings of ht2 : " + ht2);

        // Update the value at key 2
        ht1.put(2, "For");

        // print the updated map
        System.out.println("Updated Map " + ht1);

        // Remove the map entry with key 4
        ht1.remove(3);

        // Final Hashtable
        System.out.println("Updated map : " + ht1);

        // Iterating using enhanced for loop
        for (Map.Entry<Integer, String> e : ht2.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }
}
