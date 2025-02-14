package section15;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import data.Student;
import data.StudentDatabase;

public class ParallelStreamExample {

	public static void main(String[] args) {
		differentStreams();
		checkStreamsPerformance();
		parallelStreamPipeline();
		whenNotToUseParallelStreamExample1();
		whenNotToUseParallelStreamExample2();
	}

	private static int getSumUsingSequentialStream() {
		return IntStream.rangeClosed(1, 100000).sum();
	}

	private static int getSumUsingParallelStream() {
		return IntStream.rangeClosed(1, 100000).parallel() // in parallel stream, data is split into multiple parts for
															// processing
				.sum(); // after sum called, it checks for stream type
	}

	/**
	 * Simple examples of stream and parallel stream
	 */
	private static void differentStreams() {
		System.out.println("Sum using sequential stream: " + getSumUsingSequentialStream());
		System.out.println("Sum using parallel stream: " + getSumUsingParallelStream());
	}

	private static long getStreamRunningTimestamp(int count, Supplier<Integer> streams) {
		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= count; i++) {
			streams.get();
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	/**
	 * Checks streams performance using start time and end time for loop operation
	 */
	private static void checkStreamsPerformance() {
		// Parallel is not working efficiently here
		System.out.println("Sequential stream performance: "
				+ getStreamRunningTimestamp(200, ParallelStreamExample::getSumUsingSequentialStream));
		System.out.println("Parallel stream performance: "
				+ getStreamRunningTimestamp(200, ParallelStreamExample::getSumUsingParallelStream));
		System.out.println("Number of processors: " + Runtime.getRuntime().availableProcessors());
	}

	private static List<String> getStudentActivitiesUsingStream(List<Student> students) {
		long startTime = System.currentTimeMillis();
		List<String> activities = students // List<Student>
				.stream() // Stream<Student>
				.map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.collect(Collectors.toList()); // List<String>
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken by sequential stream: " + (endTime - startTime));
		return activities;
	}

	private static List<String> getStudentActivitiesUsingParallelStream(List<Student> students) {
		long startTime = System.currentTimeMillis();
		List<String> activities = students // List<Student>
				.stream() // Stream<Student>
//				.parallelStream()
				.parallel() // we can use parallelStream(), or parallel() after stream()
				.map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.collect(Collectors.toList()); // List<String>
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken by parallel stream: " + (endTime - startTime));
		return activities;
	}

	/**
	 * Examples of stream and parallel stream using student object
	 */
	private static void parallelStreamPipeline() {
		List<Student> students = StudentDatabase.getAllStudents();
		// Parallel is working more efficiently here
		System.out.println("Activities using stream: " + getStudentActivitiesUsingStream(students));
		System.out.println("Activities using parallel stream: " + getStudentActivitiesUsingParallelStream(students));
	}

	private static long intListSumUsingStream(List<Integer> integerList) {
		long startTime = System.currentTimeMillis();
		long sum = integerList // List<Integer>
				.stream() // Stream<Integer>
				.reduce(0, Integer::sum); // Unboxing of Integer to int and then summing it
		long endTime = System.currentTimeMillis();
		System.out.println("Sequential stream duration for int list addition: " + (endTime - startTime));
		return sum;
	}

	private static long intListSumUsingParallelStream(List<Integer> integerList) {
		long startTime = System.currentTimeMillis();
		long sum = integerList // List<Integer>
				.parallelStream() // Stream<Integer> i.e. parallel stream processed by multiple processors
				// Unboxing of Integer to int and then summing it, below take more time than
				// sequential stream
				.reduce(0, Integer::sum);
		long endTime = System.currentTimeMillis();
		System.out.println("Parallel stream duration for int list addition: " + (endTime - startTime));
		return sum;
	}

	/**
	 * Demonstrates when parallel stream not to use for performance
	 */
	private static void whenNotToUseParallelStreamExample1() {
		List<Integer> integerList = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
		System.out.println("Sum of integer list using stream: " + intListSumUsingStream(integerList));
		System.out.println("Sum of integer list using parallel stream: " + intListSumUsingParallelStream(integerList));
		// Parallel stream will give low performance as it takes more time in unboxing
		// and accumulating multiple results of sum operation
	}

	/**
	 * Demonstrates when parallel stream not to use for result
	 */
	private static void whenNotToUseParallelStreamExample2() {
		Sum sum = new Sum();
		IntStream.rangeClosed(1, 10000) // IntStream of 10000
				.forEach(sum::performTotal); // iterating over stream, passing input and performing total
		System.out.println("Sum using stream: " + sum.getTotal());
		Sum add = new Sum();
		IntStream.rangeClosed(1, 10000) // IntStream of 10000
				.parallel() // make stream parallel, split into multiple parts
				.forEach(add::performTotal); // iterating over parallel stream, passing input and performing total
		System.out.println("Sum using parallel stream: " + add.getTotal());
		// Getting different results for parallel stream as it will process in across
		// multiple processors
		// so it should not be used along with mutable fields
	}

}
