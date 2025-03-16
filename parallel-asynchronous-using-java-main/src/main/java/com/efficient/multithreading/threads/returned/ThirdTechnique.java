package com.efficient.multithreading.threads.returned;

/**
 * Values can be returned using join().
 * */
public class ThirdTechnique {

    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+ threadName +"] Main thread starts here...");
        // task1 when completed prints result
        ReturnedTaskC task1 = new ReturnedTaskC(2,3,2000);
        // task2 when completed prints its result along with task3 as task3 is already completed
        ReturnedTaskC task2 = new ReturnedTaskC(3,4,3000);
        // task3 is completed first but print is blocked as other tasks are running
        ReturnedTaskC task3 = new ReturnedTaskC(4,5,1500);

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");
        Thread thread3 = new Thread(task3, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        System.out.println("Sum1: " + task1.getSum());

        thread2.join();
        System.out.println("Sum2: " + task2.getSum());

        thread3.join();
        System.out.println("Sum3: " + task3.getSum());

        System.out.println("["+ threadName +"] Main thread ends here...");
    }

}
