package section7.consumers;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDatabase;

public class ConsumerInterfaceExample {

	public static void main(String[] args) {
		/**
		 * Refer:
		 * https://qube.udemy.com/course/modern-java-learn-java-8-features-by-coding-it/learn/lecture/10514228#overview
		 * Example: Convert string to upper case
		 */
		consumerExample1();

		/**
		 * Refer:
		 * https://qube.udemy.com/course/modern-java-learn-java-8-features-by-coding-it/learn/lecture/10515332#overview
		 * Example: Multiple use cases of Consumer interface for performing operations
		 * on list
		 */
		consumerExample2();
	}

	static void consumerExample1() {
		Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
		consumer.accept("amit97");
	}

	static void consumerExample2() {
		List<Student> students = StudentDatabase.getAllStudents();
		printStudents(students);
		printStudentNamesAndActivities(students);
		printStudentNamesAndActivitiesUsingCosumerChain(students);
		printStudentNameWithConditions(students);
	}

	private static void printStudents(List<Student> students) {
		Consumer<Student> consumer = (s) -> System.out.println(s.toString());
		students.forEach(consumer);
	}

	private static void printStudentNamesAndActivities(List<Student> students) {
		Consumer<Student> consumer = (s) -> System.out
				.println("Student{name=" + s.getName() + ", activities=" + s.getActivities());
		students.forEach(consumer);
	}

	static Consumer<Student> nameConsumer = (s) -> System.out.print(s.getName() + " ");

	private static void printStudentNamesAndActivitiesUsingCosumerChain(List<Student> students) {
		Consumer<Student> activitiesConsumer = (s) -> System.out.println(s.getActivities());
		students.forEach(nameConsumer.andThen(activitiesConsumer)); // consumer chain using andThen(), can be multiple
	}

	private static void printStudentNameWithConditions(List<Student> students) {
		students.forEach(student -> {
			if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
				nameConsumer.accept(student);
			}
		});
	}

}
