package tutorial.java.filehandling;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Refer: https://www.geeksforgeeks.org/java-io-filedescriptor-java/?ref=lbp
 *
 * java.io.FileDescriptor class in Java works for opening a file having a specific name. If there is any content present in that
 * file it will first erase all that content and put “Beginning of Process” as the first line. Instances of the file descriptor
 * class serve as an opaque handle to the underlying machine-specific structure representing an open file, an open socket, or
 * another source or sink of bytes.
 * The main practical use for a file descriptor is to create a FileInputStream or FileOutputStream to contain it.
 * Applications should not create their own file descriptors.
 *
 * There are 3 major fields in this class:
 * err: A handle to the standard error stream.
 * in: A handle to the standard input stream.
 * out: A handle to the standard output stream.
 * */
public class FileDescriptorClass {

    public static void main(String... args) throws Exception{
        sync();
        valid();
    }

    public static void sync()
            throws IOException
    {
        // Initializing a FileDescriptor
        FileDescriptor geek_descriptor = null;
        FileOutputStream geek_out = null;

        // HERE I'm writing "GEEKS" in my file
        byte[] buffer = {71,69,69,75,83};

        try{
            geek_out = new FileOutputStream("myFile.txt");

            // This getFD() method is called before closing the output stream
            geek_descriptor = geek_out.getFD();

            // writes byte to file output stream
            geek_out.write(buffer);

            // USe of sync() : to sync data to the source file
            geek_descriptor.sync();
            System.out.print("\nUse of Sync Successful ");

        }
        catch(Exception except)
        {
            // if in case IO error occurs
            except.printStackTrace();
        }
        finally
        {
            // releases system resources
            if(geek_out!=null)
                geek_out.close();
        }
    }

    public static void valid() throws IOException
    {
        // Initializing a FileDescriptor
        FileDescriptor geek_descriptor = null;
        FileInputStream geek_in = null;

        try
        {
            geek_in = new FileInputStream("FILE.txt");

            // get file descriptor
            geek_descriptor = geek_in.getFD();

            boolean check = false;

            // Use of valid() : checking the validity of FileDescriptor
            check = geek_descriptor.valid();

            System.out.print("FileDescriptor is valid : "+check);

        }
        catch(Exception except)
        {
            // if in case IO error occurs
            except.printStackTrace();
        }
        finally
        {
            // releases system resources
            if(geek_in!=null)
                geek_in.close();
        }
    }
}
