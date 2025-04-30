package youtube.java8.functionalinterfaces;

import java.util.function.Supplier;

/**
 * Supplier is a functional interface that don't take any inputs and returns an output. Here no arguments provided.
 * */
public class SupplierExample {

    public static void main(String[] args) {
        simpleSupplierExample();
    }

    private static void simpleSupplierExample() {
        Supplier<String> getString = () -> "Hello world!";
        System.out.println(getString.get()); // Hello world!
    }

}
