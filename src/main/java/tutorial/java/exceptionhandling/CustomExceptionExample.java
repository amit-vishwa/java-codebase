package tutorial.java.exceptionhandling;

// Refer: https://www.geeksforgeeks.org/user-defined-custom-exception-in-java/?ref=next_article

public class CustomExceptionExample {
    public static void main(String args[]) throws MyException1 {
        try {
            // Throw an object of user defined exception
            throw new MyException("GeeksGeeks");
        }
        catch (MyException ex) {
            System.out.println("Caught");
            // Print the message from MyException object
            System.out.println(ex.getMessage());

            // MyException1 is not implemented so Exception class is used
            throw new MyException1();
        }
    }
}

// A Class that represents user-defined exception
class MyException extends Exception {
    public MyException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}

// A Class that represents user-defined exception
class MyException1 extends Exception { }
