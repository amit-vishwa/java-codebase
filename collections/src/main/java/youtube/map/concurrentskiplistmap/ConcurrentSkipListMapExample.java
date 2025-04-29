package youtube.map.concurrentskiplistmap;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ConcurrentSkipListMap is a map which is thread-safe and keys are stored in sorted manner.
 * Map --> Sorted --> Thread-safe --> ConcurrentSkipListMap
 *
 * Here, data is stored in a data structure called skip-list. SkipList is a probabilistic data structure
 * that allows for efficient search, insertion, and deletion operations. It is similar to sorted linked list
 * but with multiple layers that "skip" over portions of the list to provide faster access to elements.
 *
 * ConcurrentSkipListMap is concurrent version of TreeMap where sorting is performed.
 * */
public class ConcurrentSkipListMapExample {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer,String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put(1,"One");
        concurrentSkipListMap.put(5,"Five");
        concurrentSkipListMap.put(8,"Eight");
        concurrentSkipListMap.put(2,"Two");
        concurrentSkipListMap.put(0,"Zero");
        System.out.println(concurrentSkipListMap.descendingKeySet()); // returns descending order of keys
        System.out.println(concurrentSkipListMap);
        // methods in ConcurrentSkipListMap is similar to NavigableMap as it implements ConcurrentNavigableMap interface
        System.out.println("Lower entry before 8: " + concurrentSkipListMap.lowerEntry(8));
        System.out.println("Lower key before 3: " + concurrentSkipListMap.lowerKey(3));
        System.out.println("Higher entry after 8: " + concurrentSkipListMap.higherEntry(8)); // null if not found
        System.out.println("Higher key after 3: " + concurrentSkipListMap.higherKey(3));
        System.out.println("Ceiling entry equals or after 6: " + concurrentSkipListMap.ceilingEntry(6));
        System.out.println("Ceiling key equals or after 9: " + concurrentSkipListMap.ceilingKey(9));
    }

}
