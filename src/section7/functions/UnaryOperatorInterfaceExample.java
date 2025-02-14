package section7.functions;

import java.util.function.UnaryOperator;

/**
 * It extends Function interface and can be used when both input and output are
 * of same types
 */
public class UnaryOperatorInterfaceExample {

	public static void main(String args[]) {
		UnaryOperator<String> unaryOperator = (name) -> name.toUpperCase();
		System.out.print("Simple unary operator interface function use case: " + unaryOperator.apply("hello"));
	}

}
