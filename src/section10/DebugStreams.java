package section10;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * peek() can be used to debug streams
 */
public class DebugStreams {

	public static void main(String[] args) {
		Predicate<Student> studentWithGpa = (student) -> student.getGpa() >= 3.9;
		Predicate<Student> studentWithGrade = (student) -> student.getGradeLevel() >= 3;
//		Map<String, List<String>> studentNameAndActivities = StudentDatabase.getAllStudents().parallelStream()
		Map<String, List<String>> studentNameAndActivities = StudentDatabase.getAllStudents().stream()
				.peek(student -> System.out.println("No filter: "+student))
				.filter(studentWithGrade)
				.peek(student -> System.out.println("Filter 1: "+student))
				.filter(studentWithGpa)
				.peek(student -> System.out.println("Filter 2: "+student))
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		System.out.println(studentNameAndActivities);
	}

}
