package tutorial.java.io.readconsoleinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Refer: https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/?ref=next_article
 *
 * 1. Using Buffered Reader Class
 * This is the Java classical method to take input, Introduced in JDK 1.0. This method is used by wrapping the System.in
 * (standard input stream) in an InputStreamReader which is wrapped in a BufferedReader, we can read input from the user in the
 * command line.
 * - The input is buffered for efficient reading.
 * - The wrapping code is hard to remember.
 *
 * Auxiliary Space: O(1)
 * Note: To read other types, we use functions like Integer.parseInt(), Double.parseDouble(). To read multiple values,
 * we use split().
 * */
public class BufferedReaderClass {

    public static void main(String[] args)
            throws IOException
    {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        String name = reader.readLine();

        // Printing the read line
        System.out.println(name);
    }
}