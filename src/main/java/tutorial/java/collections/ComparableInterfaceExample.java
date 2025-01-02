package tutorial.java.collections;

import java.util.Arrays;
import java.util.Collections;

/**
 * Refer: https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/?ref=lbp
 *
 * The Comparable interface in Java is used to define the natural ordering of objects for a user-defined class. It is part of the
 * java.lang package and it provides a compareTo() method to compare instances of the class. A class has to implement a Comparable
 * interface to define its natural ordering.
 *
 * The compareTo() method is overridden to define the ascending order logic by comparing the v fields of Number objects. Then
 * the Arrays.sort() method sorts the array by using this logic.
 *
 * It compares the current object with the specified object.
 * It returns:
 * - Negative, if currentObj < specifiedObj.
 * - Zero, if currentObj == specifiedObj.
 * - Positive, if currentObj > specifiedobj.
 *
 * Use of Comparable Interface
 * - In this method, we are going to implement the Comparable interface from java.lang Package in the Pair class.
 * - The Comparable interface contains the method compareTo to decide the order of the elements.
 * - Override the compareTo method in the Pair class.
 * - Create an array of Pairs and populate the array.
 * - Use the Arrays.sort() function to sort the array.
 * */
public class ComparableInterfaceExample {

    public static void main(String[] args) {
        compareSingleValue();
        compareMultipleValues();
    }

    static void compareSingleValue(){
        // Create an array of Number objects
        Number[] n = { new Number(4), new Number(1),
                new Number(7), new Number(2) };
        System.out.println("Before Sorting: "
                + Arrays.toString(n));
        // Sort the array (uses compareTo() of Comparable internally, same applicable for Collections.sort())
        Arrays.sort(n);
        // Display numbers after sorting
        System.out.println("After Sorting: " + Arrays.toString(n));
    }

    static void compareMultipleValues(){
        // Create an array of Pair objects
        Pair[] p = {
                new Pair("raj", "kashup"),
                new Pair("rahul", "singh"),
                new Pair("reshmi", "dubey"),
        };
        System.out.println("\nBefore Sorting:");
        for (Pair p1 : p) {
            System.out.println(p1);
        }
        // Sort the array of pairs (uses overridden compareTo() of Comparable internally)
        Arrays.sort(p);
        System.out.println("\nAfter Sorting:");
        for (Pair p1 : p) {
            System.out.println(p1);
        }
    }
}

class Number implements Comparable<Number> {
    int v; // Value of the number

    // Constructor
    public Number(int v) {
        this.v = v;
    }

    // toString() for displaying the number
    @Override
    public String toString() {
        return String.valueOf(v);
    }

    // compareTo() method to
    // define sorting logic
    @Override
    public int compareTo(Number o) {

        // Ascending order
        return this.v - o.v;
        // Descending order
//        return o.v - this.v;
    }

}

class Pair implements Comparable<Pair> {
    String f; // First name
    String l;  // Last name

    // Constructor
    public Pair(String f, String l) {
        this.f = f;
        this.l = l;
    }

    // toString() method
    // for displaying the Pair
    @Override
    public String toString() {
        return "(" + f + ", " + l + ")";
    }

    // compareTo method for
    // comparison logic
    @Override
    public int compareTo(Pair p) {

        // Compare based on the first name
        // (lexicographical order)
        if (this.f.compareTo(p.f) != 0) {
//            return this.f.compareTo(p.f); // ascending
            return p.f.compareTo(this.f); // descending
        }

        // If first names are the same,
        // compare based on the last name
//        return this.l.compareTo(p.l);  // ascending
        return p.l.compareTo(this.l);  // descending
    }

}