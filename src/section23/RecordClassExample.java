package section23;

import java.math.BigDecimal;

/**
 * Java 17 feature. Keyword record is used instead of class. They are immutable
 * data holders and intended to hold data. They are final, no inheritance is
 * supported. They have auto-generated equals, hashCode and toString functions.
 */
public class RecordClassExample {

	public static void main(String[] args) {
		simpleRecordClassExample();
		validateRecordClass();
		recordCustomConstructor();
		recordEqualityCheck();
	}

	private static void simpleRecordClassExample() {
		// calling Canonical constructor to populate final values
		Product product = new Product("Iphone", BigDecimal.valueOf(45.0), "Electronics");
		System.out.println(product);
		// we can only read values once it is defined, no updates can be done
		System.out.println(product.name());
		System.out.println(product.type());
		System.out.println(product.cost());
	}

	private static void validateRecordClass() {
		try {
//			Product samsung = new Product("", BigDecimal.valueOf(100), "Electronics");
//			Product samsung = new Product("Samsung", BigDecimal.valueOf(0), "Electronics");
			Product samsung = new Product("Samsung", BigDecimal.valueOf(100), "Electronics");
			System.out.println(samsung);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Example for custom constructor where less arguments are passed, so default
	 * values are provided to remaining fields
	 */
	private static void recordCustomConstructor() {
		Product mi = new Product("MI", BigDecimal.valueOf(120.34));
		System.out.println(mi);
	}

	/**
	 * Check for equality of record object using equals method
	 */
	private static void recordEqualityCheck() {
		Product mi = new Product("MI", BigDecimal.valueOf(120.34));
		Product redmi = new Product("MI", BigDecimal.valueOf(120.34));
		System.out.println("Are redmi and mi equal? " + mi.equals(redmi));
	}

}
