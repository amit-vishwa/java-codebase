package tutorial.java.oops.polymorphism;

/**
 * It is also known as static polymorphism.
 * This type of polymorphism is achieved by function overloading or operator overloading.
 * Note: But Java doesn’t support the Operator Overloading.
 *
 * Method Overloading:
 * In Java, Method Overloading allows different methods to have the same name,
 * but different signatures where the signature can differ by the number of input parameters or type of
 * input parameters, or a mixture of both.
 * Method overloading in Java is also known as Compile-time Polymorphism, Static Polymorphism,
 * or Early binding. In Method overloading compared to the parent argument, the child argument will get
 * the highest priority.
 * */

public class CompileTimeExample {
    public static void main(String[] args)
    {
        // Calling method by passing
        // input as in arguments
        System.out.println(Helper.Multiply(2, 4));
        System.out.println(Helper.Multiply(5.5, 6.3));
    }

//    Like other static methods, we can overload main() in Java.
    public static void main(String arg1)
    {
        System.out.println("Hi, " + arg1);
    }

    public static void main(String arg1, String arg2)
    {
        System.out.println("Hi, " + arg1 + ", " + arg2);
    }
}

// Java Program for Method overloading
// By using Different Types of Arguments 

// Class 1
// Helper class
class Helper {

    // Method with 2 integer parameters
    static int Multiply(int a, int b)
    {
        // Returns product of integer numbers
        return a * b;
    }

    // Method 2
    // With same name but with 2 double parameters
    static double Multiply(double a, double b)
    {
        // Returns product of double numbers
        return a * b;
    }
}
