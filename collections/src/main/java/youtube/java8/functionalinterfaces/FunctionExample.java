package youtube.java8.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Function is a functional interface that takes input and returns output.
 * Both type of input and output must be provided.
 *
 * Function is also of type Bi-Function where 2 inputs are passed to get a response.
 * UnaryOperator is also a type of Function where single type is passed when input and output type is same.
 * BinaryOperator is also a type of Function where single type is passed when input and output type is same,
 * only here the input are of 2 arguments similar to Bi-Function.
 * */
public class FunctionExample {

    public static void main(String[] args) {
        simpleFunctionExample();
        biFunctionExample();
        unaryOperatorExample();
        binaryOperatorExample();
    }

    private static void simpleFunctionExample() {
        Function<Integer,Integer> twice = x -> 2 * x;
        Function<Integer,Integer> thrice = x -> 3 * x;

        System.out.println(twice.apply(2) + ", " + thrice.apply(2)); // 4, 6
        System.out.println(twice.andThen(thrice).apply(5)); // (2 * 5) * 3 -> 10 * 3 -> 30
        System.out.println(twice.compose(thrice).apply(5)); // (3 * 5) * 2 -> 15 * 2 -> 30
        System.out.println(thrice.andThen(twice).apply(5)); // this is similar to above

        Function<Integer,Integer> identity = Function.identity(); // returns same input
        System.out.println(identity.apply(5)); // result will be the provided input 5
    }

    private static void biFunctionExample() {
        BiFunction<Integer, Integer, String> biFunction = (x,y) -> x*y+"";
        System.out.println(biFunction.apply(4,10) +", " + (biFunction.apply(4,10) instanceof String));
    }

    private static void unaryOperatorExample() {
        UnaryOperator<Integer> twice = x -> 2 * x;
        System.out.println(twice.apply(10));
    }

    private static void binaryOperatorExample() {
        BinaryOperator<Integer> twiceOfInputProduct = (x, y) -> 2 * x * y;
        System.out.println(twiceOfInputProduct.apply(4,5));
    }

}
