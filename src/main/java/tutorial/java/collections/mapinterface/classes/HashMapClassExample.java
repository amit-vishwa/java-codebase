package tutorial.java.collections.mapinterface.classes;

import java.util.HashMap;
import java.util.Map;

/**
 * Refer: https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/?ref=lbp
 *
 * In Java, HashMap is part of the Java Collections Framework and is found in the java.util package. It provides the basic
 * implementation of the Map interface in Java. HashMap stores data in (key, value) pairs. Each key is associated with a value,
 * and you can access the value by using the corresponding key.
 * - Internally uses Hashing (similar to Hashtable in Java).
 * - Not Synchronized (unlike Hashtable in Java) and hence faster for most of the cases.
 * - Allows to store the null keys as well, but there should be only one null key object and there can be any number of null values.
 * - Duplicate Elements not allowed in HashMap, if you try to insert the duplicate key in HashMap, it will replace the element of
 * the corresponding key.
 * - HashMap uses keys in same way as Array uses index.
 * - HashMap allows for efficient key-based retrieval, insertion, and removal with average O(1) time complexity.
 *
 * Note: Keys and value can’t be primitive datatype.  Key in Hashmap is valid if it implements hashCode() and equals() method ,
 * it should also be immutable (immutable custom object ) so that hashcode and equality remains constant. Value in hashmap can be
 * any wrapper class, custom objects, arrays, any reference type or even null .  For example, Hashmap can have array as
 * value but not as key.
 *
 * HashMap in Java implements Serializable, Cloneable, Map<K, V> interfaces.Java HashMap extends AbstractMap<K, V> class. The
 * direct subclasses are LinkedHashMap and PrinterStateReasons.
 *
 * Important Features
 * To access a value one must know its key. HashMap is known as HashMap because it uses a technique called Hashing. Hashing is a
 * technique of converting a large String to a small String that represents the same String. A shorter value helps in indexing
 * and faster searches. HashSet also uses HashMap internally.
 *
 * A few important features of HashMap are:
 * - HashMap is a part of java.util package.
 * - HashMap extends an abstract class AbstractMap which also provides an incomplete implementation of the Map interface.
 * - It also implements a Cloneable and Serializable interfaces. K and V in the above definition represent Key and Value respectively.
 * - HashMap doesn’t allow duplicate keys but allows duplicate values. That means A single key can’t contain more than 1 value
 * but more than 1 key can contain a single value.
 * - HashMap allows a null key also but only once and multiple null values.
 * - This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will
 * remain constant over time. It is roughly similar to HashTable but is unsynchronized.
 *
 * Time and Space Complexity
 * HashMap provides constant time complexity for basic operations, get and put if the hash function is properly written and it
 * disperses the elements properly among the buckets. Iteration over HashMap depends on the capacity of HashMap and the number
 * of key-value pairs. Basically, it is directly proportional to the capacity + size. Capacity is the number of buckets in
 * HashMap. So it is not a good idea to keep a high number of buckets in HashMap initially.
 * */
public class HashMapClassExample {

    public static void main(String args[])
    {
        // No need to mention the
        // Generic type twice
        HashMap<Integer, String> hm1 = new HashMap<>();

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