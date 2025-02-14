package section11.intermediate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * Works similar to map, however it also performs operations on stream of
 * multiple elements like Stream<List>, Stream<Arrays>,etc
 * 
 * Examples include use of Map, FlatMap, Count, Sorted, Distinct operations
 * 
 * Stateless functions - they need not to know about previous processed values (E.g map, filter, etc)
 * Stateful functions - they need to know about previous processed values (E.g skip,limit,distinct,sorted)]
 * Only intermediate functions can be Stateless and Stateful functions
 */
public class StreamsFlatMapExample {

	public static void main(String[] args) {
		List<Student> students = StudentDatabase.getAllStudents();
		displayListOfStudentActivitiesUsingMap(students);
		displayListOfStudentActivitiesUsingFlatMap(students);
		displayListOfDistinctStudentActivities(students);
		displayListOfDistinctStudentActivitiesCount(students);
		displaySortedListOfDistinctStudentActivities(students);
	}

	private static void displayListOfStudentActivitiesUsingMap(List<Student> students) {
		// TODO Auto-generated method stub
		List<List<String>> listOfStudentActivitiesList = students // List<Student>
				.stream() // Stream<Student>
				// fetches student activities and converts stream of Student to stream of List of String
				.map(Student::getActivities) // Stream<List<String>>
				.collect(Collectors.toList()); // List<List<String>>
		System.out.println("1.List of student activities list using Map: " + listOfStudentActivitiesList);		
	}

	private static List<String> displayListOfStudentActivitiesUsingFlatMap(List<Student> students) {
		// TODO Auto-generated method stub
		List<String> studentActivitiesList = students // List<Student>
				.stream() // Stream<Student>
				// fetches student activities and converts stream of Student to stream of List of String
				.map(Student::getActivities) //  Stream<List<String>> // stateless i.e. not need to know previous values
				// fetches List of String and converts it to stream of String
				.flatMap(List::stream) //  Stream<String> // stateless i.e. not need to know previous values
				.collect(Collectors.toList()); // List<String>
		System.out.println("2.Student activities list using FlatMap: " + studentActivitiesList);
		return studentActivitiesList;
	}

	private static List<String> displayListOfDistinctStudentActivities(List<Student> students) {
		// TODO Auto-generated method stub
		List<String> studentActivitiesList = displayListOfStudentActivitiesUsingFlatMap(students).stream()
				.distinct() // excluding duplicate activities // stateful i.e. it should know previous values
				.collect(Collectors.toList()); // List<String>
		System.out.println("3.Student distinct activities list using FlatMap: " + studentActivitiesList);
		return studentActivitiesList;		
	}

	private static void displayListOfDistinctStudentActivitiesCount(List<Student> students) {
		// TODO Auto-generated method stub
		long studentActivitiesCount = displayListOfDistinctStudentActivities(students).stream()
				.count(); // long
		System.out.println("4.Student distinct activities list count: " + studentActivitiesCount);
	}

	private static void displaySortedListOfDistinctStudentActivities(List<Student> students) {
		// TODO Auto-generated method stub
		List<String> sortedStudentActivitiesList = displayListOfDistinctStudentActivities(students).stream()
				.sorted() // performing sort // stateful i.e. it should know previous values
				.collect(Collectors.toList()); // List<String>
		System.out.println("5.Sorted Student distinct activities list: " + sortedStudentActivitiesList);
		
		List<String> reverseSortedStudentActivitiesList = sortedStudentActivitiesList.stream()
				.sorted(Collections.reverseOrder()) // performing reverse sort // stateful i.e. it should know previous values
				.collect(Collectors.toList()); // List<String>
		System.out.println("6.Reverse sorted Student distinct activities list: " + reverseSortedStudentActivitiesList);
	}
	
}
