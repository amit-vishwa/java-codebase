package youtube.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Consumer is a functional interface that takes input without returning any output.
 * Here, the return type is void.
 * */
public class ConsumerExample {

    public static void main(String[] args) {
        simpleConsumerExample();
        biConsumerExample();
    }

    private static void simpleConsumerExample() {
        Consumer<Integer> printInteger = x -> System.out.println(x);
        Consumer<Integer> printString = n -> System.out.println(n*2);
        printInteger.andThen(printString).accept(10);

        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> printIntegers = list -> {
            for(int i : list){
                System.out.print(i + " ");
            }
        };
        printIntegers.accept(integers);
        System.out.println();

        // it works similar to above as forEach() takes consumer as input
        integers.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void biConsumerExample() {
        BiConsumer<String, String> concatenatedString = (x,y) -> System.out.println(x.concat(y));
        concatenatedString.accept("Hello", " World!");
    }

}
