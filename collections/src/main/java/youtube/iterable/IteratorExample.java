package youtube.iterable;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Iterable interface is the parent class of Collection interface.
 * An iterable object is an object that can be iterated over.
 * The iterator() method returns an iterator for the object.
 *
 * All child classes of Iterable interface must implement the iterator() method.
 * Hence, all collections can be iterated.
 * */
public class IteratorExample {

    public static void main(String[] args) {
        simpleIteratorExample();
        listIteratorExample();
    }

    private static void simpleIteratorExample() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        // forEach internally uses below iterator logic since index or size is unknown
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        numbers = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4,5));
        for (Integer i : numbers) {
            if(i % 2 == 0){
                // it will only work for CopyOnWriteArrayList in forEach loop
                numbers.remove(i);
            } else System.out.print(i+" ");
        }
        System.out.println();

        // we can use iterator to perform concurrent operation like above
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> itr = numberList.iterator(); // iterator needs to re-define as it cannot traverse more than once
        while (itr.hasNext()){
            Integer i = itr.next();
            if(i % 2 == 1){
                // it will work, and we can remove elements from iterator that reflects in list
                itr.remove();
            } else System.out.print(i+" ");
        }
        System.out.println("\n"+numberList);
    }

    private static void listIteratorExample() {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ListIterator<Integer> listIterator = numbers.listIterator();
        System.out.println(listIterator.nextIndex());
        System.out.println(listIterator.previousIndex());
        System.out.println(listIterator.hasNext());
        System.out.println(listIterator.hasPrevious());
        while (listIterator.hasNext()){
            Integer i = listIterator.next();
            if(i % 2 != 0){
                // we can perform add, update and delete operations using list iterator, while iterating
                listIterator.set(i*2);
            }else
            System.out.print(i + " ");
        }
        System.out.println("\n"+numbers);

        List<Integer> numberList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ListIterator<Integer> listItr = numberList.listIterator(numberList.size()); // pointer at list size
        while (listItr.hasPrevious()){
            System.out.print(listItr.previous()+" "); // printing reversed list
        }
    }

}
