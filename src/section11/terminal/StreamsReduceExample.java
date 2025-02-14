package section11.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import data.Student;
import data.StudentDatabase;

/**
 * Reduce takes stream and reduces it to one single value It is terminal
 * operation similar to collect() that invokes intermediate operations It takes
 * first parameter as default or initial value and second parameter as
 * BinaryOperator
 */
public class StreamsReduceExample {

	public static void main(String[] args) {

		reduceOperationOnIntegerStreams();
		reduceOperationOnStudent();
		reduceWithMapAndFilter();
		reduceWithMinAndMax();
		reduceWithSkipAndLimit();
	}

	private static void reduceOperationOnIntegerStreams() {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(1, 3, 5, 7);
		System.out.println("Integer list: " + integerList);
		int multiplication = integerList.stream()
				// First iteration: a = 1 (default value), b = 1 (list value at index 0), res =
				// 1*1 = 1
				// Second iteration: a = 1 (previous operation result), b = 3 (list value at
				// next index i.e. 1), res = 1*3 = 3
				// Third iteration: a = 3 (previous operation result), b = 5 (list value at next
				// index i.e. 2), res = 3*5 = 15
				// Fourth iteration: a = 15 (previous operation result), b = 7 (list value at
				// next index i.e. 3), res = 15*7 = 105
				.reduce(1, (a, b) -> a * b);
		System.out.println("Multiplication using identity: " + multiplication);
		Optional<Integer> multiplicationWithoutIdentity = integerList.stream().reduce((a, b) -> a * b);
		System.out.println("Multiplication without using identity i.e. initial or default value: "
				+ multiplicationWithoutIdentity.get());
		List<Integer> emptyIntegerList = new ArrayList<>();
		Optional<Integer> multiplicationOfEmptyList = emptyIntegerList.stream().reduce((a, b) -> a * b);
		System.out.println("Is Multiplication value received for empty list: " + multiplicationOfEmptyList.isPresent());
		// Below statement will give error as no value is present
		// System.out.println("Multiplication value for empty list: " +
		// multiplicationOfEmptyList.get());
		System.out.println("Multiplication value for empty list: " + multiplicationOfEmptyList.orElse(null));
	}

	private static void reduceOperationOnStudent() {
		// TODO Auto-generated method stub
		List<Student> students = StudentDatabase.getAllStudents();
		Optional<Student> student = students.stream()
				.reduce((student1, student2) -> student1.getGpa() > student2.getGpa() ? student1 : student2);
		System.out.println("Is there any student with max gpa? " + student.isPresent());
		if (student.isPresent()) {
			System.out.println(student.get());
		}
	}

	private static void reduceWithMapAndFilter() {
		// TODO Auto-generated method stub
		List<Student> students = StudentDatabase.getAllStudents();
		int numberOfNoteBooks = students.stream() // Stream<Student>
				.map(stud -> stud.getNoteBooks()) // Stream<Integer>
				.reduce(0, Integer::sum); // It will work as below statement
//				.reduce(0,(a, b) -> a+b); // Gives sum of integers
		System.out.println("Number of total notebooks: " + numberOfNoteBooks);

		Optional<Integer> numberOfNoteBooksFromMale = students.stream() // Stream<Student>
				.filter(stud -> stud.getGender().equals("male")) // Stream<Student>
				.map(stud -> stud.getNoteBooks()) // Stream<Integer>
				.reduce(Integer::sum); // Gives sum of integers
		// orElse() can be used in place of get() to avoid getting error while accessing
		// direct result
		System.out.println("Number of notebooks from male: " + numberOfNoteBooksFromMale.orElse(null));
	}

	private static void reduceWithMinAndMax() {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(1, 3, 5, 7);
//		List<Integer> integerList = new ArrayList<>();
		System.out.println("Integer list: " + integerList);
		int maxValue = integerList.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println("Max value is: " + maxValue);
		int minValue = integerList.stream().reduce(0, (a, b) -> a < b ? a : b);
		System.out.println("Min value is: " + minValue);
		Optional<Integer> optionalMaxValue = integerList.stream().reduce((a, b) -> a > b ? a : b);
		Optional<Integer> optionalMinValue = integerList.stream().reduce((a, b) -> a < b ? a : b);
		System.out.println("Optional max value is: " + optionalMaxValue.orElse(-1));
		System.out.println("Optional min value is: " + optionalMinValue.orElse(-1));
	}

	private static void reduceWithSkipAndLimit() {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(1, 3, 5, 7, 9);
		System.out.println("Integer list: " + integerList);
		Optional<Integer> optionalSumUsingSkip = integerList.stream().skip(2).reduce((a, b) -> a + b);
		Optional<Integer> optionalSumUsingLimit = integerList.stream().limit(3).reduce((a, b) -> a + b);
		System.out.println("Optional sum skipping first 2 elements: " + optionalSumUsingSkip.orElse(-1));
		System.out.println("Optional sum limiting to 3 elements: " + optionalSumUsingLimit.orElse(-1));
	}

}
