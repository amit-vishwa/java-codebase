package tutorial.java.io.readconsoleinput;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Refer: https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/?ref=next_article
 *
 * 5. Using DataInputStream class
 * A DataInputStream in Java is a class that provides a convenient way to read primitive Java data types from an input stream in
 * a machine-independent manner, introduced in JDK 1.0. It wraps an existing InputStream and allows applications to read Java
 * primitive data types (int, short, long, byte, float, double, char, boolean) and strings from the underlying input stream,
 * preserving their binary format. DataInputStream is part of the java.io package and is particularly useful when you need to
 * read data that was written using a DataOutputStream or any other source that wrote data in a compatible format.
 *
 * Definition:
 * DataInputStream is a Java class that implements data input operations. It allows applications to read primitive data types and
 * strings from an input stream in a machine-independent way. It achieves this by wrapping an existing input stream and providing
 * methods to read various primitive data types and strings from the underlying input source.
 * Remember that DataInputStream reads data in a binary format, so it’s important to ensure that the data being read was written
 * using the correct methods in DataOutputStream or a compatible source to avoid data corruption or misinterpretation.
 * */
public class DataInputStreamClass {

    public static void main(String[] args) throws IOException {
        DataInputStream reader = new DataInputStream(System.in);

        // Reading integers
        System.out.print("Enter an integer: ");
        int inputInt = Integer.parseInt(reader.readLine());

        // Reading strings
        System.out.print("Enter a string: ");
        String inputString = reader.readLine();
        System.out.println("You entered integer: " + inputInt);
        System.out.println("You entered string: " + inputString);

    }

}
