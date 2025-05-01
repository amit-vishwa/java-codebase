package youtube.java8.collectors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Collectors is a utility class that provides a set of methods to create common collectors.
 * It is part of the java.util.stream package and is used in conjunction with the Stream API.
 * */
public class CollectorsExample {

    public static void main(String[] args) {
//        collectorsMethods();
        practiceExamples();
    }

    private static void collectorsMethods() {
        // 1. Collecting to a List
        List<String> names = Arrays.asList("Alex","Bob","Charlie");
        System.out.println(names.stream().filter(x->x.startsWith("A"))
                .collect(Collectors.toList())); // empty list if no result found

        // 2. Collecting to a Set
        List<Integer> numbers = List.of(1,2,3,4,3,1,5,2);
        System.out.println(new HashSet<>(numbers)); // this will work as below
        System.out.println(numbers.stream().collect(Collectors.toSet()));

        // 3. Collecting to a specific Collection
        ArrayDeque<String> deque = new ArrayDeque<>(names); // this will work as below
        ArrayDeque<String> arrayDeque = names.stream().collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(deque + ", " + arrayDeque);
        System.out.println(new ArrayDeque<>(numbers) + ", " + numbers.stream().collect(Collectors.toCollection(()->new ArrayDeque<>())));

        // 4. Collecting to a single string by joining the stream elements
        System.out.println(String.join(" - ",names)); // this will work as below
        String concatenatedString = names.stream().collect(Collectors.joining(", ")); // delimiter is optional
        System.out.println(concatenatedString);

        // 5. Summarizing data, generates statistical summary (count,sum,max,min,average)
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        IntSummaryStatistics summarizedInt = integers.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println(summarizedInt);

        System.out.println(integers.stream().collect(Collectors.averagingInt(x->x)));
        System.out.println(summarizedInt.getAverage()); // gives similar result as above

        System.out.println(summarizedInt.getCount()); // gives similar result as below
        System.out.println(integers.stream().collect(Collectors.counting()));
        System.out.println((Long) integers.stream().count());

        // 6. Grouping elements, example group by using string length
        List<String> words = Arrays.asList("hello","world","java","streams","collecting","collections","collectors");
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length())));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length))); // using method reference
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,
                Collectors.joining("-"))));

        System.out.println(String.valueOf(words.stream().collect(Collectors.groupingBy(String::length,
                TreeMap::new, // simple sorting in natural order of integer keys
                Collectors.joining("-")))));
        TreeMap<Integer,String> treeMap = words.stream().collect(Collectors.groupingBy(String::length,
                ()->new TreeMap<>((x,y)->y-x), // descending order of integer keys
                Collectors.joining("-")));
        System.out.println(treeMap);

        // 7. Partitioning elements, partitions into 2 groups (true and false) based on predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5)));
        System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5,
                Collectors.counting())));

        // 8. Mapping and collecting
        System.out.println(words.stream().map(String::toUpperCase).collect(Collectors.toList())); // works as below
        System.out.println(words.stream().collect(Collectors.mapping(String::toUpperCase,Collectors.toList())));

        // 9. toMap, get words and display in map where key is word and its length is value
        System.out.println(words.stream().collect(Collectors.toMap(String::toUpperCase,String::length)));
        TreeMap<String,Integer> wordMap = words.stream().distinct()
                .sorted().collect(Collectors.toMap(x->x,String::length,
                        (existing,updated)->updated, // for duplicate keys, get updated values
                        TreeMap::new));
        System.out.println(wordMap);
    }

    private static void practiceExamples() {
        // 1. Collecting names by length
        List<String> list1 = Arrays.asList("Anna","Bob","Alexander","Brian","Alice");
        Map<Integer,List<String>> namesByLength = list1.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("1.Names by length: " + namesByLength);

        // 2. Counting word occurrences
        String sentence = "hello world hello java world how are you are you fine";
        Map<String,Long> wordCount =Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(x->x, Collectors.counting()));
        System.out.println("2.Word occurrences: " + wordCount);

        // 3. Partitioning even and odd numbers
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        Map<Boolean, List<Integer>> evenOdd = list2.stream().collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println("3.Partitioning even odd: " + evenOdd);

        // 4. Summing values in a map
        Map<String,Integer> map = new HashMap<>(Map.of("Apple",10,"Banana",20,"Orange",15));
//        Integer sum = map.values().stream().reduce(0,(x,y)->x+y); // will give same result
//        Integer sum = map.values().stream().mapToInt(x -> x).sum(); // gives same result as below
        Integer sum = map.values().stream().collect(Collectors.summingInt(x->x));
        System.out.println("4.Summing values in a map: " + sum);

        // 5. Creating a map from stream elements where key is string and its length is value
        List<String> fruits = map.keySet().stream().toList();
        Map<String,Integer> fruitsMap = fruits.stream()
                .collect(Collectors.toMap(x->x, String::length));
        System.out.println("5.Creating string map: " + fruitsMap);

        // 6. Creating a map from stream elements having duplicates values
        List<String> words = Arrays.asList("apple","banana","apple","orange","banana","apple");
        Map<String,Integer> wordMap = words.stream().collect(Collectors.toMap(x->x,
                y->1,(e,n)->e+1));
        System.out.println("6.Creating map from duplicate stream elements: " + wordMap); // same as below
//        System.out.println(words.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())));
    }

}
