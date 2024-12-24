package tutorial.java.interfaces.functional.java8;

import java.util.function.Supplier;

// Refer: https://www.geeksforgeeks.org/supplier-interface-in-java-with-examples/
public class SupplierInterfaceExample {

    public static void main(String args[])
    {
        // Supplier does not take input but returns value

        // This function returns a random value.
        Supplier<Double> randomValue = () -> Math.random();

        // Print the random value using get()
        System.out.println(randomValue.get());
    }

}
