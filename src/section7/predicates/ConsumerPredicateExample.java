package section7.predicates;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import data.Student;
import data.StudentDatabase;

public class ConsumerPredicateExample {

	public static void main(String... args) {
		List<Student> students = StudentDatabase.getAllStudents();
		printStudentNameAndActivities(students);
	}

	private static void printStudentNameAndActivities(List<Student> students) {
		Predicate<Student> studentsByGpa = (student) -> student.getGpa() >= 3.9;
		Predicate<Student> studentsByGrade = (student) -> student.getGradeLevel() >= 3;
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out
				.println("Name: " + name + ", activities: " + activities);
		Consumer<Student> consumer = (student) -> {
			if (studentsByGpa.and(studentsByGrade).test(student)) {
				biConsumer.accept(student.getName(), student.getActivities());
			}
		};
		students.forEach(consumer);
	}

}
