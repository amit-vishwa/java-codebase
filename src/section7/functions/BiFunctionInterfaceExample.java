package section7.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import data.Student;
import data.StudentDatabase;

public class BiFunctionInterfaceExample {

	public static void main(String[] args) {
		studentBiFunctionExample();
	}

	private static void studentBiFunctionExample() {
		Predicate<Student> studentsByGpa = (student) -> student.getGpa() >= 3.9;
		BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, predicate) -> {
			Map<String, Double> map = new HashMap<>();
			students.forEach(student -> {
				if (predicate.test(student)) {
					map.put(student.getName(), student.getGpa());
				}
			});
			return map;
		};
		System.out.println("Bi function example: " + biFunction.apply(StudentDatabase.getAllStudents(), studentsByGpa));
	}

}
