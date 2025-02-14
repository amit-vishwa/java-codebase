package section7.consumers;

import java.util.List;
import java.util.function.BiConsumer;

import data.Student;
import data.StudentDatabase;

/**
 * Refer:
 * https://qube.udemy.com/course/modern-java-learn-java-8-features-by-coding-it/learn/lecture/10525390#overview
 * Example: Can be used to perform operations on 2 inputs and print result
 */
public class BiConsumerInterfaceExample {

	public static void main(String args[]) {
		simpleBiConsumerExamples();
		printStudentNamesAndActivities();
	}

	private static void simpleBiConsumerExamples() {
		// TODO Auto-generated method stub
		BiConsumer<String, String> consumer = (a, b) -> System.out.println("a = " + a + ", b = " + b);
		consumer.accept("A", "B");
		BiConsumer<Integer, Integer> mulConsumer = (a, b) -> System.out.println("a*b = " + a * b);
		BiConsumer<Integer, Integer> divConsumer = (a, b) -> System.out.println("a/b = " + a / b);
		mulConsumer.andThen(divConsumer).accept(10, 5);
	}

	private static void printStudentNamesAndActivities() {
		List<Student> students = StudentDatabase.getAllStudents();
		BiConsumer<String, List<String>> consumer = (name, activities) -> System.out
				.println("Name: " + name + ", activities: " + activities);
		students.forEach(student -> consumer.accept(student.getName(), student.getActivities()));
	}

}
