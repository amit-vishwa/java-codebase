package tutorial.java.lambdaexpression.parameters;

// Multiple Parameters: (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
public class MultipleParameter {

    public static void main(String[] args) {
        // Using lambda expressions to define the operations
        FuncInter1 add = (a, b) -> a + b;
        FuncInter1 multiply = (a, b) -> a * b;

        // Using the operations
        System.out.println(add.operation(6, 3));  // Output: 9
        System.out.println(multiply.operation(4, 5));  // Output: 20
    }

}

@FunctionalInterface
interface FuncInter1 {
    int operation(int a, int b);
}
