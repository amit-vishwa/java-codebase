package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DemoClass {

	public static void main(String[] args) {

		hashMapDemo();
		treeSetDemo();
		reverseString();
		reverseStringNaiveApproach();
	}

	private static void hashMapDemo() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(1, "B");
		System.out.println(map);
	}

	private static void treeSetDemo() {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(1);
		System.out.println(set);
	}

	private static void reverseStringNaiveApproach() {
		List<String> stringList = Arrays.asList("Capgemini");
		String reversed = stringList.stream().map(str -> new StringBuilder(str).reverse()).collect(Collectors.toList())
				.get(0).toString();
		System.out.println(reversed);
	}

	private static void reverseString() {
		String originalString = "Hello World"; // Step 1: Original string

		String reversedString = originalString
				// Step 1 & 2: Convert the string to a stream of characters and collect into a
				// list
				.chars().mapToObj(c -> (char) c).collect(Collectors.toList())
				// Step 3: Reverse the list
				.stream()
//				.sorted(Collections.reverseOrder()) // this will compare characters and sort in reverse
				// Step 4 & 5: Convert the reversed list back into a stream, then collect into a
				// string
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverse(list);
					return list.stream();
				})).map(String::valueOf).collect(Collectors.joining());

		// Step 6: Display the reversed string
		System.out.println("Original string: " + originalString);
		System.out.println("Reversed string: " + reversedString);
		
		List<Character> charList = originalString // String
				.chars() // IntStream
				.mapToObj(c -> (char) c) // Stream<Character>
				.collect(Collectors.toList()); // List<Character>
		Collections.reverse(charList); // Reversed List<Character>
		String rev = charList // List<Character>
				.stream() // Stream<Character>
				.map(ch -> String.valueOf(ch)) // Stream<String>
				.collect(Collectors.joining()); // String
		System.out.println("Original string: " + originalString);
		System.out.println("Reversed string: " + rev);
	}
}
