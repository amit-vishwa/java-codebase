package tutorial.java.lambdaexpression.parameters;

// Functional interface with a single abstract method
@FunctionalInterface
interface ZeroParameterInterface {
    void execute();
}

// Zero Parameter:      () -> System.out.println("Zero parameter lambda");
public class ZeroParameter {
    public static void main(String... args) {
        // Assigning the lambda expression to the functional interface
        ZeroParameterInterface zeroParamLambda = () -> System.out.println("Zero parameter lambda");

        // Calling the method of the functional interface
        zeroParamLambda.execute();
    }
}