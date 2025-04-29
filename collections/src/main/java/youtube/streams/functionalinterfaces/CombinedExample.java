package youtube.streams.functionalinterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CombinedExample {

    public static void main(String[] args) {
        combinedFunctionInterfaceExample();
    }

    private static void combinedFunctionInterfaceExample() {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer,Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 120;

        Integer input = supplier.get();
        if(predicate.test(input)){
            consumer.accept(function.apply(input));
        }
    }

}
