package section17;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Default methods are introduced in Java 8, prior only abstract methods were
 * there that required implementation. Explore various default methods from List
 * interface
 */
public class DefaultMethodsExample {

	public static void main(String[] args) {

		List<String> nameList = Arrays.asList("Ramit", "Amit", "Sumit", "Namit", "Pramit");
		System.out.println("Name list: " + nameList);
		Collections.sort(nameList); // static method from Collections class
		System.out.println("Sorted name list using Collections.sort(): " + nameList);
		List<String> newNameList = Arrays.asList("Ramit", "Amit", "Sumit", "Namit", "Pramit");
		newNameList.sort(Comparator.naturalOrder()); // default method from List interface
		System.out.println("Sorted name list using default function list.sort(): " + newNameList);
		nameList.sort(Comparator.reverseOrder()); // default method from List interface
		System.out.println("Reverse sorted name list using Collections.sort(): " + nameList);
	}

}
