package tutorial.dsa.algorithms.hashing;

import java.util.*;

/**
 * Refer: https://www.geeksforgeeks.org/designing-a-hashmap-without-built-in-libraries/
 *
 * Design a HashMap without using any built-in hash table libraries. To be specific, your design should include
 * these functions:
 * i.put(key, value): Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * ii.get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * iii.remove(key): Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Time Complexity: O(1)
 * Auxiliary Space: O(1)
 * */
public class CustomHashMap {
    // Drivers code
    public static void main(String args[])
    {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }
}

// Java program to design HashMap
class MyHashMap {
    int[] mapArray;
    public MyHashMap()
    {
        mapArray = new int[1000001];
        Arrays.fill(mapArray, -1);
    }

    public void put(int key, int value)
    {
        mapArray[key] = value;
    }

    public int get(int key) { return mapArray[key]; }

    public void remove(int key) { mapArray[key] = -1; }

}
