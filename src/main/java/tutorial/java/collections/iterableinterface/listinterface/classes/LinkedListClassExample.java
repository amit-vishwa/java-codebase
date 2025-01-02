package tutorial.java.collections.iterableinterface.listinterface.classes;

import java.util.LinkedList;

/**
 * Refer: https://www.geeksforgeeks.org/linked-list-in-java/?ref=next_article
 *
 * Linked List is a part of the Collection framework present in java.util package. This class is an implementation of the
 * LinkedList data structure which is a linear data structure where the elements are not stored in contiguous locations and every
 * element is a separate object with a data part and address part. The elements are linked using pointers and addresses and each
 * element is known as a node.
 *
 * Performing Various Operations on LinkedList
 * Adding elements
 * Updating elements
 * Removing elements
 * Iterating over elements
 * To Array();
 *  Size();
 * remove First();
 * remove last();
 */
public class LinkedListClassExample {

    public static void main(String args[])
    {
        LinkedList<String> ll = new LinkedList<>();

        // 1.Add
        ll.add("Geeks");
        ll.add("Geek");
        ll.add(1, "Gor");
        System.out.println("Initial LinkedList " + ll);

        // 2.Update
        ll.set(1, "For");
        System.out.println("Updated LinkedList " + ll);

        // 3.Remove
        ll.remove(1);
        System.out.println("After the Index Removal " + ll);
        ll.remove("Geek");
        System.out.println("After the Object Removal " + ll);

        // 4.Iterate
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println();
        // Using the for each loop
        for (String str : ll)
            System.out.print(str + " ");

        // 5.Linked list to To Array by using  toArray();
        System.out.println("LinkedList: "+ ll);
        Object[] a = ll.toArray();
        System.out.print("After converted LinkedList to Array: ");
        for(Object element : a)
            System.out.print(element+" ");

        // 6.Size
        System.out.println("\nThe size of the linked list is: " + ll.size());

        // 7.Remove first
        System.out.println("The remove first element is: " + ll.removeFirst());
        System.out.println("Final LinkedList:" + ll);

        // 8.Remove last
        ll.add("one");
        ll.add("two");
        ll.add("three");
        // Remove the tail using removeLast()
        System.out.println("The last element is removed: " + ll.removeLast());
        // Displaying the final list
        System.out.println("Final LinkedList:" + ll);
        // Remove the tail using removeLast()
        System.out.println("The last element is removed: " + ll.removeLast());
        // Displaying the final list
        System.out.println("Final LinkedList:" + ll);

    }
}
