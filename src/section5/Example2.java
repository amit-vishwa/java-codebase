package section5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Refer: https://qube.udemy.com/course/modern-java-learn-java-8-features-by-coding-it/learn/lecture/11174942#overview
 * Example: Remove duplicates from list of integers
 * */
public class Example2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,23,4,6,1,7,7,8,9,0,0,3,4);
		System.out.println("List: " + list);
		imperativeExample(list);
		declarativeExample(list);
	}

	// Imperative style of programming - focuses on how result is created
	static void imperativeExample(List<Integer> list) {
		List<Integer> uniqueList = new ArrayList<>();
		list.forEach(integer -> {
			if(!uniqueList.contains(integer)) {
				uniqueList.add(integer);
			}
		});
		System.out.println("Unique list using imperative style: " + uniqueList);
	}
	

	// Declarative style of programming - focuses on result and not how it is created
	static void declarativeExample(List<Integer> list) {
		List<Integer> uniqueList = list.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique list using declarative style: " + uniqueList);	
	}
	
}
