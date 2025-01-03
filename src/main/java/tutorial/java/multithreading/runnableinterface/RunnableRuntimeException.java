package tutorial.java.multithreading.runnableinterface;

import java.io.FileNotFoundException;

/**
 * Refer: https://www.geeksforgeeks.org/runnable-interface-in-java/?ref=lbp
 * What happens when Runnable encounters an exception ? Runnable can’t throw checked exception but RuntimeException can be
 * thrown from the run(). Uncaught exceptions are handled by the exception handler of the thread, if JVM can’t handle or catch
 * exceptions, it prints the stack trace and terminates the flow.
 *
 * The output shows that Runnable can’t throw checked exceptions, FileNotFoundException in this case, to the callers, it must
 * handle checked exceptions in the run() but RuntimeExceptions (thrown or auto-generated) are handled by the JVM automatically.
 * */
public class RunnableRuntimeException {

    public static void main(String[] args)
    {
        System.out.println("Main thread is- " +
                Thread.currentThread().getName());
        Thread t1 = new Thread(new RunnableDemo().new RunnableImpl());
        t1.start();
    }
}


class RunnableDemo {

    public class RunnableImpl implements Runnable {

        public void run()
        {
            System.out.println(Thread.currentThread().getName()
                    + ", executing run() method!");
            /**
             * Checked exception can't be thrown, Runnable must
             * handle checked exception itself.
             */
//            throw new FileNotFoundException();
            try {
                throw new FileNotFoundException();
            }
            catch (FileNotFoundException e) {
                System.out.println("Must catch here!");
                e.printStackTrace();
            }

            int r = 1 / 0;
            /*
             * Below commented line is an example
             * of thrown RuntimeException.
             */
//             throw new NullPointerException();
        }
    }
}
