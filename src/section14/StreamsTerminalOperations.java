package section14;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * The program demonstrates the use of: joining(), counting(), mapping(),
 * minBy() & maxBy() using collect(), sum() & avg() using collect(),
 * partitioningBy()
 */
public class StreamsTerminalOperations {

	public static void main(String... args) {
		List<Student> students = StudentDatabase.getAllStudents();
		streamsJoiningExamples(students);
		streamsCountingExamples(students);
		streamsMappingExamples(students);
		streamsMinByMaxByExamples(students);
		streamsSumAvgUsingCollectExamples(students);
	}

	/**
	 * Demonstrated joining() with and without delimiter, and prefix suffix
	 */
	private static void streamsJoiningExamples(List<Student> students) {
		String names = students // List<Student>
				.stream() // Stream<Student>
				.map(Student::getName) // Stream<String>
				.collect(Collectors.joining()); // String
		System.out.println("1.Joined student names: " + names);
		String namesUsingDelimiter = students // List<Student>
				.stream() // Stream<Student>
				.map(Student::getName) // Stream<String>
				.collect(Collectors.joining("-")); // String
		System.out.println("2.Joined student names using delimiter: " + namesUsingDelimiter);
		String joinedNamesWithPrefixSuffix = students // List<Student>
				.stream() // Stream<Student>
				.map(Student::getName) // Stream<String>
				.collect(Collectors.joining("-", "(", ")")); // String
		System.out.println("3.Joined student names using delimiter and prefix-suffix: " + joinedNamesWithPrefixSuffix);
	}

	/**
	 * Demonstrated simple count(), and counting() with and without filter
	 */
	private static void streamsCountingExamples(List<Student> students) {
		long count = students.stream().count();
		System.out.println("4.Student count using count(): " + count);
		long studentsCount = students.stream().collect(Collectors.counting());
		System.out.println("5.Student count using counting(): " + studentsCount);
		long studentsCountWithFilter = students.stream().filter(student -> student.getGpa() > 3.9)
				.collect(Collectors.counting());
		System.out.println("6.Student count using filter and counting(): " + studentsCountWithFilter);
	}

	/**
	 * Demonstrated map() and mapping(), mapping in collector reduces a line of code
	 */
	private static void streamsMappingExamples(List<Student> students) {
		List<String> studentNames = students.stream().map(Student::getName).collect(Collectors.toList());
		System.out.println("7.Student names using map(): " + studentNames);
		List<String> namesList = students.stream().collect(Collectors.mapping(Student::getName, Collectors.toList()));
		System.out.println("8.Student names using mapping(): " + namesList);
		Set<String> namesSet = students.stream().collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		System.out.println("9.Student names using mapping(): " + namesSet);
	}

	/**
	 * Demonstrated use of minBy and maxBy using collect
	 */
	private static void streamsMinByMaxByExamples(List<Student> students) {
		Optional<Student> minGpa = students // List<Student>
				.stream() // Stream<Student>
				// Compare by student gpa and return least one
				.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
		System.out.println("10.Student with min gpa: " + minGpa.orElse(null));
		Optional<Student> maxGpa = students // List<Student>
				.stream() // Stream<Student>
				// Compare by student gpa and return max one
				.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
		System.out.println("11.Student with max gpa: " + maxGpa.get());
	}

	/**
	 * Demonstrated use of summingInt() and averagingInt() using collect
	 */
	private static void streamsSumAvgUsingCollectExamples(List<Student> students) {
		int sumOfNotebooks = students // List<Student>
				.stream() // Stream<Student>
				// Sums up the notebooks
				.collect(Collectors.summingInt(Student::getNoteBooks));
		System.out.println("12.Student notebooks sum: " + sumOfNotebooks);
		double avgOfNotebooks = students // List<Student>
				.stream() // Stream<Student>
				// Sums up the notebooks
				.collect(Collectors.averagingInt(Student::getNoteBooks));
		System.out.println("13.Student notebooks average: " + avgOfNotebooks);
	}

}
