package tutorial.java.lambdaexpression.methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Refer: https://www.geeksforgeeks.org/method-references-in-java-with-examples/?ref=next_article
 *
 * Type 3: Reference to an instance method of an arbitrary object of a particular type
 * If a Lambda expression is like:
 * // If a lambda expression just call an instance method of a  ObjectType
 * (obj, args) -> obj.instanceMethod(args)
 *
 * Then method reference is like:
 * // Shorthand if a lambda expression just call an instance method of a ObjectType
 * ObjectType::instanceMethod
 * */
public class TypeInstanceMethodReference {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating an empty ArrayList of user defined type
        // List of person
        List<String> personList = new ArrayList<>();

        // Adding elements to above object of List
        // using add() method
        personList.add("Vicky");
        personList.add("poOnaM");
        personList.add("SACHIN");

        // Method reference to String type
        Collections.sort(personList, String::compareToIgnoreCase);

        // Printing the elements(names) on console
        personList.forEach(System.out::println);
    }
}
