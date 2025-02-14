package section7.functions;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * It extends Function interface and can be used when both input and output are
 * of same types
 */
public class BinaryOperatorInterfaceExample {

	public static void main(String args[]) {

		simpleExample();
		minMaxExample();

	}

	private static void simpleExample() {
		// TODO Auto-generated method stub
		BinaryOperator<String> binaryOperator = (name1, name2) -> name1.concat(name2).toUpperCase();
		System.out
				.println("Simple unary operator interface function use case: " + binaryOperator.apply("hello", " amit"));
	}

	private static void minMaxExample() {
		// TODO Auto-generated method stub
		Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
		BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
		BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
		System.out.println("Binary operator max by example: " + maxBy.apply(4, 5));
		System.out.println("Binary operator min by example: " + minBy.apply(4, 5));
	}

}
