package tutorial.java.lambdaexpression.parameters;

// Functional interface with a single abstract method
@FunctionalInterface
interface SingleParameterInterface {
    void execute(int n);
}

// Single Parameter:    (p) -> System.out.println("One parameter: " + p);
public class SingleParameter {
    public static void main(String... args) {
        // Assigning the lambda expression to the functional interface
        SingleParameterInterface singleParamLambda = n -> System.out.println("Value of n is " + n);

        // Calling the method of the functional interface
        singleParamLambda.execute(5);
    }
}