package section6;

import java.util.Comparator;

/**
 * Refer:
 * https://qube.udemy.com/course/modern-java-learn-java-8-features-by-coding-it/learn/lecture/10462698#overview
 * Example: Implementing Comparator functional interface using Java 8 and prior
 * versions
 */
public class ComparatorExample implements Comparator<Integer> {

	@Override
	public int compare(Integer obj1, Integer obj2) {
		return obj1.compareTo(obj2);
	}

	public static void main(String[] args) {
		implementComparatorUsingClassInstance();
		implementComparatorUsingAnnonymousClass();
		implementComparatorUsingLambdaExpression();
		implementComparatorUsingLambdaExpressionWithoutType();
	}

	private static void implementComparatorUsingClassInstance() {
		// TODO Auto-generated method stub
		ComparatorExample obj = new ComparatorExample();
		System.out.println("1.Implemented Comparator using class instance: " + obj.compare(1, 5));
	}

	private static void implementComparatorUsingAnnonymousClass() {
		// TODO Auto-generated method stub
		Comparator<Integer> obj = new Comparator<Integer>() {// Annonymous class with type
			@Override
			public int compare(Integer obj1, Integer obj2) {
				return obj1.compareTo(obj2);
			}
		};
		System.out.println("2.Implemented Comparator using Annonymous class: " + obj.compare(5, 5));
	}

	private static void implementComparatorUsingLambdaExpression() {
		// TODO Auto-generated method stub
		Comparator<Integer> obj = (Integer obj1, Integer obj2) -> obj1.compareTo(obj2);
		System.out.println("3.Implemented Comparator using Lambda expression: " + obj.compare(6, 5));
	}

	private static void implementComparatorUsingLambdaExpressionWithoutType() {
		// TODO Auto-generated method stub
		Comparator<Integer> obj = (obj1, obj2) -> obj1.compareTo(obj2);
		System.out.println("4.Implemented Comparator using Lambda expression without type: " + obj.compare(1, 5));
	}

}
