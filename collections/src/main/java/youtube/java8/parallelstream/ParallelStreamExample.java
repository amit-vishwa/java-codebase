package youtube.java8.parallelstream;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Parallel streams are a feature of Java 8 that allows you to process collections in parallel.
 * This can lead to significant performance improvements for large collections.
 *
 * A type of stream that enables parallel processing of elements in a collection.
 * Allowing multiple threads to process parts of the stream simultaneously. This can significantly improve
 * performance for large data sets, workload is distributed across multiple threads.
 *
 * Parallel streams are most effective for CPU-intensive tasks or large data sets where tasks are independent.
 * They may add overhead for simple tasks or smaller datasets.
 * In many cases where multithreading is required, parallel stream can be used. However, it may not perform
 * well if used at non-required place. It may become overhead as well, so use it wisely.
 * */
public class ParallelStreamExample {

    public static void main(String[] args) {
//        streamVsParallelStreamExample();
        avoidParallelStreamExample();
    }

    private static void streamVsParallelStreamExample() {
        // sequential stream time limit
        long startTime = System.currentTimeMillis();
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(20000).toList();
//        System.out.println(numbers);
        List<Integer> factorials = numbers.stream().map(ParallelStreamExample::factorial).toList();
//        System.out.println(factorials);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken by sequential stream: " + (endTime - startTime) + " ms");

        // parallel stream time limit - it may not be required for size less than 1000
        startTime = System.currentTimeMillis();
        List<Integer> factorialList = numbers.parallelStream().map(ParallelStreamExample::factorial).toList();
//        System.out.println(factorialList);
        endTime = System.currentTimeMillis();
        System.out.println("Total time taken by parallel stream: " + (endTime - startTime) + " ms");
    }

    // when operations are dependent or state changes, never use parallel stream
    private static void avoidParallelStreamExample() {
        // 1. Cumulative sum example
        List<Integer> numbers = List.of(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger(); // initial value is 0
        List<Integer> cumulativeSums = numbers
                .parallelStream() // won't perform well due to dependency of operations
                .map(sum::addAndGet) // adds current with sum and return current value
                .sequential() // converting parallel stream to sequential
                .toList();
        System.out.println(numbers);
        System.out.println(cumulativeSums);
    }

    private static int factorial(int n){
        int factorial = 1;
        for(int i = 2; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }

}
