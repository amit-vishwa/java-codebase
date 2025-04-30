package youtube.java8.functionalinterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Predicate is a functional interface. It is a boolean values function.
 *
 * Functional interfaces are interface with single abstract method.
 * Functional interfaces can have multiple default and static methods.
 * */
public class PredicateExample {

    public static void main(String[] args) {
        simplePredicateExample();
        biPredicateExample();
    }

    private static void simplePredicateExample() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(6) + ", " + isEven.test(9));

        Predicate<String> isStartsWithA = word -> word.startsWith("A");
        Predicate<String> isEndsWithA = word -> word.endsWith("A");
        System.out.println(isEndsWithA.test("Amit") + ", " + isStartsWithA.test("Amit"));
        System.out.println("Starts and ends with A: " + isStartsWithA.and(isEndsWithA).test("AMITA"));
    }

    private static void biPredicateExample() {
        BiPredicate<Integer, String> isEqualLength = (len,str) -> str.length() == len;
        Integer length = 10;
        String string = "Fantastics";
        System.out.println("Length: " + length + ", String: " + string);
        System.out.println(isEqualLength.test(length,string));
    }

}
