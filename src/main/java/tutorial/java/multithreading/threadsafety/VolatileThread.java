package tutorial.java.multithreading.threadsafety;

import java.util.logging.Logger;

/**
 * Refer: https://www.geeksforgeeks.org/volatile-keyword-in-java/
 *
 * A volatile keyword is a field modifier that ensures that the object can be used by multiple threads at the same time without
 * having any problem. volatile is one good way of ensuring that the Java program is thread-safe. a volatile keyword can be used
 * as an alternative way of achieving Thread Safety in Java.
 * */
public class VolatileThread {

    // Using volatile keyword results in listener getting updates made by maker,
    // else value is 0 and it will result in infinite loop for listener as it will never get updated value
    private static volatile int MY_INT = 0;

    public static void main(String[] args)
    {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override public void run()
        {
            int local_value = MY_INT;
            while (local_value < 5) {
                if (local_value != MY_INT) {
                    System.out.printf(
                            "\nGot Change for MY_INT : %d",
                            MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override public void run()
        {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.printf(
                        "\nIncrementing MY_INT to %d",
                        local_value + 1);
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
