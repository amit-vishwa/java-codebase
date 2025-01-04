package tutorial.java.io.classes;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/java-io-reader-class-java/?ref=next_article
 *
 * Java Reader class is an abstract class for reading character streams. The only methods that a subclass must implement are
 * read(char[], int, int), and close(). Most subclasses, however, will override some of the methods defined here in order to
 * provide higher efficiency, additional functionality, or both.
 *
 * Constructors in Java Reader Class
 * There are two constructors used with Java Reader Class as mentioned below:
 * - protected Reader(): Creates a new character-stream reader whose critical sections will synchronize on the reader itself.
 * - protected Reader(Object lock): Creates a new character-stream reader whose critical sections will synchronize on the
 * given object.
 *
 * Implementation of Reader Classes
 * Some of the implementations of Reader classes in Java are mentioned below:
 * - BufferedReader
 * - CharArrayReader
 * - FilterReader
 * - InputStreamReader
 * - PipedReader
 * - StringReader
 * */
public class ReaderClassExample {
    // Main function
    public static void main(String[] args)
            throws IOException
    {
        Reader r = new FileReader("myFile.txt");
        PrintStream out = System.out;
        char c[] = new char[10];
        CharBuffer cf = CharBuffer.wrap(c);

        // illustrating markSupported()
        if (r.markSupported()) {
            // illustrating mark()
            r.mark(100);
            out.println("mark method is supported");
        }
        // skipping 5 characters
        r.skip(5);

        // checking whether this stream is ready to be read.
        if (r.ready()) {
            // illustrating read(char[] cbuf,int off,int
            // len)
            r.read(c, 0, 10);
            out.println(Arrays.toString(c));

            // illustrating read(CharBuffer target )
            r.read(cf);
            out.println(Arrays.toString(cf.array()));

            // illustrating read()
            out.println((char)r.read());
        }
        // closing the stream
        r.close();
    }
}
