package section11.intermediate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

public class StreamsComparatorExample {

	public static void main(String... args) {
		List<Student> students = StudentDatabase.getAllStudents();
		diplayStudentsSortedByName(students);
		diplayStudentsSortedByGPA(students);
		diplayStudentsReverseSortedByGPA(students);
	}

	private static void diplayStudentsSortedByName(List<Student> students) {
		// TODO Auto-generated method stub
		List<Student> sortedStudentList = students.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());
		System.out.println("1.Sorted student list by name using comparator implementation: ");
		sortedStudentList.forEach(student -> System.out.println(student));

		List<Student> sortedStudents = students.stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		System.out.println("\n2.Sorted student list by name using comparator method reference: ");
		sortedStudents.forEach(System.out::println);
	}

	private static void diplayStudentsSortedByGPA(List<Student> students) {
		// TODO Auto-generated method stub
		List<Student> sortedStudents = students.stream().sorted(Comparator.comparing(Student::getGpa))
				.collect(Collectors.toList());
		System.out.println("\n3.Sorted student list by gpa using comparator method reference: ");
		sortedStudents.forEach(System.out::println);
	}

	private static void diplayStudentsReverseSortedByGPA(List<Student> students) {
		// TODO Auto-generated method stub
		List<Student> reverseSortedStudents = students.stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed()) // reverse sorting
				.collect(Collectors.toList());
		System.out.println("\n4.Reverse sorted student list by gpa using comparator method reference: ");
		reverseSortedStudents.forEach(System.out::println);

		List<Student> sortedStudents = students.stream()
				.sorted((o1,o2)->{
					int gradeDiff = o2.getGradeLevel()-o1.getGradeLevel();
					if(gradeDiff != 0) return gradeDiff;
					// if grades are same then perform sort for names
					return o1.getName().compareTo(o2.getName());
				})
				.collect(Collectors.toList());
		System.out.println("\n5.Reverse sorted list by grade and sorted by name using comparator implementation: ");
		sortedStudents.forEach(System.out::println);
	}

}
