package section25;

/**
 * Java 16 feature:
 * 
 * Pattern matching was introduced to remove redundant code. They are of 3 types
 * of patterns - Type, Record and Guarded patterns
 * 
 */
public class PatternMatchingExample {

	public static void main(String args[]) {
		typePatternExample();
		recordPatternExample();
		guardedPatternExample();
	}

	private static void instanceOfExample() {
		Object o = new String("name");
		// before type pattern matching
		if (o instanceof Integer) {
			Integer i = (Integer) o;
			System.out.println("Object is integer with value " + i);
		}
		if (o instanceof String) {
			String str = (String) o;
			System.out.println("Object is string with value " + str);
		}

		// using type pattern matching, added in Java 16
		if (o instanceof Integer i) { // here casting and variable binding is done
			System.out.println("Object is integer with value " + i);
		}
		if (o instanceof String str) {
			System.out.println("Object is string with value " + str);
		}
	}

	/**
	 * Pattern type matching using enhanced switch, added in Java 21
	 */
	private static void switchExpressionExample() {
		Object o = Integer.valueOf(10);
		switch (o) {
		case String str -> System.out.println("Object is string with value " + str);
		case Integer i -> System.out.println("Object is integer with value " + i);
		case null, default -> System.out.println("Not a valid object");
		} // case null is nice addition for switch expression
	}

	/**
	 * Type pattern matching compares the instance, casts the type and create a
	 * binding variable if its a match
	 */
	private static void typePatternExample() {
		instanceOfExample();
		switchExpressionExample();
	}

	/**
	 * Java 21 feature. Instead binding casted variable, direct record can be used
	 * here
	 */
	private static void recordPatternExample() {
		AnimalService service = new AnimalService();
		Animal cat = new Cat("Cat", "Black");
		Animal dog = new Dog("Dog", "White");
		Animal none = null;
		System.out.println(service.retrieveName(cat));
		System.out.println(service.retrieveNameAndColor(dog));
		System.out.println(service.retrieveNameAndColor(none));
	}

	/**
	 * This was introduced in Java 21 and can be used add more conditions on record
	 * fields
	 */
	private static void guardedPatternExample() {
		AnimalService service = new AnimalService();
		Animal cat = new Cat("Cat", "Black");
		Animal dog = new Dog("Dog", null);
		Animal none = null;
		System.out.println(service.retrieveData(cat));
		System.out.println(service.retrieveData(dog));
		System.out.println(service.retrieveData(none));
	}

}
