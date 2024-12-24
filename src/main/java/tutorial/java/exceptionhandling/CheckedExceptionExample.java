package tutorial.java.exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * These are the exceptions that are checked at compile time. If some code within a method throws a
 * checked exception, then the method must either handle the exception or it must specify the exception
 * using the throws keyword. Checked exceptions can be fully checked or partially checked.
 *
 * i.Fully Checked Exception: A checked exception where all its child classes are also checked (e.g., IOException, InterruptedException).
 * ii.Partially Checked Exception: A checked exception where some of its child classes are unchecked (e.g., Exception).
 * Checked exceptions represent invalid conditions in areas outside the immediate control of the program
 * (like memory, network, file system, etc.). Any checked exception is a subclass of Exception.
 * Unlike unchecked exceptions, checked exceptions must be either caught by the caller or listed as part
 * of the method signature using the throws keyword.
 *
 * */

public class CheckedExceptionExample {
    // Java Program to Illustrate Checked Exceptions
// Where FileNotFoundException does not occur

        // Main driver method
        public static void main(String[] args) throws IOException {

            // Creating a file and reading from local repository
            FileReader file = new FileReader("a.txt");

            // Reading content inside a file
            BufferedReader fileInput = new BufferedReader(file);

            // Printing first 3 lines of file "C:\test\a.txt"
            for (int counter = 0; counter < 3; counter++)
                System.out.println(fileInput.readLine());

            // Closing all file connections
            // using close() method
            // Good practice to avoid any memory leakage
            fileInput.close();
        }
}
