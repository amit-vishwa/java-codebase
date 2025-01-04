package tutorial.java.io.classes;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * Refer: https://www.geeksforgeeks.org/java-io-bufferedoutputstream-class-java/?ref=next_article
 *
 * Java.io.BufferedOutputStream class implements a buffered output stream. By setting up such an output stream, an application
 * can write bytes to the underlying output stream without necessarily causing a call to the underlying system for each byte written.
 * */
public class BufferedOutputStreamClass {

    public static void main(String args[])throws Exception
    {
        FileOutputStream fout = new FileOutputStream("FILE.txt");

        //creating bufferdOutputStream obj
        BufferedOutputStream bout = new BufferedOutputStream(fout);

        //illustrating write() method
        for(int i = 65; i < 75; i++)
        {
            bout.write(i);
        }

        byte b[] = { 75, 76, 77, 78, 79, 80 };
        bout.write(b);

        //illustrating flush() method
        bout.flush();

        //illustrating close() method
        bout.close();
        fout.close();

        System.out.println("File updated!");
    }

}
