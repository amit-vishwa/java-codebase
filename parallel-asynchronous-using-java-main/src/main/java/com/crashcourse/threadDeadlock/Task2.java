package com.crashcourse.threadDeadlock;

public class Task2 implements Runnable{

    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        // thread2 locks paper and tries to lock pen
        paper.writeWithPaperAndPen(pen);
    }
}
