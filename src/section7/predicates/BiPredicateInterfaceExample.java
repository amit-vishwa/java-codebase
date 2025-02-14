package section7.predicates;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

import data.Student;
import data.StudentDatabase;

public class BiPredicateInterfaceExample {

	public static void main(String[] args) {
		List<Student> students = StudentDatabase.getAllStudents();
		BiPredicate<Integer, Double> biPredicate = (grade, gpa) -> grade >= 3 && gpa >= 3.9;
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out
				.println(name + ", " + activities);
		System.out.println("List of students:");
		students.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
		System.out.println("\nList of students with filters:");
		students.forEach(student -> {
			if (biPredicate.test(student.getGradeLevel(), student.getGpa()))
				biConsumer.accept(student.getName(), student.getActivities());
		});
	}

}
