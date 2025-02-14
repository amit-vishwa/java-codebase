package section20;

import java.util.List;
import java.util.Map;

/**
 * Java 9 feature: Local Variable Type Inference i.e. var can be used in place
 * of data types. var is not a reserved keyword
 **/
public class VarKeywordExample {

	public static void main(String... args) {
		varUsage();
		limitations();
	}

	private static String transformName(String name) {
		return name.toUpperCase().trim().concat(" Sir!");
	}

	private static void varUsage() {
		var name = "Amit";
		var list = List.of("Sumit", "Namit");
		System.out.println(name);
		System.out.println(list);
		for (var element : list) {
			System.out.println(element);
		}
		var map = Map.ofEntries(Map.entry("names", List.of("Alex", "Adam")));
		System.out.println(map);
		map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
		map.forEach((var key, var value) -> System.out.println("Key: " + key + ", Value: " + value));
		var transformedName = transformName(name);
		System.out.println(transformedName);
	}

	/**
	 * 1.var cannot be used as instance variable, it should be local 2.It cannot be
	 * used as method arguments 3.It cannot have null value, as null can be of any
	 * type 4.The var value cannot be re-assigned to different data type.
	 */
	private static void limitations() {
		// 1.It can be used as local variable
		var var = 0;
		// 3.It cannot have null value, as null can be of any type
//		var a = null;
		// 4.The var value cannot be re-assigned to different data type.
//		var = "S";
		var = 10;
		System.out.println(var);
	}

	// 1.var cannot be used as instance variable or class property
//	private var val = 0;

	// 2.It cannot be used as method arguments
//	private static void example(var abv) {	}

}
