package youtube.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map is an interface that does not extend Collection interface.
 * In Java, a Map is an object that maps keys to values.
 * It cannot contain duplicate keys, and each key can map to at most one value.
 * Think of it as a dictionary where you look up a word(key) to find its definition(value).
 *
 * Map characteristics:
 * - Each entry in a Map consist of a key and value pair.
 * - No two entries can have the same key.
 * - Each key maps to a single value.
 * - Some implementations maintain insertion order (LinkedHashMap), natural/sorted order (TreeMap),
 * or no order (HashMap).
 *
 * Map(interface) -> SortedMap(class) -> NavigableMap(interface) -> TreeMap(class)
 *                -> ConcurrentMap(interface) -> ConcurrentHashMap(class), ConcurrentSkipListMap(class)
 *                -> HashMap(class) -> LinkedHashMap(class), WeakHashMap(class), IdentityHashMap(class)
 *                -> Hashtable(legacy class)
 *
 * Key characteristics:
 * - Unordered: Does not maintain any order of its elements.
 * - Allow null keys and values: Can have one null key and multiple null values.
 * - Not synchronized: Not thread-safe, requires external synchronization if used in multithreaded context.
 * - Performance: Offers constant-time performance i.e. O(1) for basic operations like put and get,
 * assuming the hash function disperses elements properly.
 *
 * Internal structure of HashMap:
 * - There are 4 main components of HashMap, they are
 * i.Key - It is the identifier to get the value.
 * ii.Value - It is the value associated with the key.
 * iii.Bucket - A place where key-value pairs are stored, think of it as cells in a list(array).
 * iv.Hash function - Converts a key into an index(bucket location) for storage.
 *
 * Hash function:
 * - A hash function is an algorithm that takes an input (or key) and returns a fixed-size string of bytes,
 * typically a numerical value.
 * - The output is known as a hash code, hash value, or simply hash.
 * - The primary purpose of a hash function is to map data of arbitrary size to data of fixed size.
 * - It produces the finite output for inputs, multiple inputs can have same output resulting in collision.
 *
 * Key characteristics of Hash function:
 * - Deterministic: The same input will always produce the same output.
 * - Fixed output size: Regardless of the input size, the hashcode has a consistent size(e.g. 32-bit, 64-bit).
 * - Efficient computation: The hash function should compute the hash quickly.
 *
 * How data is stored in HashMap:
 * Step1: Hashing the key
 * - First the key is passed through a hash function to generate a unique hashcode (an integer number).
 * - This hashcode helps determine where the key-value pair will be stored in array (i.e. bucket array).
 * Step2: Calculating the index
 * - The hashcode is then used to calculate an index in the array (bucket location) using
 *      int index = hashCode % arraySize;
 * - This index indicates the position in the array where the key-value pair will be stored.
 * - For example, if array size is 16, the key's hashcode will be divided by 16 and remainder will be the index.
 * Step3: Storing in the Bucket
 * - The key-value pair is stored in the bucket at the calculated index.
 * - Each bucket can hold multiple key-value pairs (this is called collision handling mechanism).
 * - The main bucket array is of type array whereas each index will have data type as LinkedList
 * - E.g: int arr[] = new int[16]; arr[0] = new LinkedList<Key,Value>();
 *
 * How data is retrieved from HashMap:
 * - When we call get(key), the HashMap follows these steps:
 * Step1: Hashing the key
 * - Similar to insertion, the key is hashed using the same hash function to calculate its hash code.
 * Step2: Finding the index
 * - Similar to insertion, the index is retrieved based on hashcode and arraySize(this is usually 16).
 * Step3: Searching in the bucket
 * - Once the correct bucket is found, it checks for the key in that bucket.
 * - If it finds the key, it returns the associated value.
 *
 * Handling collisions:
 * - Since different keys can generate the same index (called a collision), HashMap uses a technique to handle
 * this situation.
 * - Java's HashMap uses LinkedList (or balanced trees after Java 8) for this.
 * - If multiple key-value pairs map to the same bucket, they are stored in a linked list at that index.
 * - When a key-value pair is retrieved, the HashMap traverses the linked list, checking each key until it find a match.
 * - When linked list (treeify) threshold (i.e. size of 8) is crossed, it is converted into balanced binary search tree.
 *
 * HashMap resizing (Rehashing):
 * - HashMap has an internal array size, which by default is 16.
 * - When number of elements (key-value pairs) grows and exceeds a certain load factor (default is 0.75),
 * HashMap automatically resizes the array to hold more data.
 * - This process is called rehashing.
 * - The default size of the array is 16, so when more than 12 elements (16*0.75) are inserted, the hashmap resizes.
 *
 * During rehashing:
 * - The array size of HashMap is doubled the initial size (i.e. for default size it will be 16*2=32).
 * - All existing entries are rehashed (i.e. their positions are recalculated) and placed into new array.
 * - This ensures the HashMap continues to perform efficiently even as more data is added.
 *
 * Time complexity:
 * - HashMap provides constant time O(1) performance for basic operations like put(), get(), remove() assuming no collisions.
 * - However, if there are many collisions, and many entries are stored in same bucket, the performance can
 * degrade to O(n), where n is number of elements in that bucket.
 * - But after Java 8, if there are too many elements in a bucket, HashMap switches to a balanced tree instead of
 * a linked list to ensure better performance O(log n).
 * */
public class HashMapExample {

    public static void main(String[] args) {
        basicMapOperations();
//        mapIterations();
    }

    private static void basicMapOperations() {
        // initial capacity and load factor can also be provided
//        HashMap<Integer,String> map = new HashMap<>(18,0.5f);
        HashMap<Integer,String> map = new HashMap<>();
        map.put(31, "Alex");
        map.put(11, "John");
        map.put(2, "Rachel");
        System.out.println(map); // order is random in HashMap
        System.out.println("Student with roll number 31 is " + map.get(31));
        // when key not found, it returns null
        System.out.println("Student with roll number 55 is " + map.get(55));
        // even though if data type is different for key or value, no error will be thrown, it returns false
        System.out.println("Student with roll number 11 exists? " + map.containsKey(11));
        System.out.println("Student with name Andrea exists? " + map.containsValue("Andrea"));

        // Map can contain a null key and values can be null, however if a new value is assigned to a key then
        // old one gets replaced
        map.put(null,"Hello");
        map.put(null,null);
        map.put(2,"Bye");
        System.out.println(map);

        map.remove(null); // removes entry with key as null if found
        System.out.println(map);
        map.remove(2,"Rachel"); // removes entry with key as 2 and value as 'Rachel' if found
        System.out.println(map);
        map.remove(2,"Bye"); // removes entry with key as 2 and value as 'Bye' if found
        System.out.println(map);
    }

    private static void mapIterations() {
        HashMap<Integer,String> map = new HashMap<>(Map.of(1,"Alex",2,"John",3,"Rachel"));
        // Map can be traversed using keySet() and entrySet() with help of Set
        Set<Integer> keys = map.keySet();
        keys.forEach(key ->System.out.println("Roll number: " + key + ", Name: " + map.get(key)));
        System.out.println();

        Set<Map.Entry<Integer,String>> mapSet = map.entrySet();
        mapSet.forEach(entry ->System.out.println("{Roll number: " + entry.getKey()
                + ", Name: " + entry.getValue() + "}"));
        System.out.println();

        // Map can be traversed using entrySet() and for loop like below
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            entry.setValue(entry.getValue().toUpperCase());
            System.out.println("Roll number: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

}
