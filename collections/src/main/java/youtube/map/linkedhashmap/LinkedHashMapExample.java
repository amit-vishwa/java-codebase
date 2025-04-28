package youtube.map.linkedhashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * LinkedHashMap uses doubly linked list to maintain insertion order.
 * Due to the overhead, it is slower than the HashMap and occupies more memory.
 * Similar to HashMap, the initialCapacity and loadFactor can be provided here.
 * However, we can also provide one more argument to set the accessOrder or elements.
 * The element that is least used will be stored at top when accessOrder is true.
 * Caching is one of the example where accessOrder can be set to true.
 *
 * Similar to HashMap, LinkedHashMap is also not thread-safe.
 * */
public class LinkedHashMapExample {

    public static void main(String[] args) {
        simpleOperations();
//        createOperations();
    }

    private static void simpleOperations() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Orange",10);
        hashMap.put("Apple",20);
        hashMap.put("Guava",13);
        hashMap.put("Mango",15);
        System.out.println("HashMap: " + hashMap); // displays randomly as order is not maintained

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Orange",10);
        linkedHashMap.put("Apple",20);
        linkedHashMap.put("Guava",13);
        linkedHashMap.put("Mango",15);
        System.out.println("LinkedHashMap: " + linkedHashMap); // displays in order as it is maintained

        linkedHashMap.put("Orange", 15); // overrides the value of Orange
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println("Banana: " + linkedHashMap.get("Banana"));
        linkedHashMap.putIfAbsent("Orange", 25); // if Orange is not present then only it performs this
        linkedHashMap.putIfAbsent("Banana", 25); // if Banana is not present then only it performs this
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println("Banana: " + linkedHashMap.get("Banana"));
        // If Papaya not found in LinkedHashMap then it gets default value of 10
        System.out.println("Papaya: " + linkedHashMap.getOrDefault("Papaya",10));
    }

    private static void createOperations() {
        // Size of list is 10 and it will be doubled after reaching 50% occupancy
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(10,0.5f,true);
        linkedHashMap.put("Orange",10);
        linkedHashMap.put("Apple",20);
        linkedHashMap.put("Guava",13);
        linkedHashMap.put("Mango",15);
        System.out.println("LinkedHashMap: " + linkedHashMap); // displays in order as it is maintained
        linkedHashMap.get("Orange"); // since accessOrder is true this element will be displayed at last
        System.out.println("LinkedHashMap: " + linkedHashMap); // displays in order excluding accessed elements
        linkedHashMap.get("Mango");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Guava");
        // setting accessOrder to true is also beneficial in cases where the least used element is hard to find
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }

}
