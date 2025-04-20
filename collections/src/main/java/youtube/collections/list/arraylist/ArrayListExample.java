package youtube.collections.list.arraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList class implements List interface which extends Collection interface
 * List interface has the following features:
 * - Order preservation
 * - Index-based access
 * - Duplicates allowed
 *
 * ArrayList is resizable array implementation of List interface.
 * It is part of Java's collection framework. Unlike arrays in Java, which have a fixed size,
 * an ArrayList can change its size dynamically as elements are added or removed.
 *
 * Initial capacity of ArrayList is 10 when it is created.
 * Capacity increases when elements are added, usually by 1.5 times of initial capacity.
 * When an element is removed, all right side elements are shifted to left by 1.
 *
 * Size is different from capacity, size only increases when elements added.
 *
 * Time complexity:
 * Access -> O(1)
 * Insertion -> O(n)
 * Deletion -> O(n)
 * Iterate -> O(n)
 * */
public class ArrayListExample {

    public static void main(String[] args) {
//        basicOperations();
//        listSizeAndCapacity();
//        listCreation();
//        elementsRemoval();
        listToArray();
    }

    private static void basicOperations(){
        // from Java 7 we don't need to specify datatype while allocating memory i.e. object creation
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Index 0: " + list.get(0));
        System.out.println("Index 2: " + list.get(2));
//        System.out.println("Index 10: " + list.get(10)); // gives IndexOutOfBoundsException
        System.out.println("Size: " + list.size());
        System.out.println("Contains 2: " + list.contains(2));
        System.out.println("Contains 20: " + list.contains(20));
        for(int i = 0; i < list.size(); i++){
            System.out.println("Index " + i + ": " + list.get(i));
        }
        System.out.println("Removed element from index " + list.remove(2));
        for(int x : list){
            System.out.print(x + " ");
        }
        System.out.println();
        list.add(2,9);
        System.out.println("Add element at index 2");
        for(int x : list){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Updated element at index 2 from "+list.set(2,3)+" to 3");
        for(int x : list){
            System.out.print(x + " ");
        }
    }

    private static void listSizeAndCapacity(){
        try {
            // we can specify initial capacity to avoid overhead to shrinking and expanding
            ArrayList<Integer> list = new ArrayList<>(12);
            Field field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
            /**
             * Since elementData is transient hence not accessible easily.
             * So to access it, edit configuration file of the project and below in VM options
             * --add-opens java.base/java.util=ALL-UNNAMED
             * */
            Object[] elementData = (Object[]) field.get(list);
            System.out.println("Capacity: " + elementData.length); // initial capacity 12
            System.out.println("Size: " + list.size()); // initial size 0
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(1);
            elementData = (Object[]) field.get(list);
            // capacity is 18 (i.e. 1.5 time 12) as size is greater than 12
            System.out.println("Capacity: " + elementData.length);
            System.out.println("Size: " + list.size()); // size 14
            list.remove(1);
            list.remove(1);
            list.remove(1);
            list.remove(1);
            list.remove(1);
            list.remove(1);
            list.remove(1);
            elementData = (Object[]) field.get(list);
            // Even though elements are removed the capacity won't shrink automatically
            System.out.println("Capacity: " + elementData.length); // capacity 18
            System.out.println("Size: " + list.size()); // size 7
            list.trimToSize(); // this will update the capacity as per list size
            elementData = (Object[]) field.get(list);
            System.out.println("Capacity: " + elementData.length); // capacity 7
            System.out.println("Size: " + list.size()); // size 7
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listCreation(){
        /**
         * In this list which is object of ArrayList, we can perform all operations
         * */
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        /**
         * The list returned by asList() of Arrays util class is different.
         * The object ArrayList is inside Arrays which is static class and extends AbstractList.
         * Since AbstractList is child of List interface, it can return List but ArrayList object is of Arrays.
         * The elements in this list can only be modified, no addition or removal is allowed.
         * */
        List<String> list1 = Arrays.asList("MONDAY","TUESDAY");
//        list1.add("FRIDAY"); // throws UnsupportedOperationException
        System.out.println(list1.getClass().getName());

        String[] array = {"apple","banana"};
        List<String> list2 = Arrays.asList(array);
        list2.set(1,"mango"); // this will work
        System.out.println(list2.getClass().getName());

        /**
         * The of() of List is added since Java 9.
         * It returns an unmodifiable list which means even elements cannot be updated.
         * */
        List<Integer> list3 = List.of(1,2,3);
        // below both will throw UnsupportedOperationException, only elements can be read
//        list3.add(4);
//        list3.set(0,10);
        System.out.println(list3.getClass().getName());

        /**
         * We can create a list from unmodifiable or other list and perform all operations
         * initial capacity or collection can be passed in argument
         * */
        List<Integer> list4 = new ArrayList<>(list3);
        list4.add(4);
        list4.add(6);
        list4.set(4,5);
        System.out.println(list4);

        // we can add all elements of one list to another list
        list.addAll(list1); // adds elements of new list at end of current list
        list.addAll(1,list2); // adds elements of new list at specified index, then shift other elements
        System.out.println(list);
    }

    private static void elementsRemoval() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1);
        list1.remove(2); // removes element at index 2 i.e. 'c'
        list1.remove("a"); // removes first occurrence of 'a' if found, else nothing happens
        System.out.println(list1);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
        list2.add(4);
        System.out.println(list2);
        // below both remove() are different, they take different types in parameters
        list2.remove(2); // removes elements from index 2
        list2.remove(Integer.valueOf(2)); // removes 2 i.e. element which is Integer object
        System.out.println(list2);
    }

    private static void listToArray() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4,1,2,3));
        System.out.println(list);
        Object[] array = list.toArray(); // this is for generic type
        Integer[] array1 = list.toArray(new Integer[0]); // array type can be specified here with initial array size
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));

        Collections.sort(list); // this will sort list in ascending order
        System.out.println(list);
    }

}
