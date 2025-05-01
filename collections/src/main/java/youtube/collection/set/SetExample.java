package youtube.collection.set;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Set is a collection interface that cannot contain duplicate elements. Operations are faster in Set.
 *
 * Below are Map and Set interfaces and their implementation classes:
 * Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
 * Set --> HashSet, LinkedHashSet, TreeSet, EnumSet
 *
 * All methods in implementation classes of Set interface are similar to Map implementation classes.
 * */
public class SetExample {

    public static void main(String[] args) {
//        simpleSetExample();
        synchronizationExample();
//        unmodifiableSetCreation();
    }

    private static void simpleSetExample() {
        List<Integer> numbers = Arrays.asList(12,1,67,2,12,1);
        Set<Integer> hashSet = new HashSet<>(numbers); // it works with null values as well
        System.out.println(hashSet); // un-ordered non-duplicate set

        Set<Integer> linkedHashSet = new LinkedHashSet<>(numbers); // it works with null values as well
        System.out.println(linkedHashSet); // ordered non-duplicate set

//        Set<Integer> treeSet = new TreeSet<>((a,b)->b-a); // descending ordered
        Set<Integer> treeSet = new TreeSet<>(); // throws null pointer exception for null values
        treeSet.addAll(numbers);
        System.out.println(treeSet); // sorted non-duplicate set
    }

    private static void synchronizationExample() {
        List<Integer> numbers = Arrays.asList(12,1,67,2,12,1);
//        Set<Integer> hashSet = new HashSet<>(numbers); // it works with null values as well
        Set<Integer> hashSet = new HashSet<>(); // it works with null values as well
        updateSet(hashSet);
        System.out.println(hashSet.size());

        // since Set implementation classes are not thread-safe, similar to Map we can use below
        Set<Integer> newHashSet = new HashSet<>();
        Set<Integer> synchronizedHashSet = Collections.synchronizedSet(newHashSet); // wraps all method using sync
        updateSet(synchronizedHashSet);
        System.out.println(synchronizedHashSet.size());
        // not good idea to synchronize externally, example below
        synchronizedHashSet = Collections.synchronizedSet(new HashSet<>(Arrays.asList(1,2,3,4,5)));
        synchronized (synchronizedHashSet){ // will require to use it in sync block for thread-safety
            for (int i : synchronizedHashSet){
                System.out.print(i+" ");
            }// hence, not recommended at all
        }
        System.out.println();

        // ConcurrentSkipListSet is thread-safe and used to store elements in sorted order
        Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>(); // recommended to use for thread-safety
        updateSet(concurrentSkipListSet);
        System.out.println(concurrentSkipListSet.size());
//        System.out.println(concurrentSkipListSet); // gives synchronized sorted list
    }

    private static void unmodifiableSetCreation(){
        // 1. Can be created using Set.of(), unlike Map.of() it can take more than 10 elements
        Set<Integer> integerSet = Set.of(1,2,3,4,5,6,7,8,9,0,22,21,11); // null & duplicate elements will give error
//        integerSet.add(56); // throws UnsupportedOperationException
        System.out.println(integerSet);

        // 2. Can be created using Collections.unmodifiableSet()
        Set<Integer> unmodifiableSet = Collections.unmodifiableSet(Set.of(1,2,3,4,5)); // error on null or duplicate
//        unmodifiableSet.add(6); // throws UnsupportedOperationException
        System.out.println(unmodifiableSet);
    }

    private static void updateSet(Set<Integer> set){
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 10000; i++){
                set.add(i);
            }
        });
        Thread t2 = new Thread(()->{
            for(int i = 10000; i < 20000; i++){
                set.add(i);
            }
        });
        t1.start();t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) { }
        System.out.println("Time taken: " + (System.currentTimeMillis()-startTime));
    }

}
