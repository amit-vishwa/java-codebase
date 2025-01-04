package tutorial.java.io.standardstreams;

import java.util.Scanner;

/**
 * Refer: https://www.geeksforgeeks.org/java-io-input-output-in-java-with-examples/?ref=lbp
 *
 * Java brings various Streams with its I/O package that helps the user to perform all the input-output operations. These streams
 * support all the types of objects, data-types, characters, files etc to fully execute the I/O operations.
 * Before exploring various input and output streams lets look at 3 standard or default streams that Java has to provide which are
 * also most common in use:
 *
 * System.in:
 * This is the standard input stream(System.in) that is used to read characters from the keyboard or any other standard input device.
 *
 * System.out
 * This is the standard output stream(System.out) that is used to produce the result of a program on an output device like the
 * computer screen. Here is a list of the various print functions that we use to output statements:
 * i. print(): This method in Java is used to display a text on the console. This text is passed as the parameter to this method
 * in the form of String. This method prints the text on the console and the cursor remains at the end of the text at the console.
 * The next printing takes place from just here.
 * Syntax: System.out.print(parameter);
 * ii. println(): This method in Java is also used to display a text on the console. It prints the text on the console and the
 * cursor moves to the start of the next line at the console. The next printing takes place from the next line.
 * Syntax: System.out.println(parameter);
 * iii. printf(): This is the easiest of all methods as this is similar to printf in C. Note that System.out.print() and
 * System.out.println() take a single argument, but printf() may take multiple arguments. This is used to format the output in Java.
 * */
public class StandardIOStreams {

    public static void main(String[] args)
    {
        // 1.System.in
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = sc.next();

///////////////////////////////////////////////////////////////////////////////

        // 2.System.out
        // i. print()
        System.out.print("Hello ");

        // ii. println()
        System.out.println(input);

        // iii. printf()
        int x = 100;
        System.out.printf("Printing simple integer: x = %d\n", x);
        // this will print it up to 2 decimal places
        System.out.printf("Formatted with precision: PI = %.2f\n", Math.PI);
        float n = 5.2f;
        // automatically appends zero to the rightmost part of decimal
        System.out.printf("Formatted to specific width: n = %.4f\n", n);
        n = 2324435.3f;
        // here number is formatted from right margin and occupies a width of 20 characters
        System.out.printf("Formatted to right margin: n = %20.4f\n", n);

///////////////////////////////////////////////////////////////////////////////

        // 3.System.err
        // i. print()
        System.err.print("Hello ");
        // ii. println()
        System.err.println(input);
        // iii. printf()
        // this will print it up to 2 decimal places
        System.err.printf("Formatted with precision: PI = %.2f\n", Math.PI);
    }

}
