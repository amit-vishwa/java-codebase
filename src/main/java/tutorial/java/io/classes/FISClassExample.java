package tutorial.java.io.classes;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Refer: https://www.geeksforgeeks.org/java-io-fileinputstream-class-java/?ref=next_article
 *
 * FileInputStream class is useful to read data from a file in the form of sequence of bytes. FileInputStream is meant for reading
 * streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
 *
 * Now when we do use these methods we do generically follow these steps to read data from a file using FileInputStream which is
 * ultimatum the goal of FileInputClass
 * Step 1: Attach a file to a FileInputStream as this will enable us to read data from the file as shown below as follows:
 * FileInputStream  fileInputStream = new FileInputStream(“file.txt”);
 *
 * Step 2: Now in order to read data from the file, we should read data from the FileInputStream as shown below:
 * ch = fileInputStream.read();
 *
 * Step 3-A: When there is no more data available to read further, the read() method returns -1;
 * Step 3-B: Then we should attach the monitor to the output stream. For displaying the data, we can use System.out.print.
 * System.out.print(ch);
 *
 * BufferedInputStream can be used to read a buffer full of data at a time from a file. This improves the speed of execution. *
 * */
public class FISClassExample {

    // Main driver method
    public static void main(String args[])
            throws IOException
    {

        // Attaching the file to FileInputStream
        FileInputStream fin = new FileInputStream("myFile.txt");

        // Illustrating getChannel() method
        System.out.println(fin.getChannel());

        // Illustrating getFD() method
        System.out.println(fin.getFD());

        // Illustrating available method
        System.out.println("Number of remaining bytes: " + fin.available());

        // Illustrating skip() method
        fin.skip(2);

        // Display message for better readability
        System.out.println("FileContents :");

        // Reading characters from FileInputStream
        // and write them
        int ch;

        // Holds true till there is data inside file
        while ((ch = fin.read()) != -1)
            System.out.print((char)ch);

        // Close the file connections
        // using close() method
        fin.close();
    }
}
