package section9;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Below are some limitations of local variables using lambdas
 * - Value of local variable cannot be update or reassigned 
 * - Functional interface parameter cannot be of names as of local variable 
 * - Same name variable cannot be created inside function interface implementation
 * 
 * Instance variable values can be updated while using lambdas
 */
public class LocalVariableLimitations {
	
	static int x = 5;

	public static void main(String[] args) {
		int i = 3;
		/**
		 * Below statement will give error at line 21:
		 * Lambda expression's parameter i cannot redeclare another local variable defined in an enclosing scope. 
		 * */
		// Consumer<Integer> consumer = (i) -> System.out.println(i);
		Consumer<Integer> consumer = (x) -> System.out.println(x);
		System.out.print("Redeclare instance variable: ");
		consumer.accept(4);
		
		/**
		 * Below statement will give error at line 28:
		 * Local variable i defined in an enclosing scope must be final or effectively final
		 * */
		/*Supplier<Integer> supplier = () -> {
			i++;
			return i;
		};*/
		Supplier<Integer> supplier = () -> {
			x++;
			return x;
		};
		System.out.println("Updating instance variable: " + supplier.get());
		
		/**
		 * Below statement will give error at line 37:
		 * Lambda expression's local variable i cannot redeclare another local variable defined in an enclosing scope. 
		 * */
		/*UnaryOperator<Integer> unaryOperationFunction = (ii) -> {
			int i = 1;
			return ii+i;
		};*/
		UnaryOperator<Integer> unaryOperationFunction = (ii) -> {
			int x = 1;
			return ii+i+x;
		};
		System.out.println("Redeclare instance variable: " + unaryOperationFunction.apply(6));
	}

}
