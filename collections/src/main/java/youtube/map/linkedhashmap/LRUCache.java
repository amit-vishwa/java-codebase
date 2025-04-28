package youtube.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Caching example to demonstrate the use of accessOrder in LinkedHashMap.
 * */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    // created to access capacity as it cannot be accessed from super classes
    private int capacity;

    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // setting accessOrder to true, won't remove the least used element, it simply push it on top
        return size() > capacity; // size comes from LinkedHashMap
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        // below will act as elements are getting accessed and display them accordingly
//        studentMap.putAll(Map.of("student1",90,"student2",80,"student3",100));
        // below will maintain the order, it will display different and correct result than above
        studentMap.put("student1",90);
        studentMap.put("student2",80);
        studentMap.put("student3",100);
        System.out.println(studentMap);
        studentMap.put("student1",99); // accessing student1, now it will be on bottom and student2 is on top
        studentMap.put("student4",80); // new element added, now least used element will be removed
        System.out.println(studentMap);
    }

}
