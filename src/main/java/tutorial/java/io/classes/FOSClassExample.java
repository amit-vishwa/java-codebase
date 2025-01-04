package tutorial.java.io.classes;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Refer: https://www.geeksforgeeks.org/fileoutputstream-in-java/?ref=next_article
 *
 * FileOutputStream is an outputstream for writing data/streams of raw bytes to file or storing data to file. FileOutputStream is
 * a subclass of OutputStream. To write primitive values into a file, we use FileOutputStream class. For writing byte-oriented and
 * character-oriented data, we can use FileOutputStream but for writing character-oriented data, FileWriter is more preferred.
 *
 * Steps to write data to a file using FileOutputStream:
 * - First, attach a file path to a FileOutputStream as shown here:
 * FileOutputStream  fout = new FileOutputStream(“file1.txt”);
 * - This will enable us to write data to the file. Then, to write data to the file, we should write data using the FileOutputStream as,
 * fout.write();
 * - Then we should call the close() method to close the fout file.
 * fout.close()
 * */
public class FOSClassExample {

    public static void main(String[] args) throws IOException
    {

        FileOutputStream out = null;
        String data = "Welcome to Java";

        try {
            out = new FileOutputStream("FILE.txt");

            // Using write() method
            out.write(data.getBytes());

            // Using the flush() method
            out.flush();
            out.close();
            System.out.println("File updated!");
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

}

