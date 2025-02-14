package section17.interfaces;

import java.util.List;

public class MultiplierImpl implements Multiplier {

	@Override
	public int multiply(List<Integer> numbers) {
		return numbers.stream().reduce(1, (a, b) -> a * b);
	}

//	@Override // this will take precedence over size() from interface
//	public int size(List<Integer> numbers) {
//		System.out.println("Inside implementation");
//		return numbers.size();
//	}

}
