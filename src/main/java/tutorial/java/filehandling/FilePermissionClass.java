package tutorial.java.filehandling;

import java.io.FilePermission;
import java.io.IOException;

/**
 * Refer: https://www.geeksforgeeks.org/java-io-filepermission-class-java/?ref=lbp
 *
 * java.io.FilePermission class is used to represent access to a file or a directory. These accesses are in the form of a path
 * name and a set of actions associated to the path name(specifies which file to be open along with  the extension and the path).
 * For Example, in FilePermission(“GEEKS.txt”, “read”) “GEEKS.txt” is the path and “read” is action being performed. These
 * actions are as follows :
 * - read : read permission to the file
 * - write : write permission to the file
 * - delete : delete permission to the file by calling File.delete
 * - readlink : read link permission
 * - execute : executed the permission
 * */
public class FilePermissionClass {
    public static void main(String[] args) throws IOException
    {
        boolean bool = false;

        // Creating new FilePermissions("Path", "action")
        FilePermission FP_obj1 = new FilePermission("GEEKS", "read");
        FilePermission FP_obj2 = new FilePermission("ABC", "write");
        FilePermission FP_obj3 = new FilePermission("GEEKS", "read");

        // Use of equals method
        bool = FP_obj2.equals(FP_obj1);
        System.out.println("Whether FP_obj1 equals FP_obj2 : " + bool);

        bool = FP_obj2.equals(FP_obj3);
        System.out.println("Whether FP_obj2 equals FP_obj2 : " + bool);

        bool = FP_obj1.equals(FP_obj3);
        System.out.println("Whether FP_obj3 equals FP_obj1 : " + bool);

        // Use of getActions() method
        String str = FP_obj1.getActions();
        System.out.println("Actions with FP_obj1 : " + str);

        str = FP_obj2.getActions();
        System.out.println("Actions with FP_obj2 : " + str);

        str = FP_obj3.getActions();
        System.out.println("Actions with FP_obj3 : " + str);

    }
}
