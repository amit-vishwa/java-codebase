package youtube.streams.references;

import java.util.Arrays;
import java.util.List;

/**
 * Method reference was introduced in Java 8 to use method without invoking, and in place of lambda expression.
 * It can be used for a single statement as an alternative to lambda expression.
 * It cannot be used with Predicate.
 * */
public class MethodReferenceExample {

    public static void main(String[] args) {
        simpleExample();
    }

    private static void simpleExample(){
        List<String> students = Arrays.asList("Alex","Bob","Charlie");
        students.forEach(name -> System.out.println(name)); // traditional lambda expression
        students.forEach(System.out::println); // method reference
    }

}
