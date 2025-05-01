package youtube.java8.primitivestreams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Primitive streams are used to create streams from primitive data types.
 * */
public class PrimitiveStreamsExample {

    public static void main(String[] args) {
        // 1. Create int stream using Array.stream()
        int[] numbers = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(numbers);
        System.out.println(Arrays.toString(intStream.toArray()));

        // 2. Create int stream using IntStream.rangeClosed(), IntStream.range()
        IntStream intStream1 = IntStream.rangeClosed(1,10); // both included in range closed
        System.out.println(Arrays.toString(intStream1.toArray()));
        List<Integer> integerList = IntStream.range(1,10).boxed().toList(); // end value 10 is not included
        System.out.println(integerList);

        // 3. Create int stream using IntStream.of()
        IntStream intStream2 = IntStream.of(1,2,3);
        System.out.println(Arrays.toString(intStream2.toArray()));

        // 4. Create int stream using random.ints()
        IntStream intStream3 = new Random().ints(10);
        List<Integer> intList = intStream3.boxed().toList();
        System.out.println(intList);
        System.out.println(new Random().ints(10).count());
        System.out.println(new Random().ints(10).findAny().getAsInt());

        // 5. Create double stream using random.doubles()
        DoubleStream doubleStream = new Random().doubles(3);
        System.out.println(Arrays.toString(doubleStream.toArray()));
        System.out.println(new Random().doubles(10).mapToInt(x->(int)x).sum());
        List<Double> doubleList = new Random().doubles(3).boxed().toList();
        System.out.println(doubleList);
    }

}
