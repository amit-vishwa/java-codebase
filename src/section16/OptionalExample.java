package section16;

import java.util.Optional;

import data.Bike;
import data.Student;
import data.StudentDatabase;

public class OptionalExample {

	public static void main(String[] args) {
		displayStudentNameLength();
		optionalElseMethods();
		optionalMap();
		optionalFilter();
		optionalFlatMap();
	}

	private static String getStudentName() {
//		Student student = null;
		Student student = StudentDatabase.studentSupplier.get();
		return student != null ? student.getName() : null;
	}

	private static Optional<String> getStudentNameUsingOptional() {
		// of() cannot be used with nullable values, it always expects a not null value
		Optional<Student> optionalStudent = Optional.of(StudentDatabase.studentSupplier.get());
		// ofNullable() can work with nullable values, null can be passed as parameter
//		Optional<Student> optionalStudent = Optional.ofNullable(null); 
		return optionalStudent.isPresent() ? optionalStudent.map(Student::getName) : Optional.empty(); // empty() can be
																										// used for null
																										// when return
																										// type is
																										// optional
	}

	/**
	 * Demonstrates the use of of(), ofNullable(), empty(), isPresent()
	 */
	private static void displayStudentNameLength() {
		String studentName = getStudentName();
		int length = studentName != null ? studentName.length() : 0;
		System.out.println("Length of student name: " + length);
		Optional<String> optionalStudentName = getStudentNameUsingOptional();
		int optionalLength = optionalStudentName.isPresent() ? optionalStudentName.get().length() : 0;
		System.out.println("Length of student name using optional: " + optionalLength);
	}

	/**
	 * Demonstrates the use of orElse(), orElseGet(), orElseThrow()
	 */
	private static void optionalElseMethods() {
//		Optional<Student> optionalStudent = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		Optional<Student> optionalStudent = Optional.ofNullable(null); // returns Optional.empty()
		String name = optionalStudent.map(Student::getName).orElse("Default");
		System.out.println("Name using orElse(): " + name);
		String name2 = optionalStudent.map(Student::getName).orElseGet(() -> "Another name");
		System.out.println("Name using orElseGet(): " + name2);
		try {
			String name3 = optionalStudent.map(Student::getName)
					.orElseThrow(() -> new Exception("Exception thrown for null"));
			System.out.println("Name using orElseThrow(): " + name3);
		} catch (Exception ex) {
			System.out.println("Error message: " + ex.getMessage());
		}
	}

	private static void optionalMap() {
		Optional<Student> optionalStudent = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		optionalStudent.filter(student -> student.getGpa() >= 4.0) // filters values
				.map(student -> student.getName()) // converts to string
				.ifPresent(System.out::println); // if present, prints first value
	}

	private static void optionalFilter() {
		Optional<Student> optionalStudent = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		optionalStudent.filter(student -> student.getGpa() > 3.0) // filters values
				.ifPresent(System.out::println); // if present, prints first value
	}

	/**
	 * FlatMap can be used with optional, if optional is used inside optional
	 * */
	private static void optionalFlatMap() {
		Optional<Student> optionalStudent = StudentDatabase.getOptionalStudent();
		optionalStudent // Optional<Student>
				.filter(student -> student.getGpa() >= 3.9) // Optional<Student <Optional<Bike> >>
				.flatMap(Student::getBike) // Optional<Bike>
				.map(Bike::getName) // Optional<String>
				.ifPresent(System.out::println); // if found then print name
	}

}
