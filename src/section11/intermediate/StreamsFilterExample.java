package section11.intermediate;

import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * Filter takes predicate and performs filter by excluding elements for whom
 * condition is false
 */
public class StreamsFilterExample {

	public static void main(String[] args) {
		List<Student> students = StudentDatabase.getAllStudents();
		students.forEach(System.out::println);

		List<Student> reversedStudents = students.reversed();
		System.out.println();
		reversedStudents.forEach(System.out::println);

		List<Student> maleStudents = students.stream().filter(student -> student.getGender().equalsIgnoreCase("male"))
				.collect(Collectors.toList());
		System.out.println();
		maleStudents.forEach(System.out::println);

		List<Student> femaleStudentsWithGPA = students.stream()
				.filter(student -> student.getGender().equalsIgnoreCase("female"))
				.filter(student -> student.getGpa() > 3.8).collect(Collectors.toList());
		System.out.println();
		femaleStudentsWithGPA.forEach(System.out::println);

		List<Student> maleStudentsWithGPA = students.stream()
				.filter(student -> student.getGpa() > 3.8 && student.getGender().equalsIgnoreCase("male"))
				.collect(Collectors.toList());
		System.out.println();
		maleStudentsWithGPA.forEach(System.out::println);
	}

}
