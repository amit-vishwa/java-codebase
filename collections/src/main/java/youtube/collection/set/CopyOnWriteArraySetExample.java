package youtube.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Similar to CopyOnWriteArrayList, CopyOnWriteArraySet is used for concurrent operations.
 * Here, it will perform similar to ConcurrentSkipListSet however it will not sort the Set.
 *
 * It is thread-safe, follows copy-on-write mechanism, no duplicate elements are allowed.
 * Iterators do not reflect modifications similar to CopyOnWriteArrayList, the new list will have all elements.
 *
 * When frequent read and writes are there then ConcurrentSkipListSet can be used.
 * When more iteration and read, and less writes are there then CopyOnWriteArraySet can be used.
 * */
public class CopyOnWriteArraySetExample {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,5,7,2,9,0)); // allows duplicate but not null
        System.out.println("HashSet: " + set);
        Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>(set);
        System.out.println("ConcurrentSkipListSet: " + concurrentSkipListSet);
        Set<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>(set);
        System.out.println("CopyOnWriteArraySet: " + copyOnWriteArraySet);

        // iteration and modifying concurrentSkipListSet
        for(int i : concurrentSkipListSet){
            if(i==9) // we can add manually if it is the last element then add to avoid inconsistency
            concurrentSkipListSet.add(10);
            System.out.print(i+" ");
            concurrentSkipListSet.add(8);
            // before and after both are reflected during iteration itself which is inconsistent
            // as we don't know how many times it will run
        }
        System.out.println("\nUpdated ConcurrentSkipListSet: "+concurrentSkipListSet); // sorted all updated elements

        // iteration and modifying copyOnWriteArraySet
        for(int i : copyOnWriteArraySet){
            copyOnWriteArraySet.add(10); // before modification not considered
            System.out.print(i+" ");
            copyOnWriteArraySet.add(8); // after modification not considered
            // before and after both are not reflected during iteration to maintain consistency
        }
        System.out.println("\nUpdated CopyOnWriteArraySet: "+copyOnWriteArraySet); // un-ordered all updated elements
    }

}
