package youtube.map.hashtable;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * HashTable is a legacy class, present since JDK 1.0, which is not used much now.
 * This is synchronized and hence slower than HashMap. No null key or value can be inserted here.
 * The newer version of HashTable, which is used nowadays, is ConcurrentHashMap.
 * Since all methods of HashTable are synchronized including get ones, this resulted in limitations,
 * hence ConcurrentHashMap introduced to overcome such limitations.
 *
 * Unlike HashMap, HashTable uses linked list only even though collision occurs and no linked list threshold here.
 *
 * Default initialCapacity is 11 and loadFactor is 0.75f.
 * When capacity is provided and size exceeds capacity then capacity updated to max of twice of
 * provided initialCapacity and 11.
 * Capacity = Math.max(2 * initialCapacity, 11)
 * ThresholdCapacity = Capacity * loadFactor
 * */
public class HashTableExample {

    public static void main(String[] args) {
//        simpleHashTableOperations();
        concurrentOperations();
    }

    private static void simpleHashTableOperations() {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1,"Apple");
        hashtable.put(2,"banana");
        hashtable.put(3,"Mango");
        hashtable.put(4,"Cherry");
        hashtable.put(5,"Orange");
        // null key and value cannot be inserted
//        hashtable.put(null,"Orange");
//        hashtable.put(6,null);
        System.out.println(hashtable);
        System.out.println("Key 2: " + hashtable.get(2));
        System.out.println("Key 6 exist: " + hashtable.containsKey(6));
        System.out.println("Removed " + hashtable.remove(1));
        System.out.println("Key 1: " + hashtable.get(1)); // gives null response
    }

    private static void concurrentOperations() {
//        HashMap<Integer, String> hashMap = new HashMap<>(); // not thread safe or synchronized
        Hashtable<Integer, String> hashMap = new Hashtable<>(); // synchronized
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1000; i++){
                hashMap.put(i,"Thread 1");
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 1000; i < 2000; i++){
                hashMap.put(i,"Thread 2");
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Size: " + hashMap.size());
    }

}
