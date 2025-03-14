package com.efficient.multithreading.threads.returned;

/**
 * Result will be displayed in the order of completion of tasks
 * */
public class SecondTechnique {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+ threadName +"] Main thread starts here...");
        // thread waits for 500ms
        ReturnedTaskB task1 = new ReturnedTaskB(2,3,500, new SumObserver("task-1"));
        // thread waits for 500ms after completion of previous task
        ReturnedTaskB task2 = new ReturnedTaskB(3,4,1000, new SumObserver("task-2"));
        // thread waits for 500ms after completion of previous task
        ReturnedTaskB task3 = new ReturnedTaskB(4,5,1500, new SumObserver("task-3"));
        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");
        Thread thread3 = new Thread(task3, "Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("["+ threadName +"] Main thread ends here...");
    }

}
