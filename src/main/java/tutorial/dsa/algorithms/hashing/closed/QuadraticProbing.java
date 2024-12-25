package tutorial.dsa.algorithms.hashing.closed;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/quadratic-probing-in-hashing/
 *
 * Quadratic Probing:
 * Quadratic probing is an open-addressing scheme where we look for the i2‘th slot in the i’th iteration
 * if the given hash value x collides in the hash table.
 *
 * How Quadratic Probing is done?
 * Let hash(x) be the slot index computed using the hash function.
 * If the slot hash(x) % S is full, then we try (hash(x) + 1*1) % S.
 * If (hash(x) + 1*1) % S is also full, then we try (hash(x) + 2*2) % S.
 * If (hash(x) + 2*2) % S is also full, then we try (hash(x) + 3*3) % S.
 * This process is repeated for all the values of i until an empty slot is found.
 *
 * Time Complexity: O(N * L), where N is the length of the array and L is the size of the hash table.
 * Auxiliary Space: O(1)
 * */
public class QuadraticProbing {

    public static void main(String args[])
    {
        int arr[] = { 50, 700, 76, 85, 92, 73, 101 };

        int tsize = 11;
        int hash_table[] = new int[tsize];

        // Initializing the hash table
        for (int i = 0; i < tsize; i++) {
            hash_table[i] = -1;
        }

        // Function call
        quadraticHashing(hash_table, arr);
        improvedQuadraticHashing(hash_table, tsize, arr, arr.length);
    }


    // Function to implement the quadratic probing
    static void quadraticHashing(int table[], int arr[])
    {

        int tsize = table.length, n = arr.length;

        // Iterating through the array
        for (int i = 0; i < n; i++) {

            // Computing the hash value
            int hv = arr[i] % tsize;

            // Insert in the table if there
            // is no collision
            if (table[hv] == -1)
                table[hv] = arr[i];
            else {

                // If there is a collision
                // iterating through all
                // possible quadratic values
                for (int j = 1; j <= tsize; j++) {

                    // Computing the new hash value
                    int t = (hv + j * j) % tsize;
                    if (table[t] == -1) {

                        // Break the loop after
                        // inserting the value
                        // in the table
                        table[t] = arr[i];
                        break;
                    }
                }
            }
        }

        System.out.println("Output: " + Arrays.toString(table));
    }

    /**
     * The above implementation of quadratic probing does not guarantee that we will always be able to use a hast
     * table empty slot. It might happen that some entries do not get a slot even if there is a slot available.
     * For example consider the input array {21, 10, 32, 43, 54, 65, 87, 76} and table size 11, we get the output
     * as {10, -1, 65, 32, 54, -1, -1, -1, 43, -1, 21} which means the items 87 and 76 never get a slot.
     * To make sure that elements get filled, we need to have a higher table size.
     *
     * A hash table can be fully utilized using the below idea.
     * Iterate over the hash table to next power of 2 of table size. For example if table size is 11, then iterate
     * 16 times. And iterate over the hash table using the below formula
     * hash(x) = [hash(x) + (j + j*j)/2] % (Next power of 2 of table size)
     *
     * Below is the implementation of this idea.
     * */
    static void improvedQuadraticHashing(int table[], int tsize, int arr[], int n) {
        for (int i = 0; i < n; i++) {
            // Compute the hash value
            int hv = arr[i] % tsize;

            // Insert in the table if there is no collision
            if (table[hv] == -1) {
                table[hv] = arr[i];
            } else {
                // If there is a collision, iterate through possible quadratic values
                int m = nextPowerOf2(tsize);
                for (int j = 1; j <= m; j++) {
                    int t = (hv + (j + j * j) / 2) % m;
                    if (t < tsize && table[t] == -1) {
                        table[t] = arr[i];
                        break;
                    }
                }
            }
        }
        System.out.println("Output: " + Arrays.toString(table));
    }

    // Function to calculate the next power of 2 greater than or equal to m
    static int nextPowerOf2(int m) {
        m--;
        m |= m >> 1;
        m |= m >> 2;
        m |= m >> 4;
        m |= m >> 8;
        m |= m >> 16;
        return m + 1;
    }

}