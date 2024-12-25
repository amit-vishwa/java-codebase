package tutorial.dsa.algorithms.hashing.open;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Refer: https://www.geeksforgeeks.org/c-program-hashing-chaining/
 *
 * Chaining with Rehashing
 * Let’s discuss another method where we have no boundation on number of buckets. Number of buckets will increase
 * when value of load factor is greater than 0.5.
 *
 * We will do rehashing when the value of load factor is greater than 0.5. In rehashing, we double the size of
 * array and add all the values again to new array (doubled size array is new array) based on hash function.
 * Hash function should also be change as it is depends on number of buckets. Therefore, hash function behaves
 * differently from the previous one.
 *
 * Complexity analysis of Insert:
 * Time Complexity: O(N), It takes O(N) time complexity because we are checking the load factor each time and when it is greater than 0.5 we call rehashing function which takes O(N) time.
 * Space Complexity: O(N), It takes O(N) space complexity because we are creating a new array of doubled size and copying all the elements to the new array.
 *
 * Complexity analysis of Search:
 * Time Complexity: O(N),  It takes O(N) time complexity because we are searching in a list of size N.
 * Space Complexity: O(1),  It takes O(1) space complexity because we are not using any extra space for searching.
 * */
public class Rehashing {
    int BUCKET; // Number of buckets
    int numOfElements; // To track the number of elements

    // ArrayList of LinkedLists to store chains
    ArrayList<LinkedList<Integer>> table;

    // Constructor to initialize bucket count and table
    public Rehashing(int b) {
        this.BUCKET = b;
        this.numOfElements = 0;
        table = new ArrayList<>(BUCKET);

        // Initialize each bucket with an empty LinkedList
        for (int i = 0; i < BUCKET; i++) {
            table.add(new LinkedList<>());
        }
    }

    // Hash function to map values to key
    private int hashFunction(int x) {
        return (x % BUCKET);
    }

    // Function to calculate the current load factor
    private float getLoadFactor() {
        return (float) numOfElements / BUCKET;
    }

    // Rehashing function to double the capacity and re-insert elements
    private void rehashing() {
        int oldBucket = BUCKET;
        BUCKET = 2 * BUCKET; // Double the number of buckets
        ArrayList<LinkedList<Integer>> oldTable = table; // Store current table

        table = new ArrayList<>(BUCKET);
        numOfElements = 0; // Reset the element count

        // Initialize the new bucket with empty LinkedLists
        for (int i = 0; i < BUCKET; i++) {
            table.add(new LinkedList<>());
        }

        // Re-insert old values into the new table
        for (int i = 0; i < oldBucket; i++) {
            for (int key : oldTable.get(i)) {
                insertItem(key); // Insert keys into the new table
            }
        }
    }

    // Inserts a key into the hash table
    public void insertItem(int key) {
        // If load factor exceeds 0.5, rehash
        while (getLoadFactor() > 0.5) {
            rehashing();
        }

        int index = hashFunction(key);
        table.get(index).add(key); // Insert the key into the bucket
        numOfElements++;
    }

    // Deletes a key from the hash table
    public void deleteItem(int key) {
        int index = hashFunction(key);

        // Find and remove the key from the table[index] LinkedList
        LinkedList<Integer> chain = table.get(index);
        if (chain.contains(key)) {
            chain.remove((Integer) key); // Remove the key
            numOfElements--;
        }
    }

    // Display the hash table
    public void displayHash() {
        for (int i = 0; i < BUCKET; i++) {
            System.out.print(i);
            for (int x : table.get(i)) {
                System.out.print(" --> " + x);
            }
            System.out.println();
        }
    }

    // Driver program
    public static void main(String[] args) {
        // ArrayList that contains keys to be mapped
        ArrayList<Integer> a = new ArrayList<>();
        a.add(15);
        a.add(11);
        a.add(27);
        a.add(8);
        a.add(12);

        // Insert the keys into the hash table
        Rehashing h = new Rehashing(7); // 7 is the number of buckets in the hash table
        for (int key : a) {
            h.insertItem(key);
        }

        // Delete 12 from the hash table
        h.deleteItem(12);

        // Display the hash table
        h.displayHash();

        // Insert more items to trigger rehashing
        h.insertItem(33);
        h.insertItem(45);
        h.insertItem(19);

        // Display the hash table after rehashing
        System.out.println("\nAfter rehashing:");
        h.displayHash();
    }
}