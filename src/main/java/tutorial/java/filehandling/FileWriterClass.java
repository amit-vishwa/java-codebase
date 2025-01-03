package tutorial.java.filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Refer: https://www.geeksforgeeks.org/filewriter-class-in-java/?ref=lbp
 *
 * Java FileWriter class of java.io package is used to write data in character form to file. Java FileWriter class is used to
 * write character-oriented data to a file. It is a character-oriented class that is used for file handling in java.
 * - This class inherits from OutputStreamWriter class which in turn inherits from the Writer class.
 * - The constructors of this class assume that the default character encoding and the default byte-buffer size are acceptable.
 * To specify these values yourself, construct an OutputStreamWriter on a FileOutputStream.
 * - FileWriter is meant for writing streams of characters. For writing streams of raw bytes, consider using a FileOutputStream.
 * - FileWriter creates the output file if it is not present already.
 * */
public class FileWriterClass {
    public static void main(String[] args)
            throws IOException
    {
        write();
        encoding();
    }

    static void write(){
        // initialize a string
        String str = "ABC";
        try {
            // attach a file to FileWriter
            FileWriter fw
                    = new FileWriter("myFile.txt");
            // read each character from string and write
            // into FileWriter
            for (int i = 0; i < str.length(); i++)
                fw.write(str.charAt(i));
            System.out.println("Successfully written");
            // close the file
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    static void encoding(){
        String file = "myFile.txt";
        try {
            // Creates a FileReader with default encoding
            FileWriter o1 = new FileWriter(file);
            // Creates a FileReader specifying the encoding
            FileWriter o2 = new FileWriter(
                    file, Charset.forName("UTF8"));
            // Returns the character encoding of the reader
            System.out.println("Character encoding of o1: "
                    + o1.getEncoding());
            System.out.println("Character encoding of o2: "
                    + o2.getEncoding());
            // Closes the reader
            o1.close();
            o2.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

}
