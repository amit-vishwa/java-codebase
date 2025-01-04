package tutorial.java.lambdaexpression;

/**
 * Refer: https://www.geeksforgeeks.org/lambda-expressions-java-8/?ref=lbp
 *
 * Lambda expressions in Java, introduced in Java SE 8, represent instances of functional interfaces (interfaces with a single
 * abstract method). They provide a concise way to express instances of single-method interfaces using a block of code.
 *
 * Functionalities of Lambda Expression in Java
 * Lambda Expressions implement the only abstract function and therefore implement functional interfaces lambda expressions are
 * added in Java 8 and provide the below functionalities.
 * - Functional Interfaces: Lambda expressions implement single abstract methods of functional interfaces.
 * - Code as Data: Treat functionality as a method argument.
 * - Class Independence: Create functions without defining a class.
 * - Pass and Execute: Pass lambda expressions as objects and execute on demand.
 *
 * Lambda Expression Syntax: lambda operator -> body
 *
 * Lambda Expression Parameters
 * There are three Lambda Expression Parameters are mentioned below:
 * Zero Parameter:      () -> System.out.println("Zero parameter lambda");
 * Single Parameter:    (p) -> System.out.println("One parameter: " + p);
 * Multiple Parameters: (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
 *
 * Conclusion
 * Some Important points intake from this article is mentioned below:
 * - The body of a lambda expression can contain zero, one, or more statements.
 * - When there is a single statement curly brackets are not mandatory and the return type of the anonymous function is the same as
 * that of the body expression.
 * - When there is more than one statement, then these must be enclosed in curly brackets (a code block) and the return type of the
 * anonymous function is the same as the type of the value returned within the code block, or void if nothing is returned.
 *
 * Based on the syntax rules just shown, which of the following is/are NOT valid lambda expressions?
 * i.() -> {};
 * ii.() -> “geeksforgeeks”;
 * iii.() -> { return “geeksforgeeks”;};
 * iv.(Integer i) -> return “geeksforgeeks” + i;
 * v.(String s) -> {“geeksforgeeks”;};
 *
 * 4 and 5 are invalid lambdas, the rest are valid. Details:
 * i.This lambda has no parameters and returns void. It’s similar to a method with an empty body: public void run() { }.
 * ii.This lambda has no parameters and returns a String as an expression.
 * iii.This lambda has no parameters and returns a String (using an explicit return statement, within a block).
 * iv.return is a control-flow statement. To make this lambda valid, curly braces are required as follows:
 * (Integer i) -> { return “geeksforgeeks” + i; }.
 * v.“geeks for geeks” is an expression, not a statement. To make this lambda valid, you can remove the curly braces and semicolon as
 * follows: (String s) -> “geeks for geeks”. Or if you prefer, you can use an explicit return statement as follows:
 * (String s) -> { return “geeks for geeks”; }.
 * */
public class LambdaExpressionExample {
    public static void main(String args[])
    {
        // lambda expression to implement below
        // functional interface. This interface
        // by default implements abstractFun()
        FuncInterface fobj = (int x)->System.out.println(2*x);

        // This calls above lambda expression and prints 10.
        fobj.abstractFun(5);

        fobj.normalFun();
    }
}

// A sample functional interface (An interface with
// single abstract method
interface FuncInterface
{
    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function
    default void normalFun()
    {
        System.out.println("Hello");
    }
}