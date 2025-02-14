package section11.terminal;

import java.util.List;
import java.util.Optional;

import data.Student;
import data.StudentDatabase;

/**
 * The program demonstrates the use of findFirst() and findAny(), they are
 * similar to streams match but return the same type as of input passed Both
 * first and any will give almost same results in streams, they can differ with
 * parallelStreams
 */
public class StreamsFindExample {

	public static void main(String... args) {
		List<Student> students = StudentDatabase.getAllStudents();
		Optional<Student> findAnyStudent = students.stream().filter(student -> student.getName().startsWith("J"))
				.findAny();
		System.out.println("Any student name starting with J? " + findAnyStudent.orElse(null));
		Optional<Student> findFirstStudent = students.stream().filter(student -> student.getName().startsWith("j"))
				.findFirst();
		System.out.print("First student name starting with j? ");
		if (findFirstStudent.isPresent()) {
			System.out.print(findFirstStudent.get());
		} else {
			System.out.print("No student found");
		}
	}

}
