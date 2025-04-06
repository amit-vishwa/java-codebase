package com.crashcourse.threadSafety;

public class VolatileExample {

    public static void main(String[] args) {
        SharedObject object = new SharedObject();
        Thread writerThread = new Thread(object::setFlagTrue,"Writer thread");
        Thread readerThread = new Thread(object::printIfFlagTrue, "Reader thread");
        writerThread.start();
        readerThread.start();
    }

}
