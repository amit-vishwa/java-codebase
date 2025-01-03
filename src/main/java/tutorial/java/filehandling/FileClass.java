package tutorial.java.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Refer: https://www.geeksforgeeks.org/file-class-in-java/?ref=lbp
 *
 * Java File class is a representation of a file or directory pathname. Because file and directory names have different formats
 * on different platforms, a simple string is not adequate to name them. Java File class contains several methods for working
 * with the pathname, deleting and renaming files, creating new directories, listing the contents of a directory, and
 * determining several common attributes of files and directories.
 *
 * Features:
 * - It is an abstract representation of files and directory pathnames.
 * - A pathname, whether abstract or in string form can be either absolute or relative. The parent of an abstract pathname may be
 * obtained by invoking the getParent() method of this class.
 * - First of all, we should create the File class object by passing the filename or directory name to it. A file system may
 * implement restrictions to certain operations on the actual file-system object, such as reading, writing, and executing. These
 * restrictions are collectively known as access permissions.
 * - Instances of the File class are immutable; that is, once created, the abstract pathname represented by a File object will
 * never change.
 * */
public class FileClass {

    public static void main(String[] args)
    {
        // Accept file name or directory name through
        // command line args
        String fname = "xyz.txt";
        fileExists(fname);
        try {
            displayFile();
        }catch (Exception e){}
    }

    public static void fileExists(String fname)
    {
        // pass the filename or directory name to File
        // object
        File f = new File(fname);

        // apply File class methods on File object
        System.out.println("File name :" + f.getName());
        System.out.println("Path: " + f.getPath());
        System.out.println("Absolute path:" + f.getAbsolutePath());
        System.out.println("Parent:" + f.getParent());
        System.out.println("Exists :" + f.exists());

        if (f.exists()) {
            System.out.println("Is writable:" + f.canWrite());
            System.out.println("Is readable" + f.canRead());
            System.out.println("Is a directory:" + f.isDirectory());
            System.out.println("File Size in bytes " + f.length());
        }
    }

    static void displayFile() throws IOException {

            // Enter the path and dirname
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.print("Enter directory path : ");
            String dirpath = br.readLine(); // D:\Amit\Work

            System.out.print("Enter the directory name : ");
            String dname = br.readLine(); // Resumes

            // Create File object with dirpath and dname
            File f = new File(dirpath, dname);

            // If directory exists,then
            if (f.exists()) {

                // Get the contents into arr[]
                // now arr[i] represent either a File or
                // Directory
                String arr[] = f.list();

                // Find no. of entries in the directory
                int n = arr.length;

                // Displaying the entries
                for (int i = 0; i < n; i++) {

                    System.out.print(arr[i] + " ");

                    // Create File object with the entry and
                    // test if it is a file or directory
                    File f1 = new File(f,arr[i]);

                    if (f1.isFile())
                        System.out.println(": is a file");
                    if (f1.isDirectory())
                        System.out.println(": is a directory");
                }

                System.out.println("\nNo of entries in this directory : " + n);
            }
            else
                System.out.println("Directory not found");

    }
}

