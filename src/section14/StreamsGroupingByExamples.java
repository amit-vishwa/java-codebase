package section14;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDatabase;

/**
 * Demonstrates the use of groupingBy() using Collectors There are 3 versions of
 * it: i.Takes classifier as input ii.Takes classifier and downstream (i.e.
 * another collector) as inputs iii.Takes classifier, downstream and supplier as
 * inputs
 */
public class StreamsGroupingByExamples {

	public static void main(String... args) {
		List<Student> students = StudentDatabase.getAllStudents();
		groupingByUsingAParameter(students);
		groupingByUsingTwoParameters(students);
		groupingByUsingThreeParameters(students);
		groupingByMaxByMinByExamples(students);
	}

	/**
	 * groupingBy(classifier) i.e. single parameter
	 */
	private static void groupingByUsingAParameter(List<Student> students) {
		Map<Double, List<Student>> gpaMap = students.stream().collect(Collectors.groupingBy(Student::getGpa));
		System.out.println("Group by gpa: " + gpaMap);
		gpaMap.forEach((d, l) -> System.out.println(d + ": " + l));
		System.out.println();
		Map<String, List<Student>> nameMap = students.stream().collect(Collectors.groupingBy(Student::getName));
		System.out.println("Group by name: " + nameMap);
		nameMap.forEach((d, l) -> System.out.println(d + ": " + l));
		System.out.println();
		Map<String, List<Student>> genderMap = students.stream().collect(Collectors.groupingBy(Student::getGender));
		System.out.println("Group by gender: " + genderMap);
		genderMap.forEach((d, l) -> System.out.println(d + ": " + l));
		System.out.println();

		Map<String, List<Student>> customMap = students.stream()
				.collect(Collectors.groupingBy(s -> s.getGpa() >= 3.9 ? "Outstanding" : "Average"));
		System.out.println("Group by cutom input based on gpa: " + customMap);
		customMap.forEach((d, l) -> System.out.println(d + ": " + l));
		System.out.println();
	}

	/**
	 * groupingBy(classifier,collector) i.e. takes two parameters
	 */
	private static void groupingByUsingTwoParameters(List<Student> students) {
		Map<Double, Map<String, List<Student>>> gpaCustomMap = students.stream().collect(Collectors.groupingBy(
				Student::getGpa, Collectors.groupingBy(s -> s.getGpa() >= 3.9 ? "Outstanding" : "Average")));
		System.out.println("Multi-level grouping based on gpa and custom input: " + gpaCustomMap);
		gpaCustomMap.forEach((d, l) -> {
			System.out.print(d + ": ");
			l.forEach((s, li) -> {
				System.out.println(s + ":");
				li.forEach(System.out::println);
			});
		});

		Map<String, Integer> nameNotebooksMap = students.stream()
				.collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getNoteBooks)));
		System.out.println("Student name and sum of notebooks: " + nameNotebooksMap);

		Map<String, Long> genderCountMap = students.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
		System.out.println("Student gender and count: " + genderCountMap);

		Map<Double, Long> gpaCountMap = students.stream()
				.collect(Collectors.groupingBy(Student::getGpa, Collectors.counting()));
		System.out.println("Student gpa and count: " + gpaCountMap);
		System.out.println();
	}

	/**
	 * groupingBy(classifier,return-type,collector) i.e. takes three inputs
	 */
	private static void groupingByUsingThreeParameters(List<Student> students) {
		LinkedHashMap<String, Set<Student>> nameSetMap = students.stream()
				.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));
		System.out.println("Student grouping based on name: " + nameSetMap);
		nameSetMap.forEach((d, l) -> System.out.println(d + ": " + l));
		System.out.println();
	}

	/**
	 * Max and min using groupingBy and collectingAndThen for optional output
	 */
	private static void groupingByMaxByMinByExamples(List<Student> students) {
		Map<Integer, Optional<Student>> maxGpaMap = students.stream() // Stream<Student>
				.collect(Collectors.groupingBy(Student::getGradeLevel, // Group by gradeLevel
						Collectors.maxBy(Comparator.comparing(Student::getGpa)))); // get student with max GPA
		System.out.println("Max student gpa grouping based on grade level: " + maxGpaMap);
		maxGpaMap.forEach((d, l) -> System.out.println(d + ": " + l));
		Map<Integer, Student> minGpaMap = students.stream() // Stream<Student>
				.collect(Collectors.groupingBy(Student::getGradeLevel, // Group by gradeLevel
						Collectors.collectingAndThen( // collect and then get from optional
								Collectors.minBy(Comparator.comparing(Student::getGpa)), // get student with min gpa
								Optional::get)));
		System.out.println("Min student gpa grouping based on grade level: " + minGpaMap);
		minGpaMap.forEach((d, l) -> System.out.println(d + ": " + l));
	}

}
