package com.crashcourse.threadCreation;

public class MainThread {

    public static void main(String[] args) {

        /**
         * ThreadExample class is a class that extends the Thread class.
         * We can call start() with instance of this class.
         * Code in run() will get executed.
         * */
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();


        /**
         * RunnableExample class is a class that implements the Runnable interface.
         * RunnableExample class must implement run() of Runnable interface.
         * Now create Thread instance and pass RunnableExample instance as argument.
         * And then call start() with Thread class instance.
         * Code in run() will get executed.
         * */
        RunnableExample runnableExample = new RunnableExample();
        Thread runnableExampleThread = new Thread(runnableExample);
        runnableExampleThread.start();

        /**
         * Since loop is finite then we can write loops from other classes
         * below this loop and code will get executed.
         *
         * However, if infinite loop is then the code below will not get executed
         * as it is unreachable and will also compiler error.
         *
         * But if write infinite loops in other classes that extends Thread or Runnable
         * then the code can run as it will run on different threads which are independent
         * of this main thread.
         *
         * Also, context-switching and time-slicing can be seen here as threads will run
         * randomly for random time period.
         * */
        for (int i = 1; i <= 100; i++){
            System.out.println("Main class: " + Thread.currentThread().getName());
        }

    }

}
