package tutorial.java.streams;

import java.util.*;
import java.util.stream.*;

/**
 * Refer: https://www.geeksforgeeks.org/java-8-stream-tutorial/?ref=next_article
 *
 * Java 8 introduces Stream, which is a new abstract layer, and some new additional packages in Java 8 called java.util.stream.
 * A Stream is a sequence of components that can be processed sequentially. These packages include classes, interfaces, and
 * enum to allow functional-style operations on the elements.
 * The stream can be used by importing java.util.stream package. Stream API is used to process collections of objects. Streams
 * are designed to be efficient and can support improving your program’s performance by allowing you to avoid unnecessary loops
 * and iterations. Streams can be used for filtering, collecting, printing, and converting from one data structure to another, etc.
 *
 * Note:
 * If we want to represent a group of objects as a single entity then we should go for collection.
 * But if we want to process objects from the collection then we should go for streams.
 * Note: Streams are present in java’s utility package named java.util.stream
 *
 * Let us now start with the basic components involved in streams. They as listed as follows:
 * Sequence of Elements
 * Source
 * Aggregate Operations
 * Pipelining
 * Internal iteration
 *
 * Features of Java Stream
 * - A stream is not a data structure instead it takes input from the Collections, Arrays, or I/O channels.
 * - Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
 * - Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be
 * pipelined. Terminal operations mark the end of the stream and return the result.
 *
 * How does Stream Work Internally?
 * In streams,
 * - To filter out from the objects we do have a function named filter()
 * - To impose a condition we do have a logic of predicate which is nothing but a functional interface. Here function interface
 * can be replaced by a random expression. Hence, we can directly impose the condition check-in our predicate.
 * - To collect elements we will be using Collectors.toList() to collect all the required elements.
 * - Lastly, we will store these elements in a List and display the outputs on the console.
 *
 * Various Core Operations Over Streams
 * There are broadly 3 types of operations that are carried over streams namely as follows as depicted from the image shown above:
 * - Intermediate operations
 * - Terminal operations
 * - Short-circuit operations
 *
 * 1. Intermediate Operations:
 * Intermediate operations transform a stream into another stream. Some common intermediate operations include:
 * - filter(): Filters elements based on a specified condition.
 * - map(): Transforms each element in a stream to another value.
 * - sorted():  Sorts the elements of a stream.
 *
 * All three of them are discussed below as they go hand in hand in nearly most of the scenarios and to provide better
 * understanding by using them later by implementing in our clean Java programs below. As we already have studied in the above
 * example of which we are trying to filter processed objects can be interpreted as filter() operation operated over streams.
 *
 * 2. Terminal Operations
 * Terminal Operations are the operations that on execution return a final result as an absolute value.
 * - collect(): It is used to return the result of the intermediate operations performed on the stream.
 * - forEach(): It iterates all the elements in a stream.
 * - reduce(): It is used to reduce the elements of a stream to a single value.
 *
 * 3. Short Circuit Operations
 * Short-circuit operations provide performance benefits by avoiding unnecessary computations when the desired result can be
 * obtained early. They are particularly useful when working with large or infinite streams.
 * - anyMatch(): it checks the stream if it satisfies the given condition.
 * - findFirst(): it checks the element that matches a given condition and stops processing when it finds it.
 * Note: They are lazy, meaning they are not executed until a terminal operation is invoked.
 * */
public class StreamExample
{

    public static void main(String[] args)
    {
        // Creating an ArrayList object of integer type
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Inserting elements to ArrayList class object
        // Custom input integer numbers
        al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);

        // First lets print the collection
        System.out.println("Printing the collection : "
                + al);

        // Stream operations
        // 1. Getting the stream from this collection
        // 2. Filtering out only even elements
        // 3. Collecting the required elements to List
        List<Integer> ls
                = al.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        // Print the collection after stream operation
        // as stored in List object
        System.out.println(
                "Printing the List after stream operation : "
                        + ls);

        // Using stream, we map every object and later
        // collect to List
        // and store them
        List<Integer> updatedMarks
                = al.stream()
                .map(i -> i + 6)
                .collect(Collectors.toList());

        // Printing the marks of the students after grace
        System.out.println(
                "Marks of students  after grace : "
                        + updatedMarks);
    }
}

