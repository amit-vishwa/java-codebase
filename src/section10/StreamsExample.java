package section10;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * Streams are nothing sequence of list or collections of I/O data
 * Streams are used on collections to perform some operations, it can be used
 * with I/O
 * It converts the list to stream first, then performs intermediate operations
 * and then perform terminal operation.
 * It follows lazy loading concept and terminal operation will invoke intermediate operations
 */
public class StreamsExample {

	public static void main(String[] args) {

		List<Student> students = StudentDatabase.getAllStudents();
		simpleStreamsExample(students);
		streamsWithFilter(students);
		streamsWithMap(students);
	}

	private static void simpleStreamsExample(List<Student> students) {
		// TODO Auto-generated method stub
		List<String> studentNameAndActivities = students.stream().map(Student::getName).collect(Collectors.toList());
		System.out.println(studentNameAndActivities);
	}

	private static void streamsWithFilter(List<Student> students) {
		// TODO Auto-generated method stub
		Predicate<Student> studentWithGpa = (student) -> student.getGpa() >= 3.9;
		Predicate<Student> studentWithGrade = (student) -> student.getGradeLevel() >= 3;
		Map<String, List<String>> studentNameAndActivities = students.stream().filter(studentWithGpa)
				.filter(studentWithGrade).collect(Collectors.toMap(Student::getName, Student::getActivities));
		System.out.println(studentNameAndActivities);
	}

	private static void streamsWithMap(List<Student> students) {
		// TODO Auto-generated method stub
		UnaryOperator<Student> function = (student) -> {
			if (student.getName().startsWith("J")) {
				return student;
			}
			return null;
		};
		Map<String, List<String>> studentNameAndActivities = students.stream().map(function).filter(x -> x != null)
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		System.out.println(studentNameAndActivities);
	}

}
