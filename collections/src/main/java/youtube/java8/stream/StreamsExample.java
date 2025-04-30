package youtube.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Streams is a feature that got introduced in Java 8 which is used to process collections of objects.
 * Before streams, loops and conditional statements were used which resulted in long code and less readability.
 *
 * Streams simplify data processing, embrace functional and declarative programming, improve readability and
 * maintainability and enable easy parallelism.
 *
 * Streams operations happen in 3 stages - initial, intermediate and terminal.
 * */
public class StreamsExample {

    public static void main(String[] args) {
//        simpleStreamExample();
//        createStreams();
//        intermediateOperations();
//        terminalOperations();
        examples();
    }

    private static void simpleStreamExample() {
        List<Integer> integers = List.of(1,2,3,4,5);
        // count of odd number using traditional approach
        int count = 0;
        for(int i : integers){
            if(i % 2 != 0){
                count++;
            }
        }
        System.out.println("Odd numbers count using loop: " + count);

        // count odd number using stream
        long oddNumberCount = integers.stream().filter(num -> num % 2 != 0).count();
        System.out.println("Odd numbers count using stream: " + oddNumberCount);
    }

    private static void createStreams() {
        // 1. Stream creation using collection
        List<Integer> integers = List.of(1,2,3,4,5);
        Stream<Integer> stream1 = integers.stream();

        // 2. Stream creation using Array
        Integer[] number = {1,2,3,4,5};
        Stream<Integer> stream2 = Arrays.stream(number);

        // 3. Stream using Stream.of()
        Stream<Integer> stream3 = Stream.of(1,2,3,4,5);

        // 4. Infinite streams
        // 4.1. Using generate() to generate streams of provided input
        Stream<Integer> stream4 = Stream.generate(()->10);
        // 4.2. Using iterate() to generate streams of initial value and incremented by 1
        Stream<Integer> stream5 = Stream.iterate(1, x -> x + 1);
        // we can add limit to make infinite stream finite
        Stream<Integer> stream6 = Stream.generate(()->10).limit(10);
        Stream<Integer> stream7 = Stream.iterate(1, x -> x + 1).limit(10);
    }

    /**
     * Intermediate operations transform a stream into another stream.
     * They are lazy, which means they don't execute until terminal operation is invoked.
     * */
    private static void intermediateOperations() {
        List<String> names = List.of("Alex", "Bob", "Charlie", "David");
        System.out.println(names);

        // filter and map are stateless operations, they work with current element
        // sorted, distinct and limit are stateful operations, they should be aware of previous or all elements

        // 1. filter - takes predicate as input
        Stream<String> filterStream = names.stream() // stream initialization
                .filter(name -> name.contains("a")); // filter is intermediate operation
        long count = filterStream.count(); // invoked terminal operation to execute intermediate one
        System.out.println("Filter example: " + count);

        // 2. map - takes function as input to convert one type of object to another
        Stream<String> mapStream = names.stream().map(String::toUpperCase); // map is intermediate
        List<String> upperCasedNames = mapStream.toList(); // invoked terminal operation
        System.out.println("Map example: " + upperCasedNames);

        // 3. sorted - takes comparator as argument, if not provided then uses object's comparable
        List<String> sortedNames = names.stream().sorted().toList();
        System.out.println("Sorted example: " + sortedNames);
        List<String> reverseSortedNames = names.stream().sorted((a,b) -> b.compareTo(a)).toList();
        System.out.println("Sorted with comparator example: " + reverseSortedNames);

        // 4. distinct - removes duplicates from list and returns distinct value
        List<String> fruits = Arrays.asList("Apple","Mango","Apple","Banana","Mango","Apple");
        System.out.println(fruits);
        Stream<String> distinctStream = fruits.stream().distinct();
        List<String> distinctFruits = distinctStream.toList();
        System.out.println("Distinct example: " + distinctFruits);

        // 5. limit - this is mostly used with infinite streams to limit the number of elements
        Stream<Integer> simplelimitStream = Stream
                // iterate with initial value and unary operation
                .iterate(5, n -> n+5) // infinite stream creation
                .limit(5); // intermediate operation to limit infinite stream
        List<Integer> multiples = simplelimitStream.toList();
        System.out.println("Simple limit example: " + multiples);
        Stream<Integer> limitStream = Stream
                // iterate with initial value, predicate condition and unary operation
                .iterate(5, x -> x > 2, n -> n+1) // infinite stream creation
                .limit(10); // intermediate operation to limit infinite stream
        List<Integer> increments = limitStream.toList();
        System.out.println("Predicate limit example: " + increments);

        // 6. skip - skips the first n elements of the stream however the limit count will remain same for infinite stream
        List<Integer> allNumber = Stream.iterate(1,x -> x+1).limit(5).toList();
        System.out.println("Without skip example: " + allNumber); // 1,2,3,4,5
        List<Integer> nonSkippedNumbers = Stream.iterate(1,x -> x+1).skip(10).limit(5).toList();
        System.out.println("With skip example: " + nonSkippedNumbers); // 11,12,13,14,15
    }

    /**
     * Terminal operations invokes the intermediate operations to transform a stream to another.
     * They are mandatory to invoke the intermediate operations else, stream creation is of no use.
     * */
    private static void terminalOperations(){
        List<Integer> integers = List.of(1,2,3,4,5);

        // 1. collect - collects stream of elements in a list, collection, map, set, etc.
        List<String> strings = integers.stream().map(Object::toString)
                .collect(Collectors.toList()); // collect terminal operation, used before Java 16
        System.out.println("Collect before Java 16: " + strings);
        List<String> stringList = integers.stream().map(Object::toString)
                .toList(); // collect terminal operation, since Java 16
        System.out.println("Collect from Java 16: " + stringList);

        // 2. forEach - works similar to loop, only it takes consumer as input
        System.out.print("For each example: [");
        integers.forEach(x-> System.out.print(2*x + ", "));
        System.out.println("]");

        // 3. reduce - combines elements to produce a single result
        Optional<Integer> optionalSum = integers.stream()
                .reduce((x,y)->x+y);
        System.out.println("Reduce optional: " + optionalSum.get());
        System.out.println("Reduce with identity: " + integers.stream()
                .reduce(0,(x,y)->x+y));
        System.out.println("Reduce with identity and method reference: " + integers.stream()
                .reduce(0, Integer::sum));

        // 4. count - gives count from collection stream
        System.out.println("Total list count: " + integers.stream().count());
        System.out.println("Count of elements less than 3: " + integers.stream()
                .filter(x -> x < 3).count());

        // 5. anyMatch, allMatch and noneMatch - all are short-circuit operations i.e. stops if it finds false or true
        System.out.println("Any match: " + integers.stream().anyMatch(x -> x % 2 == 0));
        System.out.println("All match: " + integers.stream().allMatch(x -> x > 0));
        System.out.println("None match: " + integers.stream().noneMatch(x -> x < 0));

        // 6. findFirst and findAny - short-circuit operations, stops process after getting the result, gives almost same results
        System.out.println("Find first: " + integers.stream().findFirst().get()); // getting optional result
        System.out.println("Find any: " + integers.stream().findAny().get()); // get() for getting optional result
    }

    private static void examples(){
        // 1. Filtering and collecting names with length greater than 3
        List<String> names = List.of("Alex","Bob","Charlie","Donald","Eve");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        // 2. Squaring and reverse sorting numbers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println(numbers.stream().map(x -> x*x).sorted((x,y)-> y.compareTo(x)).toList());

        // 3. Summing of list elements
        System.out.println(Stream.iterate(1,x-> x+1).limit(5) // 1,2,3,4,5
                .reduce(0,Integer::sum));

        // 4. Counting 'l' character occurrences
        String string = "Hello world!";
        System.out.println(Arrays.toString(string.chars().toArray()));
        System.out.println(string.chars().filter(x-> x == 'l') //  char 'l' is 108
                .count());

    }
}
