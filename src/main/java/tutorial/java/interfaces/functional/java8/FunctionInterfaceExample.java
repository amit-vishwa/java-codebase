package tutorial.java.interfaces.functional.java8;

import java.util.function.Function;

// Refer: https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
public class FunctionInterfaceExample {

    public static void main(String args[])
    {
        // Function which takes in an integer and
        // returns half of it with type double
        Function<Integer, Double> half = a -> a / 2.0;

        // Now triple the output of half function
        half = half.andThen(a -> 3 * a); // executed in order

        // Triple the value given to half function
        half = half.compose(a -> 10 + a); // executed first

        // Applying the function to get the result
        // and printing on console
        System.out.println(half.apply(10));

        // Function which takes in a number and
        // returns it
        Function<Integer, Integer> i = Function.identity();

        // Print statement
        System.out.println(i.apply(10));
    }

}
