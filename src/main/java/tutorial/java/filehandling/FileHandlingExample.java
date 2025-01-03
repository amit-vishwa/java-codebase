package tutorial.java.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Refer: https://www.geeksforgeeks.org/file-handling-in-java/?ref=lbp
 *
 * In Java, with the help of File Class, we can work with files. This File Class is inside the java.io package. The File class
 * can be used by creating an object of the class and then specifying the name of the file.
 *
 * Why File Handling is Required?
 * File Handling is an integral part of any programming language as file handling enables us to store the output of any
 * particular program in a file and allows us to perform certain operations on it.
 * In simple words, file handling means reading and writing data to a file.
 *
 * In Java, the concept Stream is used in order to perform I/O operations on a file. So at first, let us get acquainted with a
 * concept known as Stream in Java.
 *
 * Streams in Java
 * - In Java, a sequence of data is known as a stream.
 * - This concept is used to perform I/O operations on a file.
 * - There are two types of streams :
 *
 * 1. Input Stream:
 * The Java InputStream class is the superclass of all input streams. The input stream is used to read data from numerous input
 * devices like the keyboard, network, etc. InputStream is an abstract class, and because of this, it is not useful by itself.
 * However, its subclasses are used to read data.
 * There are several subclasses of the InputStream class, which are as follows:
 * i.AudioInputStream
 * ii.ByteArrayInputStream
 * iii.FileInputStream
 * iv.FilterInputStream
 * v.StringBufferInputStream
 * vi.ObjectInputStream
 * Note: We can create an input stream from other subclasses as well as InputStream.
 *
 * 2. Output Stream:
 * The output stream is used to write data to numerous output devices like the monitor, file, etc. OutputStream is an abstract
 * superclass that represents an output stream. OutputStream is an abstract class and because of this, it is not useful by itself.
 * However, its subclasses are used to write data.
 * There are several subclasses of the OutputStream class which are as follows:
 * i.ByteArrayOutputStream
 * ii.FileOutputStream
 * iii.StringBufferOutputStream
 * iv.ObjectOutputStream
 * v.DataOutputStream
 * vi.PrintStream
 * Note: We can create an output stream from other subclasses as well as OutputStream.
 *
 * Based on the data type, there are two types of streams :
 * 1. Byte Stream:
 * This stream is used to read or write byte data. The byte stream is again subdivided into two types which are as follows:
 * - Byte Input Stream: Used to read byte data from different devices.
 * - Byte Output Stream: Used to write byte data to different devices.
 * 2. Character Stream:
 * This stream is used to read or write character data. Character stream is again subdivided into 2 types which are as follows:
 * - Character Input Stream: Used to read character data from different devices.
 * - Character Output Stream: Used to write character data to different devices.
 *
 * File operations in Java
 * The following are the several operations that can be performed on a file in Java :
 * - Create a File
 * - Read from a File
 * - Write to a File
 * - Delete a File
 * */
public class FileHandlingExample {

    public static void main(String[] args){
        createFile();
        writeFile();
        readFile();
        deleteFile();
    }

    /**
     * 1. Create a File
     * In order to create a file in Java, you can use the createNewFile() method.
     * If the file is successfully created, it will return a Boolean value true and false if the file already exists.
     * */
    static void createFile(){
        try {
            File Obj = new File("myfile.txt");
            if (Obj.createNewFile()) {
                System.out.println("File created: "
                        + Obj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    /**
     * 2. Read from a File: We will use the Scanner class in order to read contents from a file.
     * */
    static void readFile(){
        try {
            File Obj = new File("myfile.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    /**
     * 3. Write to a File: We use the FileWriter class along with its write() method in order to write some text to the file.
     * */
    static void writeFile(){
        try {
            FileWriter Writer
                    = new FileWriter("myfile.txt");
            Writer.write(
                    "Files in Java are seriously good!!");
            Writer.close();
            System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    /**
     * 4. Delete a File: We use the delete() method in order to delete a file.
     * */
    static void deleteFile(){
        File Obj = new File("myfile.txt");
        if (Obj.delete()) {
            System.out.println("The deleted file is : "
                    + Obj.getName());
        }
        else {
            System.out.println(
                    "Failed in deleting the file.");
        }
    }

}
