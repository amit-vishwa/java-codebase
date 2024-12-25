package tutorial.dsa.algorithms.hashing.open;

import java.util.ArrayList;

/**
 * Refer: https://www.geeksforgeeks.org/c-program-hashing-chaining/
 *
 * Program for hashing with chaining
 * Last Updated : 15 Sep, 2024
 * In hashing there is a hash function that maps keys to some values. But these hashing functions may lead to a
 * collision that is two or more keys are mapped to same value. Chain hashing avoids collision. The idea is to make
 * each cell of hash table point to a linked list of records that have same hash function value.
 * Let’s create a hash function, such that our hash table has ‘N’ number of buckets.
 *
 * To insert a node into the hash table, we need to find the hash index for the given key. And it could be calculated
 * using the hash function.
 *
 * Example: hashIndex = key % noOfBuckets
 * - Insert: Move to the bucket corresponding to the above-calculated hash index and insert the new node at the end
 * of the list.
 * - Delete: To delete a node from hash table, calculate the hash index for the key, move to the bucket corresponding
 * to the calculated hash index, and search the list in the current bucket to find and remove the node with the
 * given key (if found).
 * */
// This method has not concept of rehashing. It only has a fixed size array i.e. fixed numbers of buckets.
public class SimpleChaining {
    // Number of buckets
    private final int bucket;
    // Hash table of size bucket
    private final ArrayList<Integer>[] table;

    public SimpleChaining(int bucket)
    {
        this.bucket = bucket;
        this.table = new ArrayList[bucket];
        for (int i = 0; i < bucket; i++) {
            table[i] = new ArrayList<>();
        }
    }

    // hash function to map values to key
    public int hashFunction(int key)
    {
        return (key % bucket);
    }

    public void insertItem(int key)
    {
        // get the hash index of key
        int index = hashFunction(key);
        // insert key into hash table at that index
        table[index].add(key);
    }

    public void deleteItem(int key)
    {
        // get the hash index of key
        int index = hashFunction(key);

        // Check if key is in hash table
        if (!table[index].contains(key)) {
            return;
        }

        // delete the key from hash table
        table[index].remove(Integer.valueOf(key));
    }

    // function to display hash table
    public void displayHash()
    {
        for (int i = 0; i < bucket; i++) {
            System.out.print(i);
            for (int x : table[i]) {
                System.out.print(" --> " + x);
            }
            System.out.println();
        }
    }

    // Drive Program
    public static void main(String[] args)
    {
        // array that contains keys to be mapped
        int[] a = { 15, 11, 27, 8, 12 };

        // Create empty arrays of ArrayList of BUCKET_SIZE
        SimpleChaining h = new SimpleChaining(7);

        // insert the keys into the hash table
        for (int x : a) {
            h.insertItem(x);
        }

        // delete 12 from the hash table
        h.deleteItem(12);

        // Display the hash table
        h.displayHash();
    }
}
/**
 * Time Complexity:
 *
 * Search : O(1+(n/m))
 * Delete : O(1+(n/m))
 * where n =  Total elements in hash table
 *              m = Size of hash table
 * Here n/m is the Load Factor.
 * Load Factor (∝) must be as small as possible.
 * If load factor increases,then possibility of collision increases.
 * Load factor is trade of space and time .
 * Assume , uniform distribution of keys ,
 * Expected chain length : O(∝)
 * Expected time to search : O( 1 + ∝ )
 * Expected time to insert/ delete :  O( 1 + ∝ )
 * Auxiliary Space: O(1), since no extra space has been taken.
 * */