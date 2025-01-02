package tutorial.java.collections.iterableinterface.listinterface.classes;

import java.util.ArrayList;

/**
 * Refer: https://www.geeksforgeeks.org/arraylist-in-java/?ref=next_article
 *
 * Java ArrayList is a part of collections framework and it is a class of java.util package. It provides us with dynamic arrays
 * in Java. Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in array is
 * required. The main advantage of ArrayList is, unlike normal arrays, we don’t need to mention the size when creating ArrayList.
 * It automatically adjusts its capacity as elements are added or removed.
 *
 * Important Features of ArrayList in Java
 * ArrayList inherits AbstractList class and implements the List interface.
 * ArrayList is initialized by size. However, the size is increased automatically if the collection grows or shrinks if the objects are removed from the collection.
 * Java ArrayList allows us to randomly access the list.
 * ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases.
 * ArrayList in Java can be seen as a vector in C++.
 * ArrayList is not Synchronized. Its equivalent synchronized class in Java is Vector.
 *
 * In the above illustration, AbstractList, CopyOnWriteArrayList, and AbstractSequentialList are the classes that implement the
 * list interface. A separate functionality is implemented in each of the mentioned classes. They are:
 * i.AbstractList: This class is used to implement an unmodifiable list, for which one needs to only extend this AbstractList Class
 * and implement only the get() and the size() methods.
 * ii.CopyOnWriteArrayList: This class implements the list interface. It is an enhanced version of ArrayList in which all the
 * modifications(add, set, remove, etc.) are implemented by making a fresh copy of the list.
 * iii.AbstractSequentialList: This class implements the Collection interface and the AbstractCollection class. This class is used
 * to implement an unmodifiable list, for which one needs to only extend this AbstractList Class and implement only the get()
 * and the size() methods.
 *
 * Operations                       Time Complexity     Space Complexity
 * Inserting Element in ArrayList   O(1)                O(N)
 * Removing Element from ArrayList  O(N)                O(1)
 * Traversing Elements in ArrayList O(N)                O(N)
 * Replacing Elements in ArrayList  O(1)                O(1)
 * */
public class ArrayListClassExample {

    public static void main(String args[]){

        // Creating an Array of string type
        ArrayList<String> al = new ArrayList<>();

        // 1. Addition

        // Adding elements to ArrayList
        // at the end
        al.add("Geeks");
        al.add("Geeks");

        System.out.println("Orignal List : "+al);

        // Adding Elements at the specific
        // index
        al.add(1, "For");

        System.out.println("After Adding element at index 1 : "+ al);

        // 2. Deletion of Element

        // Removing Element using index
        al.remove(0);

        System.out.println("Element removed from index 0 : "+ al);

        // Removing Element using the value
        al.remove("Geeks");

        System.out.println("Element Geeks removed : "+ al);

        // 3. Updating Values

        // Updating value at index 0
        al.set(0, "GFG");


        // Printing all the elements in an ArrayList
        System.out.println("List after updation of value : "+al);
    }

}