package com.crashcourse.threadSafety;

public class SharedObject {

    /**
     * volatile keyword can be only used with class level global variables.
     * volatile keyword will inform threads to fetch values direct
     * from main memory of RAM instead of local cache.
     * This informs that the variable is mutable, it is a shared resource used by multiple threads.
     * It is used for simple use case like describing the state of object, when complex functionalities like
     * object manipulation is done then volatile won't give the correct updated results.
     * */
    private volatile boolean flag = false;
//    private boolean flag = false;

    public void setFlagTrue(){
        System.out.println(Thread.currentThread().getName() + " set the flag to true");
        flag = true;
    }

    public void printIfFlagTrue(){
        while(!flag){
            /**
             * Since every thread has a local copy of variable which is cached.
             * So update in main memory of RAM won't be reflected in cache.
             * Now, here reader thread will get stuck in loop as flag will always be false.
             * */
        }
        System.out.println("Flag is true!");
    }

}
