package tutorial.java.io.readconsoleinput;

import java.util.Scanner;

/**
 * Refer: https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/?ref=next_article
 *
 * 2. Using Scanner Class
 * This is probably the most preferred method to take input, Introduced in JDK 1.5. The main purpose of the Scanner class is to
 * parse primitive types and strings using regular expressions; however, it is also can be used to read input from the user in
 * the command line.
 * - Convenient methods for parsing primitives (nextInt(), nextFloat(), …) from the tokenized input.
 * - Regular expressions can be used to find tokens.
 * - The reading methods are not synchronized.
 *
 * Following are the Major Differences between Scanner and BufferedReader Class in Java
 * - BufferedReader is synchronous while Scanner is not. BufferedReader should be used if we are working with multiple threads.
 * - BufferedReader has a significantly larger buffer memory than Scanner.
 * - The Scanner has a little buffer (1KB char buffer) as opposed to the BufferedReader (8KB byte buffer), but it’s more than enough.
 * - BufferedReader is a bit faster as compared to Scanner because the Scanner does the parsing of input data and BufferedReader
 * simply reads a sequence of characters.
 * */
public class ScannerClass {

    public static void main(String args[])
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println("You entered string " + s);

        int a = in.nextInt();
        System.out.println("You entered integer " + a);

        float b = in.nextFloat();
        System.out.println("You entered float " + b);
    }

}
