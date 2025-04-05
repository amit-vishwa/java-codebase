package com.crashcourse.threadDeadlock;

public class Pen {

    // this method acquires lock for Pen object
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen and trying to use paper");
        paper.finishWriting();
    }

    // this method acquires lock for Pen object
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using pen");
    }

}
