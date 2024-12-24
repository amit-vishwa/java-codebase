package tutorial.java.exceptionhandling;

/**
 *
 * Chained Exceptions allows to relate one exception with another exception, i.e one exception describes
 * cause of another exception. For example, consider a situation in which a method throws an
 * ArithmeticException because of an attempt to divide by zero but the actual cause of exception was an
 * I/O error which caused the divisor to be zero. The method will throw only ArithmeticException to
 * the caller. So the caller would not come to know about the actual cause of exception.
 * Chained Exception is used in such type of situations
 *
 * */

public class ChainedExceptionExample {
    public static void main(String[] args)
    {
        try
        {
            // Creating an exception
            NumberFormatException ex =
                    new NumberFormatException("Exception");

            // Setting a cause of the exception
            ex.initCause(new NullPointerException(
                    "This is actual cause of the exception"));

            // Throwing an exception with cause.
            throw ex;
        }

        catch(NumberFormatException ex)
        {
            // displaying the exception
            System.out.println(ex);

            // Getting the actual cause of the exception
            System.out.println(ex.getCause());
        }
    }
}

// Another example
class ExceptionExample {
    public static void main(String[] args) {
        try {
            // code that might throw an exception
            int[] numbers = new int[5];
            int divisor = 0;
            for (int i = 0; i < numbers.length; i++) {
                int result = numbers[i] / divisor;
                System.out.println(result);
            }
        } catch (ArithmeticException e) {
            // create a new exception with the original exception as the cause
            throw new RuntimeException("Error: division by zero", e);
        }
    }
}
