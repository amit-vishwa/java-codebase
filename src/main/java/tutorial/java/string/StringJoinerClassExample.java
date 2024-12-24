package tutorial.java.string;

import java.util.ArrayList;
import java.util.StringJoiner;

// Java program to Demonstrate Methods of StringJoiner class
public class StringJoinerClassExample {

    public static void main(String[] args)
    {
        // Creating an empty ArrayList of string type
        ArrayList<String> al = new ArrayList<>();

        // Adding elements to above List
        al.add("Ram");
        al.add("Shyam");
        al.add("Alice");
        al.add("Bob");

        // Creating object of class inside main()
        StringJoiner sj1 = new StringJoiner(",");

        // Using setEmptyValue() method
        sj1.setEmptyValue("sj1 is empty");
        System.out.println(sj1);

        // Using add() method
        sj1.add(al.get(0)).add(al.get(1));
        System.out.println(sj1); // Output -> Ram,Shyam

        // Using length() method
        System.out.println("Length of sj1 : "
                + sj1.length());

        StringJoiner sj2 = new StringJoiner(":");
        sj2.add(al.get(2)).add(al.get(3)); // Output -> Alice:Bob

        // Using merge() method
        sj1.merge(sj2); // Here Ram,Shyam is joined with Alice:Bob using delimiter ',' of sj1

        // Using toString() method
        System.out.println(sj1); // Output -> Ram,Shyam,Alice:Bob

        System.out.println("Length of new sj1 : "
                + sj1.length());
    }

}
