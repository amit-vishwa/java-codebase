package com.efficient.multithreading.threads.daemon;

import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

public class NamedDaemonThreadsFactory extends NamedThreadsFactory {

    private static int count = 0;

    public Thread newThread(Runnable runnable){
        Thread thread = super.newThread(runnable);
        if(++count % 2 == 0){
            thread.setDaemon(true);
        }
        return thread;
    }

}
