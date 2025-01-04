package tutorial.java.lambdaexpression.methodreferences;

import java.util.*;

/**
 * Refer: https://www.geeksforgeeks.org/method-references-in-java-with-examples/?ref=next_article
 *
 * Type 2: Reference to an instance method of a particular object
 * If a Lambda expression is like:
 * // If a lambda expression just call a default method of an object
 * (args) -> obj.instanceMethod(args)
 *
 * Then method reference is like:
 * // Shorthand if a lambda expression just call a default method of an object
 * obj::instanceMethod
 * */
public class InstanceMethodReference {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating an empty ArrayList of user-defined type
        // List of person
        List<Student> personList = new ArrayList<>();

        // Adding elements to above object
        // using add() method
        personList.add(new Student("vicky", 24));
        personList.add(new Student("poonam", 25));
        personList.add(new Student("sachin", 19));

        // A comparator class with multiple
        // comparator methods
        ComparisonProvider comparator
                = new ComparisonProvider();

        // Now using instance method reference
        // to sort array by name
        Collections.sort(personList,
                comparator::compareByName);

        // Display message only
        System.out.println("Sort by name :");

        // Using streams
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        // Using instance method reference
        // to sort array by age
        Collections.sort(personList,
                comparator::compareByAge);

        // Display message only
        System.out.println("Sort by age :");

        personList.stream()
                .map(x -> x.getName()+" "+x.getAge())
                .forEach(System.out::println);
    }
}

// Java Program to Illustrate How One can use
// Static method reference
// To Sort with Custom Comparator
// But using object method reference

// Class 1
// Helper class
// Object need to be sorted
class Student {

    // Attributes of a person
    private String name;
    private Integer age;

    // Constructor
    public Student(String name, int age)
    {
        // This keyword refers to current object itself
        this.name = name;
        this.age = age;
    }

    // Getter-setter methods
    public Integer getAge() { return age; }
    public String getName() { return name; }
}

// Class 2
// Helper class
// Comparator class
class ComparisonProvider {

    // Method 1
    // To compare with name
    public int compareByName(Student a, Student b)
    {
        return a.getName().compareTo(b.getName());
    }

    // Method 2
    // To compare with age
    public int compareByAge(Student a, Student b)
    {
        return a.getAge().compareTo(b.getAge());
    }
}