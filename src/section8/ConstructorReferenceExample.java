package section8;

import java.util.function.Function;
import java.util.function.Supplier;

import data.Student;

/**
 * Must be used with functional interfaces using new keyword Syntax:
 * ClassName::new
 */
public class ConstructorReferenceExample {

	public static void main(String[] args) {
		Supplier<Student> constructorSupplier = Student::new;
		Supplier<Student> lambdaSupplier = () -> new Student();
		System.out.println("Lambda supplier example: " + lambdaSupplier.get());
		System.out.println("Constructor supplier example: " + constructorSupplier.get());

		Function<String, Student> lambdaFunction = (name) -> new Student(name, 0, 0.0, null, null);
		Function<String, Student> constructorFunction = Student::new;
		System.out.println("\nLambda function example: " + lambdaFunction.apply("Amit"));
		System.out.println("Constructor function example: " + constructorFunction.apply("Amit"));
	}

}
