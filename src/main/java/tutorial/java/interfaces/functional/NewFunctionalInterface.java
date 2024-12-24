package tutorial.java.interfaces.functional;

/**
 *
 * Here are some significant points regarding Functional interfaces in Java: *
 *
 * 1.In functional interfaces, there is only one abstract method supported.
 * If the annotation of a functional interface, i.e., @FunctionalInterface is not implemented or written
 * with a function interface, more than one abstract method can be declared inside it.
 * However, in this situation with more than one functions, that interface will not be called a functional interface.
 * It is called a non-functional interface.
 * 2.There is no such need for the @FunctionalInterface annotation as it is voluntary only.
 * This is written because it helps in checking the compiler level. Besides this, it is optional.
 * 3.An infinite number of methods (whether static or default) can be added to the functional interface.
 * In simple words, there is no limit to a functional interface containing static and default methods.
 * 4.Overriding methods from the parent class do not violate the rules of a functional interface in Java.
 * 5.The java.util.function package contains many built-in functional interfaces in Java 8.
 *
 * */

// Java 8 onwards, we can assign lambda expression to its functional interface object like this:
public class NewFunctionalInterface {
    public static void main(String args[])
    {
        // lambda expression to create the object
        new Thread(() -> {
            System.out.println("New thread created");
        }).start();
    }
}
