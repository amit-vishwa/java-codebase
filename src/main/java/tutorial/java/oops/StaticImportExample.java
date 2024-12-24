package tutorial.java.oops;

import static java.lang.System.*;

/**
 * Static import is a feature introduced in Java programming language ( versions 5 and above ) that
 * allows members ( fields and methods ) defined in a class as public static to be used in Java code
 * without specifying the class in which the field is defined.
 * */

public class StaticImportExample {
    public static void main(String args[])
    {
        // We don't need to use 'System.out'
        // as imported using static.
        out.println("GeeksforGeeks");
    }
}
