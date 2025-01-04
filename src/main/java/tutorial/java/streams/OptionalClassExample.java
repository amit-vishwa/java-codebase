package tutorial.java.streams;

import java.util.Optional;

/**
 * Refer: https://www.geeksforgeeks.org/java-8-optional-class/
 *
 * Every Java Programmer is familiar with NullPointerException. It can crash your code. And it is very hard to avoid it without
 * using too many null checks. So, to overcome this, Java 8 has introduced a new class Optional in java.util package. It can help
 * in writing a neat code without using too many null checks. By using Optional, we can specify alternate values to return or
 * alternate code to run. This makes the code more readable because the facts which were hidden are now visible to the developer.
 * */
public class OptionalClassExample {

    // Driver code
    public static void main(String[] args)
    {

        // creating a string array
        String[] str = new String[5];

        // Setting value for 2nd index
        str[2] = "Geeks Classes are coming soon";

        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[2]);

        // It returns value of an Optional.
        // If value is not present, it throws
        // an NoSuchElementException
        System.out.println(value.get());

        // It returns hashCode of the value
        System.out.println(value.hashCode());

        // It returns true if value is present,
        // otherwise false
        System.out.println(value.isPresent());
    }
}