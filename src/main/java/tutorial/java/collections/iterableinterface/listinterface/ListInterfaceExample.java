package tutorial.java.collections.iterableinterface.listinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Refer: https://www.geeksforgeeks.org/list-interface-java-examples/?ref=next_article
 *
 * Java List Interface
 * The List Interface in Java extends the Collection Interface and is a part of java.util package. It is used to store the
 * ordered collections of elements. So in a Java List, you can organize and manage the data sequentially.
 * - Maintained the order of elements in which they are added.
 * - Allows the duplicate elements.
 * - The implementation classes of the List interface are ArrayList, LinkedList, Stack, and Vector.
 * - Can add Null values that depend on the implementation.
 * - The List interface offers methods to access elements by their index and includes the listIterator() method, which returns
 * a ListIterator.
 * - Using ListIterator, we can traverse the list in both forward and backward directions.
 *
 * The common implementation classes of the List interface are ArrayList, LinkedList, Stack, and Vector:
 * - ArrayList and LinkedList are the most widely used due to their dynamic resizing and efficient performance for specific operations.
 * - Stack is a subclass of Vector, designed for Last-In-First-Out (LIFO) operations.
 * - Vector is considered a legacy class and is rarely used in modern Java programming. It is replaced by ArrayList and
 * java.util.concurrent package.
 *
 * Java List – Operations
 * Since List is an interface, it can be used only with a class that implements this interface. Now, let’s see how to perform
 * a few frequently used operations on the List.
 * Operation 1: Adding elements to List using add() method
 * Operation 2: Updating elements in List using set() method
 * Operation 3: Searching for elements using indexOf(), lastIndexOf methods
 * Operation 4: Removing elements using remove() method
 * Operation 5: Accessing Elements in List using get() method
 * Operation 6: Checking if an element is present in the List using contains() method
 * Now let us discuss the operations individually and implement the same in the code to grasp a better grip over it.
 * */
public class ListInterfaceExample {

    public static void main(String[] args) {
        System.out.println("1.Adding Elements to the List:");
        addElements();
        System.out.println("\n2.Updating the List:");
        updateElements();
        System.out.println("\n3.Searching in a List:");
        searchElement();
        System.out.println("\n4.Removing Elements from the List:");
        removeElements();
        System.out.println("\n5.Access Elements from the List:");
        accessElements();
        System.out.println("\n6.Check if Element is present in the List:");
        isElementPresent();
        System.out.println("\n7.Traversing the List:");
        traverseList();
    }

    /**
     * 1. Adding Elements
     * In order to add an element to the list, we can use the add() method. This method is overloaded to perform multiple
     * operations based on different parameters.
     *
     * Parameters:  It takes 2 parameters, namely:
     * add(Object o): This method is used to add an element at the end of the List.
     * add(int index, Object o): This method is used to add an element at a specific index in the List
     *
     * Note: If we do not specify the length of the array in the ArrayList constructor while creating the List object,
     * using add(int index, Object) for any index i will throw an Exception if we have not specified the values for 0 to i-1
     * index already.
     *
     * Complexities:
     * Time: O(1)
     * Space: O(1)
     * */
    private static void addElements() {
        // Creating an object of List interface,
        // implemented by ArrayList class
        List<String> al = new ArrayList<>();
        // Adding elements to object of List interface
        // Custom elements
        al.add("Geeks");
        al.add("Geeks");
        al.add(1, "For");
        // Print all the elements inside the
        // List interface object
        System.out.println(al);
    }

    /**
     * 2. Updating Elements
     * After adding the elements, if we wish to change the element, it can be done using the set() method. Since List is indexed,
     * the element which we wish to change is referenced by the index of the element. Therefore, this method takes an index and
     * the updated element which needs to be inserted at that index.
     *
     * Complexities:
     * Time: O(1)
     * Space: O(1)
     * */
    private static void updateElements() {
        // Creating an object of List interface
        List<String> al = new ArrayList<>();
        // Adding elements to object of List class
        al.add("Geeks");
        al.add("Geeks");
        al.add(1, "Geeks");
        // Display theinitial elements in List
        System.out.println("Initial ArrayList " + al);
        // Setting (updating) element at 1st index
        // using set() method
        al.set(1, "For");
        // Print and display the updated List
        System.out.println("Updated ArrayList " + al);
    }

    /**
     * 3. Searching Elements
     * Searching for elements in the List interface is a common operation in Java programming. The List interface provides
     * several methods to search for elements, such as the indexOf(), lastIndexOf() methods.
     * The indexOf() method returns the index of the first occurrence of a specified element in the list, while the lastIndexOf()
     * method returns the index of the last occurrence of a specified element.
     *
     * Parameters:
     *  indexOf(Object o): Returns the index of the first occurrence of the specified element in the list, or -1 if the element
     *  is not found
     *  lastIndexOf(Object o): Returns the index of the last occurrence of the specified element in the list, or -1 if the element
     *  is not found
     *
     * Complexities:
     * Time: O(1)
     * Space: O(1)
     * */
    private static void searchElement() {
        // create a list of integers
        List<Integer> al = new ArrayList<>();
        // add some integers to the list
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(2);
        // use indexOf() to find the first occurrence of an
        // element in the list
        int i = al.indexOf(2);
        System.out.println("First Occurrence of 2 is at Index: "+i);
        // use lastIndexOf() to find the last occurrence of
        // an element in the list
        int l = al.lastIndexOf(2);
        System.out.println("Last Occurrence of 2 is at Index: "+l);
    }

    /**
     * 4. Removing Elements
     * In order to remove an element from a list, we can use the remove() method. This method is overloaded to perform multiple
     * operations based on different parameters. They are:
     *
     * Parameters:
     * remove(Object o): This method is used to simply remove an object from the List. If there are multiple such objects, then
     * the first occurrence of the object is removed.
     * remove(int index): Since a List is indexed, this method takes an integer value which simply removes the element present
     * at that specific index in the List. After removing the element, all the elements are moved to the left to fill the space
     * and the indices of the objects are updated.
     *
     * Complexities:
     * Time: O(N)
     * Space: O(N)
     * */
    private static void removeElements() {
        // Creating List class object
        List<String> al = new ArrayList<>();
        // Adding elements to the object
        // Custom inputs
        al.add("Geeks");
        al.add("Geeks");
        // Adding For at 1st indexes
        al.add(1, "For");
        // Print the initialArrayList
        System.out.println("Initial ArrayList " + al);
        // Now remove element from the above list
        // present at 1st index
        al.remove(1);
        // Print the List after removal of element
        System.out.println("After the Index Removal " + al);
        // Now remove the current object from the updated
        // List
        al.remove("Geeks");
        // Finally print the updated List now
        System.out.println("After the Object Removal " + al);
    }

    /**
     * 5. Accessing Elements
     * In order to access an element in the list, we can use the get() method, which returns the element at the specified index
     *
     * Parameters:
     * get(int index): This method returns the element at the specified index in the list.
     *
     * Complexities:
     * Time: O(1)
     * Space: O(1)
     * */
    private static void accessElements() {
        // Creating an object of List interface,
        // implemented by ArrayList class
        List<String> al = new ArrayList<>();
        // Adding elements to object of List interface
        al.add("Geeks");
        al.add("For");
        al.add("Geeks");
        // Accessing elements using get() method
        String first = al.get(0);
        String second = al.get(1);
        String third = al.get(2);
        // Printing all the elements inside the
        // List interface object
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(al);
    }

    /**
     * 6. Checking if an element is present or not
     * In order to check if an element is present in the list, we can use the contains() method. This method returns true if
     * the specified element is present in the list, otherwise, it returns false.
     *
     * Parameters:
     * contains(Object o): This method takes a single parameter, the object to be checked if it is present in the list.
     *
     * Complexities:
     * Time: O(N)
     * Space: O(1)
     * */
    private static void isElementPresent() {
        // Creating an object of List interface,
        // implemented by ArrayList class
        List<String> al = new ArrayList<>();
        // Adding elements to object of List interface
        al.add("Geeks");
        al.add("For");
        al.add("Geeks");
        // Checking if element is present using contains()
        // method
        boolean isPresent = al.contains("Geeks");
        // Printing the result
        System.out.println("Is Geeks present in the list? "+ isPresent);
    }

    /**
     * 7.Iterating over List Interface in Java
     * Till now we are having a very small input size and we are doing operations manually for every entity. Now let us discuss
     * various ways by which we can iterate over the list to get them working for a larger sample set.
     * Methods: There are multiple ways to iterate through the List. The most famous ways are by using the basic for loop in
     * combination with a get() method to get the element at a specific index and the advanced for a loop.
     * */
    private static void traverseList() {
        // Creating an empty Arraylist of string type
        List<String> al = new ArrayList<>();
        // Adding elements to above object of ArrayList
        al.add("Geeks");
        al.add("Geeks");
        // Adding element at specified position
        // inside list object
        al.add(1, "For");
        // Using  for loop for iteration
        for (int i = 0; i < al.size(); i++) {
            // Using get() method to
            // access particular element
            System.out.print(al.get(i) + " ");
        }
        // New line for better readability
        System.out.println();
        // Using for-each loop for iteration
        for (String str : al)
            // Printing all the elements
            // which was inside object
            System.out.print(str + " ");
    }

}
