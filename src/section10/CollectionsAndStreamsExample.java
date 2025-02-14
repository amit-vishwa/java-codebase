package section10;

import java.util.List;
import java.util.stream.Stream;

import data.Student;
import data.StudentDatabase;

/**
 * Difference between collections and streams 
 * - Collections uses eager loading
 * while streams uses lazy loading 
 * - Collections perform external iteration
 * (i.e. we iterate externally)loading while streams performs internal iteration
 * - Collections can be traversed n number of times while streams can be
 * traversed only once
 */
public class CollectionsAndStreamsExample {

	public static void main(String[] args) {
		List<Student> students = StudentDatabase.getAllStudents();
		// Below can traversed multiple times
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
		Stream<Student> studentStream = students.stream();
		studentStream.forEach(System.out::println);
		System.out.println();
		// Below will give error : stream has already been operated upon or closed
		//studentStream.forEach(System.out::println);
	}

}
