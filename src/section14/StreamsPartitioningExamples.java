package section14;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * Demonstrates the use of partitioningBy()
 */
public class StreamsPartitioningExamples {

	public static void main(String[] args) {
		List<Student> students = StudentDatabase.getAllStudents();
		singleParameterExample(students);
		doubleParameterExample(students);
	}

	private static void singleParameterExample(List<Student> students) {
		System.out.println("Students with GPA more than 3.8");
		Map<Boolean, List<Student>> studentGpaList = students.stream()
				.collect(Collectors.partitioningBy(student -> student.getGpa() > 3.8));
		studentGpaList.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(System.out::println);
		});
		System.out.println();
	}

	private static void doubleParameterExample(List<Student> students) {
		System.out.println("Students with GPA less than 3.8");
		Map<Boolean, Set<Student>> studentGpaSet = students.stream()
				.collect(Collectors.partitioningBy(student -> student.getGpa() < 3.8, Collectors.toSet()));
		studentGpaSet.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(System.out::println);
		});
	}
}
