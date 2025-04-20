package youtube.collections.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Vector is a part of Java Collection framework and implements the List interface.
 *
 * It is similar to ArrayList but with some differences:
 * - Synchronized: Vector is synchronized, meaning it is thread-safe and can be used in multithreaded environments.
 *  ArrayList is not synchronized and is not thread-safe.
 * - Growth: When the size of a Vector exceeds its capacity, it doubles its size. ArrayList increases its size by 50%.
 * - Enumeration: Vector has a legacy method called elements() which returns an Enumeration of the elements in the vector.
 *  ArrayList does not have this method.
 * - Legacy: Vector is a legacy class and is part of the original version of Java i.e. JDK 1.0. ArrayList was introduced
 * later as part of the Java Collections Framework.
 *
 * Performance Considerations:
 * - Vector is slower than ArrayList due to synchronization overhead.
 * - Vector is more memory efficient than ArrayList as it doubles its size when it exceeds its capacity.
 * - Vector is more suitable for multithreaded environments where thread safety is required.
 * - Due to memory overhead operations, Vector should not be used in single-threaded environments.
 * */
public class VectorExample {

    public static void main(String[] args) {
//        vectorCreation();
        // Vector have similar methods as that of ArrayList and LinkedList
        threadSafeDemo();
    }

    private static void vectorCreation() {
//        parameterlessVector();
//        vectorWithInitialCapacity();
        vectorWithInitialCapAndCapIncrementVal();
//        vectorWithCollection();
    }

    private static void parameterlessVector(){
        // default capacity is 10, similar to ArrayList
        Vector<Integer> parameterLessVector = new Vector<>();
        parameterLessVector.add(1);
        System.out.println("Capacity: " + parameterLessVector.capacity() + ", Size: " + parameterLessVector.size());
        parameterLessVector.add(2);
        System.out.println("Capacity: " + parameterLessVector.capacity() + ", Size: " + parameterLessVector.size());
        parameterLessVector.addAll(Arrays.asList(3,4,5,6,7,8,9,10,11));
        // when size is more than capacity then capacity doubles initial value, when no increment value is provided
        System.out.println("Capacity: " + parameterLessVector.capacity() + ", Size: " + parameterLessVector.size());
    }

    private static void vectorWithInitialCapacity(){
        // initial capacity is 5
        Vector<Integer> initialCapacityVector = new Vector<>(5);
        initialCapacityVector.add(1);
        System.out.println("Capacity: " + initialCapacityVector.capacity() + ", Size: " + initialCapacityVector.size());
        initialCapacityVector.add(2);
        System.out.println("Capacity: " + initialCapacityVector.capacity() + ", Size: " + initialCapacityVector.size());
        initialCapacityVector.addAll(Arrays.asList(3,4,5,6)); // now Capacity = 2*initialCapacity = 2*5 = 10, Size = 6
        System.out.println("Capacity: " + initialCapacityVector.capacity() + ", Size: " + initialCapacityVector.size());
    }

    private static void vectorWithInitialCapAndCapIncrementVal() {
        // initial capacity is 5, capacity increment value is 2
        Vector<Integer> vectorWithCapacityInfo = new Vector<>(5, 2);
        vectorWithCapacityInfo.add(1);
        System.out.println("Capacity: " + vectorWithCapacityInfo.capacity() + ", Size: " + vectorWithCapacityInfo.size());
        vectorWithCapacityInfo.add(2);
        vectorWithCapacityInfo.addAll(Arrays.asList(3,4,5,6)); // now Capacity = initialCapacity + capacityIncrement = 5+2 = 7, Size = 6
        System.out.println("Capacity: " + vectorWithCapacityInfo.capacity() + ", Size: " + vectorWithCapacityInfo.size());

        // even though after removal the size is 5 which is initial capacity, the capacity won't update
        vectorWithCapacityInfo.remove(1);
        System.out.println("Capacity: " + vectorWithCapacityInfo.capacity() + ", Size: " + vectorWithCapacityInfo.size());
        vectorWithCapacityInfo.trimToSize(); // we need to trim the vector to update its capacity
        System.out.println("Capacity: " + vectorWithCapacityInfo.capacity() + ", Size: " + vectorWithCapacityInfo.size());
    }

    private static void vectorWithCollection() {
        // here, vector capacity is twice the size of Collection provided in the constructor argument
        Vector<Integer> vectorWithCapacityInfo = new Vector<>(Arrays.asList(1,2,3,6,7,9));
        vectorWithCapacityInfo.add(4);
        vectorWithCapacityInfo.add(4);
        vectorWithCapacityInfo.add(4);
        vectorWithCapacityInfo.add(4);
        System.out.println("Capacity: " + vectorWithCapacityInfo.capacity() + ", Size: " + vectorWithCapacityInfo.size());
    }

    private static void threadSafeDemo() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> vectorList = new Vector<>();
        Thread thread1 = new Thread(()->{
            for(int i = 0; i < 100; i++){
                arrayList.add(i);
                vectorList.add(i);
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i = 0; i < 100; i++){
                arrayList.add(i);
                vectorList.add(i);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(arrayList.size());
        System.out.println(vectorList.size()); // this will always be 200 due to thread-safety
    }

}
