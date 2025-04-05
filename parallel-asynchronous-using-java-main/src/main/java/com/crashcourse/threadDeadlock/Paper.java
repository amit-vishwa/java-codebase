package com.crashcourse.threadDeadlock;

public class Paper {

    // this method acquires lock for Paper object
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper and trying to use pen");
        pen.finishWriting();
    }

    // this method acquires lock for Paper object
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using paper");
    }

}
