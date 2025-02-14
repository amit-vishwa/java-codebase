package section5;

import java.util.stream.IntStream;

/**
 * Refer: https://qube.udemy.com/course/modern-java-learn-java-8-features-by-coding-it/learn/lecture/11174940#overview
 * Example: Sum of 100 numbers 
 * */
public class Example1 {
	
	public static void main(String[] args) {
		imperativeExample();
		declarativeExample();
	}

	// Imperative style of programming - focuses on how result is created
	static void imperativeExample() {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("Sum of 100 numbers using imperative style: " + sum);
	}
	

	// Declarative style of programming - focuses on result and not how it is created
	static void declarativeExample() {
		int sum = IntStream.rangeClosed(1, 100).sum();
		System.out.println("Sum of 100 numbers using declarative style: " + sum);		
	}

}
