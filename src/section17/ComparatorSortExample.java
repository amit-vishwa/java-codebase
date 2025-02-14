package section17;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDatabase;

public class ComparatorSortExample {

	public static void main(String[] args) {
		comparatorSortExample1();
		comparatorChainingWithNullValues();
	}

	private static Consumer<Student> consumer = (student) -> System.out.println(student);

	private static void comparatorSortExample1() {
		List<Student> students = StudentDatabase.getAllStudents();
		System.out.println("Before sort:");
		students.forEach(consumer);
//		students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
//		students.sort(Comparator.comparing(Student::getName));
		sortByName(students);
		sortByGpa(students);
		comparatorChaining(students);
	}

	private static void sortByName(List<Student> students) {
		Comparator<Student> compareByName = Comparator.comparing(Student::getName);
		students.sort(compareByName);
		System.out.println("\nAfter sort by name:");
		students.forEach(consumer);
	}

	private static void sortByGpa(List<Student> students) {
		// comparingDouble can be used instead of comparing for effective sorting
		Comparator<Student> compareByGpa = Comparator.comparingDouble(Student::getGpa);
		students.sort(compareByGpa);
		System.out.println("\nAfter sort by gpa:");
		students.forEach(consumer);
	}

	private static Comparator<Student> compareByGender = Comparator.comparing(Student::getGender);
	private static Comparator<Student> compareByGrade = Comparator.comparing(Student::getGradeLevel);

	private static void comparatorChaining(List<Student> students) {
		students.sort(compareByGender.thenComparing(compareByGrade));
		System.out.println("\nAfter sort by gender and grade level:");
		students.forEach(consumer);
	}

	private static void comparatorChainingWithNullValues() {
		List<Student> students = StudentDatabase.getAllStudents();
		Comparator<Student> comparatorNullFirst = Comparator.nullsFirst(compareByGender.thenComparing(compareByGrade));
		students.sort(comparatorNullFirst);
		System.out.println("\nAfter sort by gender and grade level with null first:");
		students.forEach(consumer);
		Comparator<Student> comparatorNullLast = Comparator.nullsLast(compareByGender.thenComparing(compareByGrade));
		students.sort(comparatorNullLast);
		System.out.println("\nAfter sort by gender and grade level with null last:");
		students.forEach(consumer);
	}

}
