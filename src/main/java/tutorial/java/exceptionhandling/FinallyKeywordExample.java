package tutorial.java.exceptionhandling;

/**
 *
 * How jdk 1.7 makes usage of the final block optional?
 *
 * Until jdk 1.6 finally block is like a hero i.e, it is recommended to use it for resource deallocation
 * but from jdk 1.7 onwards finally, the block is now optional (however you can use it).
 * Since the resources which we opened in the try block will automatically get deallocated/closed when
 * the flow of the program reaches the end of the try block.
 * This concept of automatic resource deallocation without using the final block is
 * known as the try-with-resources statement.
 *
 * */

// Java program to illustrate
// use of finally block
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class FinallyKeywordExample {
    private static final int SIZE = 10;
    public static void main(String[] args)
    {

        PrintWriter out = null;
        try {
            System.out.println("Entered try statement");

            // below statement won't let finally get executed
//            System.exit(0);

            // PrintWriter, FileWriter
            // are classes in io package
            out = new PrintWriter(new FileWriter("OutFile.txt"));
        }
        catch (IOException e) {   }

        // Following finally block cleans up
        // and then closes the PrintWriter.

        finally
        {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}
