package section8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import data.Student;
import data.StudentDatabase;

/**
 * Syntax: ClassName::methodName
 * */
public class MethodReferenceExample {

	public static void main(String[] args) {

		functionMethodReference();
		consumerMethodReference();
		incompatibleMethodReference();

	}

	private static void functionMethodReference() {
		// TODO Auto-generated method stub
		UnaryOperator<String> toUpperCaseLambda = (name) -> name.toUpperCase();
		Function<String, String> toUpperCaseMethodReference = String::toUpperCase;
		System.out.println("Function interface example using lambda: " + toUpperCaseLambda.apply("amit"));
		System.out.println(
				"Function interface example using method reference: " + toUpperCaseMethodReference.apply("amit"));
	}

	private static void consumerMethodReference() {
		// TODO Auto-generated method stub
		Consumer<Student> consumerLambda = (student) -> System.out.println(student);
		Consumer<Student> consumerMethodReference = System.out::println;
		Consumer<Student> printStudentActivities = Student::printListOfActivities;
		List<Student> students = StudentDatabase.getAllStudents();
		// below both statements are correct
		System.out.println();
		students.forEach(student -> consumerLambda.accept(student));
		System.out.println();
		students.forEach(consumerMethodReference);
		System.out.println();
		students.forEach(printStudentActivities);
	}

	/**
	 * Make incompatible function interface compatible with method reference
	 */
	private static void incompatibleMethodReference() {
		// TODO Auto-generated method stub
		Predicate<Student> lambdaPredicate = (student) -> student.getGradeLevel() >= 2;
		Predicate<Student> methodReferencePredicate = MethodReferenceExample::gradeLevelPredicate;
		System.out.println("\nIncompatible lambda predicate example: "
				+ lambdaPredicate.test(StudentDatabase.studentSupplier.get()));
		System.out.println("Compatible method reference predicate example: "
				+ methodReferencePredicate.test(StudentDatabase.studentSupplier.get()));
	}

	private static boolean gradeLevelPredicate(Student student) {
		return student.getGradeLevel() >= 3;
	}

}
