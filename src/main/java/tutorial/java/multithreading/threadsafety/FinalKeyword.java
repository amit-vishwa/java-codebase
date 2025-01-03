package tutorial.java.multithreading.threadsafety;

/**
 * Refer: https://www.geeksforgeeks.org/final-keyword-in-java/
 *
 * Final Variables are also thread-safe in java because once assigned some reference of an object It cannot point to reference
 * of another object.
 *
 * The final method in Java is used as a non-access modifier applicable only to a variable, a method, or a class. It is used to
 * restrict a user in Java.
 * The following are different contexts where the final is used:
 * - Variable
 * - Method
 * - Class
 *
 * Characteristics of final keyword in Java:
 * In Java, the final keyword is used to indicate that a variable, method, or class cannot be modified or extended. Here are some
 * of its characteristics:
 * i. Final variables: When a variable is declared as final, its value cannot be changed once it has been initialized. This is
 * useful for declaring constants or other values that should not be modified.
 * ii. Final methods: When a method is declared as final, it cannot be overridden by a subclass. This is useful for methods that
 * are part of a class’s public API and should not be modified by subclasses.
 * iii. Final classes: When a class is declared as final, it cannot be extended by a subclass. This is useful for classes that are
 * intended to be used as is and should not be modified or extended.
 * iv. Initialization: Final variables must be initialized either at the time of declaration or in the constructor of the class.
 * This ensures that the value of the variable is set and cannot be changed.
 * v. Performance: The use of a final can sometimes improve performance, as the compiler can optimize the code more effectively
 * when it knows that a variable or method cannot be changed.
 * vi. Security: The final can help improve security by preventing malicious code from modifying sensitive data or behavior.
 *
 * Overall, the final keyword is a useful tool for improving code quality and ensuring that certain aspects of a program cannot
 * be modified or extended. By declaring variables, methods, and classes as final, developers can write more secure, robust,
 * and maintainable code.
 * */
public class FinalKeyword {
    // Initializing a string
    // variable of final type
    final static String str
            = new String("hello");

    // Defining a method to
    // change the value of the final
    // variable which is not possible,
    // hence the error will be shown
    public static void main(String... args)
    {
//        str = "world"; // uncomment to get error
        System.out.println(str);
    }
}
