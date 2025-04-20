package youtube.collections.list.copyonwritearraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList and LinkedList are not thread-safe, so concurrent operations cannot be performed.
 * Vector and Stack are thread-safe and uses locks which results in performance issues.
 * So to remove all these issues, CopyOnWriteArrayList is introduced.
 *
 * CopyOnWriteArrayList is a thread-safe variant of ArrayList in Java.
 * It is part of the java.util.concurrent package and is designed for concurrent access.
 *
 * While reading data from list, an old copy is used.
 * When write operation is performed on a list, a new copy is created and write is performed.
 * The read is still happening on old list snapshot, and at end the reference of old list is updated with new.
 * */
public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
//        simpleExample();
        multiThreadingExample();
    }

    private static void simpleExample() {
        List<String> list;
        // ArrayList will give ConcurrentModificationException
//        list = new ArrayList<>(Arrays.asList("Milk","Eggs","Bread"));
        list = new CopyOnWriteArrayList<>(Arrays.asList("Milk","Eggs","Bread"));
        System.out.println("Initial array list: " + list);
        try{
        for(String item : list){
            System.out.println(item);
            if(item.equals("Eggs")){
                System.out.println("Adding Butter while reading...");
                list.add("Butter");
            }
        }
        }catch (Exception e){
            System.out.println("ConcurrentModificationException occurred...");
        }
        System.out.println("Updated array list: " + list);
    }

    private static void multiThreadingExample() {
        List<String> sharedList;
        // For ArrayList, reader thread will get ConcurrentModificationException when write happens, and it stops
        sharedList = new ArrayList<>(Arrays.asList("Item1","Item2","Item3"));
//        sharedList = new CopyOnWriteArrayList<>(Arrays.asList("Item1","Item2","Item3"));
        Thread readerThread = new Thread(()->{
            try {
                // loop will be terminated for ArrayList when write operations are performed during read
                while (true){
                    // iterate through the list
                    for (String item : sharedList){
                        System.out.println("Reading item: " + item);
                        Thread.sleep(100); // delay to simulate work
                    }
                }
            }catch (Exception e){
                // this will be printed when new item is added in ArrayList while performing read
                System.out.println("Exception in reader thread: " + e);
            }
        });
        Thread writerThread = new Thread(()->{
            try {
                // 5 times items will be read since read delay is 100ms
                Thread.sleep(500); // delay to allow reading to start first
                System.out.println("Adding Item4 to the list...");
                sharedList.add("Item4"); // this will get executed as exception is caught

                // in addition, 5 times items will get read since read delay is 100ms
                Thread.sleep(500); // delay to allow reading to start first
                System.out.println("Removing Item1 from the list...");
                sharedList.remove("Item1"); // this will get executed as exception is caught
                System.out.println("List: " + sharedList);
            }catch (Exception e){
                System.out.println("Exception in writer thread: " + e.getMessage());
            }
        });
        readerThread.start();
        writerThread.start();
    }

}
