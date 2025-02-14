package section11.terminal;

import java.util.List;

import data.Student;
import data.StudentDatabase;

/**
 * The program demonstrates the use of anyMatch(), allMatch() and noneMatch()
 * They return boolean values
 */
public class StreamsMatchExample {

	public static void main(String[] args) {
		List<Student> students = StudentDatabase.getAllStudents();
		boolean isAnyMatch = students.stream().anyMatch(stud -> stud.getGpa() >= 4.0);
		boolean areAllMatch = students.stream().allMatch(stud -> stud.getGpa() >= 4.0);
		boolean isNoneMatch = students.stream().noneMatch(stud -> stud.getGpa() > 4.0);
		System.out.println("Is any student have gpa greater than or equal to 4.0? " + isAnyMatch);
		System.out.println("Are all students have gpa greater than or equal to 4.0? " + areAllMatch);
		System.out.println("Are all students have gpa less than or equal to 4.0? " + isNoneMatch);
	}

}
