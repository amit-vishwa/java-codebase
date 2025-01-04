package tutorial.java.lambdaexpression.methodreferences;

import java.util.*;
import java.util.function.*;

/**
 * Refer: https://www.geeksforgeeks.org/method-references-in-java-with-examples/?ref=next_article
 *
 * Type 4: Constructor method reference
 * If a Lambda expression is like:
 * // If a lambda expression just create an object
 * (args) -> new ClassName(args)
 *
 * Then method reference is like:
 * // Shorthand if a lambda expression just create an object
 * ClassName::new
 *
 * Conclusion: As mentioned above, if a lambda expression only calls an existing method then using method reference can make code
 * more readable and clear. There are many more things we can do with Java8 Lambda and Method References while using Java streams.
 * */
public class ConstructorMethodReference {

    // Get List of objects of given
    // length and Supplier
    public static <T> List<T> getObjectList(int length, Supplier<T> objectSupply)
    {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < length; i++)
            list.add(objectSupply.get());
        return list;
    }

    public static void main(String[] args)
    {

        // Get 10 person by supplying
        // person supplier, Supplier is
        // created by person constructor
        // reference
        List<Persons> personList
                = getObjectList(5, Persons::new);

        // Print names of personList
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }
}

// Java Program to Illustrate How We can Use
// constructor method reference
// Object need to be sorted
class Persons {
    private String name;
    private Integer age;

    // Constructor
    public Persons()
    {
        Random ran = new Random();

        // Assigning a random value to name
        this.name
                = ran
                .ints(97, 122 + 1)
                .limit(7)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public Integer getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
}
