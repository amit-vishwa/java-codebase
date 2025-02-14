package section17.interfaces;

import java.util.Arrays;
import java.util.List;

public class InterfaceExample {
	
	public static void main(String... args) {
		// we can use autowired functionality from spring-boot for below
		Multiplier multiplier = new MultiplierImpl();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("Numbers: " + numbers);
		System.out.println("List size: " + multiplier.size(numbers));
		System.out.println("Is list empty: " + Multiplier.isEmpty(numbers));
		System.out.println("Multiplication: " + multiplier.multiply(numbers));
	}

}
