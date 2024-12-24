package tutorial.java.exceptionhandling;

// Java program to demonstrate working of try, catch, throw, throws and finally
public class ExceptionHandlingKeywords {
    // throws keyword is required only for checked exceptions and usage of the
    // throws keyword for unchecked exceptions is meaningless.
    public static void callExceptionMethod() throws ArithmeticException
    {
        int a = 10, b = 5, c = 5, result;
        result = a / (b - c);
        System.out.println("result" + result);
    }
    public static void main(String... args){
        try {
            callExceptionMethod();
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught:Division by zero");
            throw new ArithmeticException(); // explicitly throwing exception
        }
        finally {
            System.out.println("I am in final block");
        }
    }
}
