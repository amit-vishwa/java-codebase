package tutorial.java.exceptionhandling;

import java.util.UUID;

/**
 *
 * NullPointerException is a RuntimeException. In Java, a special null value can be assigned to an
 * object reference. NullPointerException is thrown when a program attempts to use an object reference
 * that has the null value.
 *
 * Reason for Null Pointer Exception
 * These are certain reasons for Null Pointer Exception as mentioned below:
 * Invoking a method from a null object.
 * Accessing or modifying a null object’s field.
 * Taking the length of null, as if it were an array.
 * Accessing or modifying the slots of null objects, as if it were an array.
 * Throwing null, as if it were a Throwable value.
 * When you try to synchronize over a null object.
 *
 * Refer: https://www.geeksforgeeks.org/null-pointer-exception-in-java/?ref=next_article
 *
 * */

public class NullPointerExceptionExample {
    public static void main(String[] args)
    {
        Singleton s = Singleton.getInstance();
        System.out.println(s.getID());
    }
}
// Why do we need the Null Value?
class Singleton
{
    // Initializing values of single and ID to null.
    private static Singleton single = null;
    private String ID = null;

    private Singleton()
    {
		/* Make it private, in order to prevent the
		creation of new instances of the Singleton
		class. */

        // Create a random ID
        ID = UUID.randomUUID().toString();
    }

    public static Singleton getInstance()
    {
        if (single == null)
            single = new Singleton();
        return single;
    }

    public String getID()
    {
        return this.ID;
    }
}

//How to Avoid the NullPointerException?
//Case 1 : String comparison with literals
class GFG
{
    static void getNullPointerException(){
        String ptr = null;
        // Checking if ptr.equals null or works fine.
        try
        {
            // This line of code throws NullPointerException
            // because ptr is null
            if (ptr.equals("gfg"))
                System.out.print("Same");
            else
                System.out.println("Not Same");
        }
        catch(NullPointerException e)
        {
            System.out.println("NullPointerException Caught");
        }
    }
    static void avoidNullPointerException(){
        // Initializing String variable with null value
        String ptr = null;
        // Checking if ptr is null using try catch.
        try
        {
            if ("gfg".equals(ptr))
                System.out.println("Same");
            else
                System.out.println("Not Same");
        }
        catch(NullPointerException e)
        {
            System.out.println("Caught NullPointerException");
        }
    }
    public static void main (String[] args)
    {
        getNullPointerException();
        avoidNullPointerException();
    }
}

// Case 2 : Keeping a Check on the arguments of a method
// A Java program to demonstrate that we should check if parameters are null or not before using them.
class Test {
    public static void main(String[] args)
    {
        // String s set an empty string and calling
        // getLength()
        String s = "";

        try {
            System.out.println(getLength(s));
        }
        catch (IllegalArgumentException e) {
            System.out.println(
                    "IllegalArgumentException caught");
        }

        // String s set to a value and calling getLength()
        s = "GeeksforGeeks";

        try {
            System.out.println(getLength(s));
        }
        catch (IllegalArgumentException e) {
            System.out.println(
                    "IllegalArgumentException caught");
        }

        // Setting s as null and calling getLength()
        s = null;

        try {
            System.out.println(getLength(s));
        }
        catch (IllegalArgumentException e) {
            System.out.println(
                    "IllegalArgumentException caught");
        }
    }

    // Function to return length of string s. It throws
    // IllegalArgumentException if s is null.
    public static int getLength(String s)
    {
        if (s == null)
            throw new IllegalArgumentException(
                    "The argument cannot be null");

        return s.length();
    }
}

// Case 3 : Use of Ternary Operator
// A Java program to demonstrate that we can use
// Ternary operator to avoid NullPointerException.
class Demo {
    public static void main(String[] args)
    {
        // Initializing String variable with null value
        String str = null;
        String message
                = (str == null) ? null : str.substring(0, 5);

        System.out.println(message);

        // Initializing String variable with null value
        str = "Geeksforgeeks";
        message = (str == null) ? "" : str.substring(0, 5);
        System.out.println(message);
    }
}
