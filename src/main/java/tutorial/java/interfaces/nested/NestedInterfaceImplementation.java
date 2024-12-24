package tutorial.java.interfaces.nested;

/**
 * In this example, we have a nested interface NestedInterface inside the OuterClass.
 * We then implement the interface using an anonymous inner class in the main method and call its
 * method nestedMethod(). This is just one way to use nested interfaces in Java.
 * */

public class NestedInterfaceImplementation {

    // Nested interface
    public interface NestedInterface {
        public void nestedMethod();
    }

    public static void main(String[] args)
    {
        // Implement nested interface
        NestedInterface nested = new NestedInterface() {
            public void nestedMethod()
            {
                System.out.println(
                        "Hello from nested interface!");
            }
        };

        // Call nested interface method
        nested.nestedMethod();
    }
}