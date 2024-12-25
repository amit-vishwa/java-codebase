package tutorial.dsa.algorithms.hashing.closed;

/**
 * Refer: https://www.geeksforgeeks.org/implementing-hash-table-open-addressing-linear-probing-cpp/
 *
 * Prerequisite – Hashing Introduction, Implementing our Own Hash Table with Separate Chaining in Java
 * In Open Addressing, all elements are stored in the hash table itself. So at any point, size of table must be
 * greater than or equal to total number of keys (Note that we can increase table size by copying old data if needed).
 *
 * Insert(k) – Keep probing until an empty slot is found. Once an empty slot is found, insert k.
 * Search(k) – Keep probing until slot’s key doesn’t become equal to k or an empty slot is reached.
 * Delete(k) – Delete operation is interesting. If we simply delete a key, then search may fail. So slots of deleted
 * keys are marked specially as “deleted”.
 *
 * Let hash(x) be the slot index computed using a hash function and S be the table size
 * If slot hash(x) % S is full, then we try (hash(x) + 1) % S
 * If (hash(x) + 1) % S is also full, then we try (hash(x) + 2) % S
 * If (hash(x) + 2) % S is also full, then we try (hash(x) + 3) % S
 *
 * i.Complexity analysis for Insertion:
 * Time Complexity:
 * Best Case: O(1)
 * Worst Case: O(N). This happens when all elements have collided and we need to insert the last element by checking free space one by one.
 * Average Case: O(1) for good hash function, O(N) for bad hash function
 * Auxiliary Space: O(1)
 *
 * ii.Complexity analysis for Deletion:
 * Time Complexity:
 * Best Case: O(1)
 * Worst Case: O(N)
 * Average Case: O(1) for good hash function; O(N) for bad hash function
 * Auxiliary Space: O(1)
 *
 * iii.Complexity analysis for Searching:
 * Time Complexity:
 * Best Case: O(1)
 * Worst Case: O(N)
 * Average Case: O(1) for good hash function; O(N) for bad hash function
 * Auxiliary Space: O(1) for search operation
 * */
public class LinearProbing {

    public static void main(String[] args)
    {
        HashMap h = new HashMap();
        h.insertNode(1, 1);
        h.insertNode(2, 2);
        h.insertNode(2, 3);
        h.display();
        System.out.println(h.sizeofMap());
        System.out.println(h.deleteNode(2));
        System.out.println(h.sizeofMap());
        System.out.println(h.isEmpty());
        System.out.println(h.get(2));
    }

}

// Our own HashNode class
class HashNode {
    int key;
    int value;

    public HashNode(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

// Our own Hashmap class
class HashMap {
    // hash element array
    int capacity;
    int size;
    HashNode[] arr;
    // dummy node
    HashNode dummy;

    public HashMap()
    {
        this.capacity = 20;
        this.size = 0;
        this.arr = new HashNode[this.capacity];
        // initialize with dummy node
        this.dummy = new HashNode(-1, -1);
    }

    // This implements hash function to find index for a key
    public int hashCode(int key)
    {
        return key % this.capacity;
    }

    // Function to add key value pair
    public void insertNode(int key, int value)
    {
        HashNode temp = new HashNode(key, value);
        // Apply hash function to find index for given key
        int hashIndex = hashCode(key);
        // find next free space
        while (this.arr[hashIndex] != null
                && this.arr[hashIndex].key != key
                && this.arr[hashIndex].key != -1) {
            hashIndex++;
            hashIndex %= this.capacity;
        }
        // if new node to be inserted, increase the current
        // size
        if (this.arr[hashIndex] == null
                || this.arr[hashIndex].key == -1) {
            this.size++;
        }
        this.arr[hashIndex] = temp;
    }

    // Function to delete a key value pair
    public int deleteNode(int key)
    {
        // Apply hash function to find index for given key
        int hashIndex = hashCode(key);
        // finding the node with given key
        while (this.arr[hashIndex] != null) {
            // if node found
            if (this.arr[hashIndex].key == key) {
                HashNode temp = this.arr[hashIndex];
                // Insert dummy node here for further use
                this.arr[hashIndex] = this.dummy;
                // Reduce size
                this.size--;
                return temp.value;
            }
            hashIndex++;
            hashIndex %= this.capacity;
        }
        // If not found return -1
        return -1;
    }

    // Function to search the value for a given key
    public int get(int key)
    {
        // Apply hash function to find index for given key
        int hashIndex = hashCode(key);
        int counter = 0;
        // finding the node with given key
        while (this.arr[hashIndex] != null) {
            // If counter is greater than capacity to avoid
            // infinite loop
            if (counter > this.capacity) {
                return -1;
            }
            // if node found return its value
            if (this.arr[hashIndex].key == key) {
                return this.arr[hashIndex].value;
            }
            hashIndex++;
            hashIndex %= this.capacity;
            counter++;
        }
        // If not found return 0
        return 0;
    }

    // Return current size
    public int sizeofMap() { return this.size; }

    // Return true if size is 0
    public boolean isEmpty() { return this.size == 0; }

    // Function to display the stored key value pairs
    public void display()
    {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] != null
                    && this.arr[i].key != -1) {
                System.out.println(
                        "key = " + this.arr[i].key
                                + " value = " + this.arr[i].value);
            }
        }
    }
}
