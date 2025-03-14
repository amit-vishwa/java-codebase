package com.efficient.multithreading.threads.returned;

public class FirstTechnique {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+ threadName +"] Main thread starts here...");
        // thread waits for 500ms
        ReturnedTaskA task1 = new ReturnedTaskA(2,3,500);
        // thread waits for 500ms after completion of previous task
        ReturnedTaskA task2 = new ReturnedTaskA(3,4,1000);
        // thread waits for 500ms after completion of previous task
        ReturnedTaskA task3 = new ReturnedTaskA(4,5,1500);
        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");
        Thread thread3 = new Thread(task3, "Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Sum1: " + task1.getSum());
        System.out.println("Sum2: " + task2.getSum());
        System.out.println("Sum3: " + task3.getSum());
        System.out.println("["+ threadName +"] Main thread ends here...");
    }

}
