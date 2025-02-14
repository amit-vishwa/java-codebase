package section7.suppliers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import data.Student;
import data.StudentDatabase;

/**
 * Acts opposite to Consumer interface, doesn't take any input and returns an
 * output
 */
public class SupplierInterfaceExample {

	public static void main(String[] args) {
		Supplier<Student> studentSupplier = () -> new Student("Adam", 2, 4.0, "male",
				Arrays.asList("swimming", "basketball", "volleyball"));
		Supplier<List<Student>> studentsSupplier = () -> StudentDatabase.getAllStudents();
		System.out.println("Student data:");
		System.out.println(studentSupplier.get());
		System.out.println("Student list data:");
		System.out.println(studentsSupplier.get());
	}

}
