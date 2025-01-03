package tutorial.java.filehandling;

import java.io.FileReader;

/**
 * Refer: https://www.geeksforgeeks.org/java-io-filereader-class/?ref=lbp
 *
 * FileReader in Java is a class in the java.io package which can be used to read a stream of characters from the files. Java IO
 * FileReader class uses either specified charset or the platform’s default charset for decoding from bytes to characters.
 *
 * 1. Charset: The Charset class is used to define methods for producing encoders and decoders and for recovering several names
 * combined with the charset.
 * 2. Default Charset: The default charset is defined during implicit computer start-up and it depends on the locale and charset
 * of the underlying operating system.
 * */
public class FileReaderClass {
    public static void main(String[] args)
    {
        try {
            // FileReader Class used
            FileReader fileReader = new FileReader("xyz.txt");

            System.out.println("Reading char by char:");
            int i;

            // Using read method
            while ((i = fileReader.read()) != -1) {
                System.out.print((char)i);
            }

            System.out.println("\n\nReading using array:");
            char[] charArray = new char[10];

            // Using read method for to get character array
            fileReader.read(charArray);
            System.out.print(charArray);

            // Close method called
            fileReader.close();
            System.out.println("\n\nFileReader closed!");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
