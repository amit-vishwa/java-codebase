package com.crashcourse.threadSynchronization;

public class Counter {

    private int count = 0;

    /**
     * synchronized keyword on method will ensure that increment() will be used by
     * one thread instance at a time
     *
     * The section where resources are shared between Thread instances, is known
     * as critical section.
     * Here, the value get changed randomly and to avoid it synchronized block is used.
     *
     * Thread synchronization provides mutual exclusion, which ensure that multiple threads
     * won't access the shared resources simultaneously.
     */
    public synchronized void increment(){
        /**
         * synchronized block will ensure that only one instance can increment count at a time
         * */
        //synchronized (this){
            this.count++; // this is critical section
        //}
    }

    public int getCount(){
        return this.count;
    }

}
