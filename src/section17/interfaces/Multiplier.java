package section17.interfaces;

import java.util.List;

public interface Multiplier {

	int multiply(List<Integer> numbers);

	// default methods can be added without affecting implementation classes
	default int size(List<Integer> numbers) {
		System.out.println("Inside interface");
		return numbers.size();
	};

	// static methods cannot be overridden
	static boolean isEmpty(List<Integer> numbers) {
		return (numbers == null || (numbers != null && numbers.size() == 0));
	};
	
}
