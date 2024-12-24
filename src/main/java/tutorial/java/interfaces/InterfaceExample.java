package tutorial.java.interfaces;

/**
 *
 * An Interface in Java programming language is defined as an abstract type used to specify the behavior
 * of a class. An interface in Java is a blueprint of a behavior.
 * A Java interface contains static constants and abstract methods.
 *
 * The interface in Java is a mechanism to achieve abstraction. Traditionally, an interface could only
 * have abstract methods (methods without a body) and public, static, and final variables by default.
 * It is used to achieve abstraction and multiple inheritances in Java.
 * In other words, interfaces primarily define methods that other classes must implement.
 * Java Interface also represents the IS-A relationship.
 *
 * New Features Added in Interfaces in JDK 8
 * There are certain features added to Interfaces in JDK 8 update mentioned below:
 * 1. Prior to JDK 8, the interface could not define the implementation.
 * We can now add default implementation for interface methods.
 * This default implementation has a special use and does not affect the intention behind interfaces.
 * Suppose we need to add a new function to an existing interface.
 * Obviously, the old code will not work as the classes have not implemented those new functions.
 * So with the help of default implementation, we will give a default body for the newly added functions.
 * Then the old codes will still work.
 *
 * 2. Another feature that was added in JDK 8 is that we can now define static methods in interfaces
 * that can be called independently without an object.
 * Note: these methods are not inherited.
 *
 * New Features Added in Interfaces in JDK 9
 * From Java 9 onwards, interfaces can contain the following also:
 * - Static methods
 * - Private methods
 * - Private Static methods
 *
 * Marker or Tagged Interfaces are interfaces without any methods they serve as a marker without any capabilities.
 *
 * Types of interfaces in Java are mentioned below:
 * Functional Interface
 * Marker interface
 *
 * Multiple Inheritance is not supported by class because of ambiguity. In the case of interface,
 * there is no ambiguity because the implementation of the method(s) is provided by the implementing
 * class up to Java 7. From Java 8, interfaces also have implementations of methods.
 * So if a class implements two or more interfaces having the same method signature with implementation,
 * it is mandated to implement the method in class also.
 *
 * */

public class InterfaceExample {
    public static void main(String args[])
    {
        // Creating object of this class
        // in main() method
        TestClass d = new TestClass();

        // Now calling the methods from both the interfaces
        d.show(); // Default method from API
        d.display(); // Overridden method from Interface1
        d.print(); // Overridden method from Interface2
        API.staticDisplay();
        System.out.println(API.a);
        System.out.println(API.b);
        System.out.println(API.c);
    }
}

// Java program to demonstrate How Diamond Problem
// Is Handled in case of Default Methods

// Interface 1
interface API {
    // all variables and methods should be public
    // variables are public, static and final by default and cannot be changed
    int a = 10;
    int b = 20;
    int c = 30;
    static void staticDisplay()
    {
        System.out.println("hello");
    }
    // Default method
    default void show()
    {
        // Print statement
        System.out.println("Default API");
    }
}

// Interface 2
// Extending the above interface
interface Interface1 extends API {
    // Overriding the abstract method from Interface1
    // Abstract method
    void display();
}

// Interface 3
// Extending the above interface
interface Interface2 extends API {
    // Abstract method
    void print();
}

// Main class
// Implementation class code
class TestClass implements Interface1, Interface2 {
    // Overriding the abstract method from Interface1
    @Override
    public void display()
    {
        System.out.println("Display from Interface1");
    }
    // Overriding the abstract method from Interface2
    @Override
    public void print()
    {
        System.out.println("Print from Interface2");
    }
}