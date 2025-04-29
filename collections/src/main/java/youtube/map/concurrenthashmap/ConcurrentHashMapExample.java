package youtube.map.concurrenthashmap;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap is a class that implements the ConcurrentMap interface, which extends the Map interface.
 * This was added in Java 5.
 *
 * In Java 7, segment based locking were performed.
 * For each capacity a separate segment was created i.e. for 16 it will be 16 different segments or smaller hashmaps.
 * Write operation required locking, whereas read only get locked when some write operation was getting performed on it.
 *
 * From Java 8, segmentation were removed, so no need to wait if another operation to be performed on same segment.
 * It uses compare and swap approach, consider Thread1 is trying to update a value in the map. Current value is
 * 45 which needs to be updated to 50, before updating it checks if it is same what last saw value is or if it can
 * be updated, and it is not locked or updated by another process. If yes, it waits and retries else it updates.
 * Locking will only be performed in case of resizing or collision. Resizing is done by incrementing capacity by 1.
 * No locking is done for read operations, for write operations compare and swap approach is used.
 * */
public class ConcurrentHashMapExample {

    public static void main(String[] args) {
        simpleConcurrentHashMapOperations();
    }

    private static void simpleConcurrentHashMapOperations() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Thread thread1 = new Thread(()->{
            for(int i=0; i< 100;i++){
                concurrentHashMap.put("Thread"+i,i);
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i=100; i< 200;i++){
                concurrentHashMap.put("Thread"+i,i);
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
//        System.out.println("Map: " + concurrentHashMap);
        System.out.println("Size: " + concurrentHashMap.size());
    }

}
