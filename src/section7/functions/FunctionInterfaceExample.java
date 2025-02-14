package section7.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;

import data.Student;
import data.StudentDatabase;

public class FunctionInterfaceExample {

	public static void main(String... args) {

		simpleExamples();
		studentFunctionExample();

	}

	private static void simpleExamples() {
		// TODO Auto-generated method stub
		Function<String, String> functionUpperCase = (name) -> name.toUpperCase();
		Function<String, String> functionConcat = (name) -> name.concat(" default");
		System.out.println("Upper case function example: " + functionUpperCase.apply("Hello"));
		System.out.println("Concat function example: " + functionConcat.apply("Hello"));
		// andThen() - Executes in order
		System.out.println("Upper case and then concat function example: "
				+ functionUpperCase.andThen(functionConcat).apply("Hello"));
		// compose() - Executes parameter first then calling function
		System.out.println("Upper case and compose concat function example: "
				+ functionUpperCase.compose(functionConcat).apply("Hello"));
	}

	private static void studentFunctionExample() {
		BiConsumer<Map<String, Double>, Student> biConsumer = (map, student) -> map.put(student.getName(),
				student.getGpa());
		BiPredicate<String, Double> biPredicate = (name, gpa) -> name.startsWith("J") && gpa > 3.8;
		Function<List<Student>, Map<String, Double>> function = (students) -> {
			Map<String, Double> studentGpaMap = new HashMap<>();
			students.forEach(student -> {
				if (biPredicate.test(student.getName(), student.getGpa())) {
					biConsumer.accept(studentGpaMap, student);
				}
			});
//			students.forEach(student -> biConsumer.accept(studentGpaMap, student));
//			students.forEach(student -> {
//				studentGpaMap.put(student.getName(), student.getGpa());
//			});
			return studentGpaMap;
		};
		System.out.println("Student name with J having GPA > 3.8: " + function.apply(StudentDatabase.getAllStudents()));
	}

}
