package section11.intermediate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * It converts from one type to another or can be used to return same type
 */
public class StreamsMapExample {

	public static void main(String[] args) {
		displayListOfStudentNames();
	}

	private static void displayListOfStudentNames() {
		// TODO Auto-generated method stub
		List<Student> students = StudentDatabase.getAllStudents();
		List<String> studentNamesList = students // List<Student>
				.stream() // Stream<Student>
				// fetches student name and converts stream of Student to String
				.map(Student::getName) // Stream<String>
				.collect(Collectors.toList()); // List<String>
		System.out.println("Student names list: " + studentNamesList);
		
		Set<String> studentNamesSet = students // List<Student>
				.stream() // Stream<Student>
				.map(Student::getName) // Stream<String>
				// upperCase operation on each input from above Stream of String
				.map(String::toUpperCase) // Stream<String> 
				.collect(Collectors.toSet()); // Set<String>
		System.out.println("Student names set: " + studentNamesSet);
	}
}
