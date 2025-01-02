package tutorial.java.collections.mapinterface.classes;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Refer: https://www.geeksforgeeks.org/java-util-dictionary-class-java/
 *
 * Dictionary class in Java is an abstract class that represents a collection of key-value pairs, where keys are unique and
 * used to access the values. It was part of the Java Collections Framework and it was introduced in Java 1.0 but has been
 * largely replaced by the Map interface since Java 1.2.
 * - Stores key-value pairs, where keys are unique.
 * - Provides basic operations like insert, retrieve, and remove key-value pairs.
 * - Keys and values are stored as Object.
 * - Limited functionality compared to Map implementations.
 * */
public class DictionaryAbstractClassExample {
    public static void main(String[] args) {

        // Create a Dictionary instance
        // using Hashtable
        Dictionary<String, String> d = new Hashtable<>();

        // Add key-value pairs
        d.put("Java", "1");
        d.put("Python", "2");

        print(d);

        // Retrieve a value using its key
        String v = d.get("Java");
        System.out.println("\nValue for key 'Java': " + v);

        // Check the number of key-value pairs
        System.out.println("Size of dictionary: " + d.size());

        // Check if the dictionary is empty
        System.out.println("Is dictionary empty? " + d.isEmpty());

        // Remove a key-value pair for given key
        System.out.println("\nRemoving key 'Python'...");
        d.remove("Python");
        print(d);

        // Retrieve all keys
        Enumeration<String> keys = d.keys();
        while (keys.hasMoreElements()) {
            String k = keys.nextElement();
            System.out.println("Key: " + k);
        }

        // Retrieve all values
        Enumeration<String> values = d.elements();
        while (values.hasMoreElements()) {
            v = values.nextElement();
            System.out.println("Value: " + v);
        }
    }

    // Utility method to print all
    // key-value pairs in the dictionary
    private static void print(Dictionary<String, String> d) {
        Enumeration<String> keys = d.keys();
        while (keys.hasMoreElements()) {
            String k = keys.nextElement();
            String v = d.get(k);
            System.out.println("Key: " + k + ", Value: " + v);
        }
    }
}