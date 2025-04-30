package youtube.java8.lambdaexpression;

/**
 * Lambda interface was introduced in Java 8 version. The main aim of Java 8 release was to minimise the code.
 * The functional programming was introduced along with lambda expression, streams and data & time API.
 *
 * Lambda expression is an anonymous function (i.e. no name, no return type and no access modifier)
 * */
public class LambdaExpressionExample {

    public static void main(String[] args) {
        threadExample();
    }

    private static void threadExample() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi");
            }
        };
        Thread t1 = new Thread(runnable); // traditional way
        Thread t2 = new Thread(()->{
            System.out.println("Hello");
        }); // after Java 8
        t1.start();
        t2.start();

        // lambda expression can be used to implement functional interfaces
        MathOperation addition = (a,b) -> a+b;
        MathOperation subtraction = (a,b) -> a-b;
        System.out.println("Addition: " + addition.operate(5,2));
        System.out.println("Subtraction: " + subtraction.operate(5,2));
    }

    // functional interface
    interface MathOperation{
        int operate(int a, int b);
    }

}
