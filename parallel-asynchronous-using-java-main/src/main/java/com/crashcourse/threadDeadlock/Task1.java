package com.crashcourse.threadDeadlock;

public class Task1 implements Runnable{

    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        /**
         * synchronized block is added on critical section to prevent deadlock
         * since thread1 has Pen's lock and tries to acquire Paper's lock,
         * here it will check if Paper's lock is accessible by thread1
         * which means thread2 must have finished its Paper's unlocking process
         * */
        synchronized (paper){
            pen.writeWithPenAndPaper(paper);
        }
        // thread1 locks pen and tries to lock paper
//        pen.writeWithPenAndPaper(paper);
    }
}
