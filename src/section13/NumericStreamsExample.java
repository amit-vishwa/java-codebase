package section13;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * The program demonstrates numeric streams examples and operations like:
 * range(), rangeClosed(), count(), foreach(), sum(), max(), min(), average(),
 * Boxing, Unboxing, mapToInt(), mapToDouble(), mapToLong(), mapToObj()
 */
public class NumericStreamsExample {

	public static void main(String... args) {
		simpleNumericStreams();
		streamsRangeExamples();
		streamsAggregateExamples();
		streamsBoxingUnboxingExamples();
		streamsMapToExamples();
	}

	/**
	 * Used simple reduce function to find sum
	 */
	private static void simpleNumericStreams() {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("Integer list: " + integerList);
		int sum = integerList.stream().reduce(0, Integer::sum); // unboxing to convert Integer to int
		System.out.println("Sum: " + sum);
		int addition = IntStream.rangeClosed(1, 5) // creates int stream of 1 to 5
				.sum();
		System.out.println("Sum using int stream: " + addition);
	}

	/**
	 * IntStream, LongStream and DoubleStream usage for range and closed range Count
	 * and for each are also used
	 */
	private static void streamsRangeExamples() {
		int start = 1;
		int end = 20;
		long rangeCount = IntStream.range(start, end).count();
		LongStream.range(start, end).forEach(x -> System.out.print(x + ","));
		System.out.println();
		System.out.println("Range count from 1 to 20 for range(): " + rangeCount);
		long rangeClosedCount = LongStream.rangeClosed(start, end).count();
		IntStream.rangeClosed(start, end).forEach(x -> System.out.print(x + ","));
		System.out.println();
		System.out.println("Range count from 1 to 20 for rangeClosed(): " + rangeClosedCount);
		System.out.print("Double stream: "); // we can get double stream using as shown below
		IntStream.rangeClosed(start, end).asDoubleStream().forEach(x -> System.out.print(x + ", "));
		System.out.println();
	}

	/**
	 * Aggregate functions like sum, min, max and average are used. OptionalInt,
	 * OptionalLong are used with max and min. OptionalDouble is used along with
	 * average
	 */
	private static void streamsAggregateExamples() {
		int sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println("Sum: " + sum);
		OptionalInt max = IntStream.rangeClosed(1, 10).max();
		// Will always get 0 for max, min, avg as default value
		// we can get as int value for actual max or min value
		System.out.println("Max: " + max.getAsInt());
		OptionalLong min = LongStream.rangeClosed(1, 10).min();
		// we can also use or else in case no min or max found
		System.out.println("Min: " + min.orElse(-1));
		OptionalDouble average = IntStream.rangeClosed(1, 10).average();
		System.out.println("Average: " + average.getAsDouble());
	}

	/**
	 * Boxing is converting primitive type to wrapper classes (int to Integer)
	 * Unboxing is converting wrapper classes to primitive types (Integer to int)
	 * mapToInt() is used for unboxing
	 */
	private static void streamsBoxingUnboxingExamples() {
		List<Integer> intList = IntStream.rangeClosed(1, 10) // int stream of int types
				.boxed() // converts to stream of Integer types
				.collect(Collectors.toList()); // collects in List<Integer>
		System.out.println("Boxing example (int to Integer): " + intList);
		IntStream intStream = intList // List<Integer>
				.stream() // Stream<Integer>
				.mapToInt(x -> x); // intStream
		System.out.print("Unboxing example (Integer to int): ");
		intStream.forEach(System.out::print);
		System.out.print("\n");
	}

	/**
	 * mapToObject - converts each element type to object type 
	 * mapToDouble - converts each element type to double type 
	 * mapToLong - converts each element type to long type
	 */
	private static void streamsMapToExamples() {
		List<Integer> objectType = IntStream.rangeClosed(1, 5) // intStream
				.mapToObj(Integer::new) // int to Integer
				.collect(Collectors.toList()); // list of Integer
		System.out.println("Map to object: " + objectType);
		LongStream longType = IntStream.rangeClosed(1, 5) // intStream
				.mapToLong(Long::new); // longStream
		System.out.print("Map to long: ");
		longType.forEach(System.out::print);
		DoubleStream doubleType = IntStream.rangeClosed(1, 5) // intStream
				.mapToDouble(Double::new); // doubleStream
		System.out.print("\nMap to double: ");
		doubleType.forEach(System.out::print);
	}

}
