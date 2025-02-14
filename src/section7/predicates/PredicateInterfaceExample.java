package section7.predicates;

import java.util.List;
import java.util.function.Predicate;

import data.Student;
import data.StudentDatabase;

public class PredicateInterfaceExample {

	public static void main(String... args) {

		simplePredicateExample();
		differentPredicateMethods();
		studentPredicateExample();

	}

	private static void simplePredicateExample() {
		// TODO Auto-generated method stub
		Predicate<Integer> predicate = (i) -> i % 2 == 0;
		System.out.println(predicate.test(01));
	}

	private static void differentPredicateMethods() {
		// TODO Auto-generated method stub
		System.out.println("\nPredicate OR:");
		predicateOr();
		System.out.println("\nPredicate AND:");
		predicateAnd();
		System.out.println("\nPredicate NEGATE:");
		predicateNegate();
	}

	private static void predicateOr() {
		// TODO Auto-generated method stub
		Predicate<Integer> predicate = (i) -> i % 2 == 0;
		Predicate<Integer> predicate2 = (i) -> i > 20;
		System.out.println("OR of " + predicate.test(23) + " and " + predicate2.test(23) + " is "
				+ predicate.or(predicate2).test(23));
	}

	private static void predicateAnd() {
		// TODO Auto-generated method stub
		Predicate<Integer> predicate = (i) -> i % 2 == 0;
		Predicate<Integer> predicate2 = (i) -> i > 20;
		System.out.println("AND of " + predicate.test(23) + " and " + predicate2.test(23) + " is "
				+ predicate.and(predicate2).test(23));

	}

	private static void predicateNegate() {
		// TODO Auto-generated method stub
		Predicate<Integer> predicate = (i) -> i % 2 == 0;
		System.out.println("Negation of " + predicate.test(20) + " is " + predicate.negate().test(20));
	}

	private static void studentPredicateExample() {
		List<Student> students = StudentDatabase.getAllStudents();
		Predicate<Student> studentsByGpa = (student) -> student.getGpa() >= 3.9;
		Predicate<Student> studentsByGrade = (student) -> student.getGradeLevel() >= 3;
		Predicate<Student> studentsByGender = (student) -> student.getGender().equalsIgnoreCase("male");
		System.out.println("\nStudents by GPA:");
		students.forEach(student -> {
			if (studentsByGpa.test(student)) {
				System.out.println(student);
			}
		});
		System.out.println("Students by Grade:");
		students.forEach(student -> {
			if (studentsByGrade.test(student)) {
				System.out.println(student);
			}
		});
		System.out.println("Students by GPA or Grade and Gender:");
		students.forEach(student -> {
			if (studentsByGpa.or(studentsByGrade).and(studentsByGender).test(student)) {
				System.out.println(student);
			}
		});
	}
}
