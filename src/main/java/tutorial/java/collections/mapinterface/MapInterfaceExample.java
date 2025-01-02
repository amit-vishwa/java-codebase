package tutorial.java.collections.mapinterface;

import java.util.*;

/**
 * Refer: https://www.geeksforgeeks.org/map-interface-java-examples/?ref=lbp
 *
 * In Java, Map Interface is present in the java.util package represents a mapping between a key and a value. Java Map interface
 * is not a subtype of the Collection interface. Therefore it behaves a bit differently from the rest of the collection types.
 *
 * - No Duplicates in Keys: Ensures that keys are unique. However, values can be duplicated.
 * - Null Handling: Allows one null key in implementations like HashMap and LinkedHashMap and allows multiple null values in most
 * implementations.
 * - Thread-Safe Alternatives: Use ConcurrentHashMap for thread-safe operations also, wrap an existing Map using
 * Collections.synchronizedMap() for synchronized access.
 *
 * The Map data structure is represented by the Map Interface and the SortedMap Interface. Three key classes that implement the
 * Map interface are HashMap, TreeMap, and LinkedHashMap.
 *
 * Characteristics of a Map Interface
 * A Map cannot contain duplicate keys and each key can map to at most one value. Some implementations allow null key and null
 * values like the HashMap and LinkedHashMap, but some do not like the TreeMap.
 * The order of a map depends on the specific implementations. For example, TreeMap and LinkedHashMap have predictable orders,
 * while HashMap does not.
 * There are two interfaces for implementing Map in Java. They are Map and SortedMap, and three classes: HashMap, TreeMap, and
 * LinkedHashMap.
 * */
public class MapInterfaceExample {

    public static void main(String args[])
    {
        // Default Initialization of a
        // Map
        Map<Integer, String> hm1 = new HashMap<>();

        // Initialization of a Map
        // using Generics
        Map<Integer, String> hm2
                = new HashMap<Integer, String>();

        // 1. Adding Elements
        hm1.put(1, "Geeks");
        hm1.put(2, "Gor");
        hm1.put(3, "Geeks");
        hm2.put(1, "Geeks");
        hm2.put(2, "For");
        hm2.put(3, "Geeks");
        System.out.println(hm1);
        System.out.println(hm2);

        // 2. Changing Element
        hm1.put(2, "For");
        System.out.println("Updated Map " + hm1);

        // 3. Removing Elements
        hm1.remove(2);
        hm1.remove(5);
        // Final Map
        System.out.println(hm1);

        // 4. Iterating through the Map
        for (Map.Entry<Integer, String> mapElement : hm2.entrySet()) {
            int key = mapElement.getKey();
            // Finding the value
            String value = mapElement.getValue();
            System.out.println(key + " : " + value);
        }

        // 5. Count the Occurrence of numbers using Hashmap
        int a[] = { 1, 13, 4, 1, 41, 31, 31, 4, 13, 2 };
        // put all elements in arraylist
        ArrayList<Integer> aa = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            aa.add(a[i]);
        }
        System.out.println("List: " + aa);
//        Map<Integer, Integer> h = new TreeMap<>(); // sort keys in ascending
//        Map<Integer, Integer> h = new HashMap<>(); // random order
        Map<Integer, Integer> h = new LinkedHashMap<>(); // maintains order
        // counting occurrence of numbers
        for (int i = 0; i < aa.size(); i++) {
            h.putIfAbsent(aa.get(i), Collections.frequency(
                    aa, aa.get(i)));
        }
        System.out.println(h);
    }

}