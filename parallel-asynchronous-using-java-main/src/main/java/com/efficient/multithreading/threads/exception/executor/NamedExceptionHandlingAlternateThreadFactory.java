package com.efficient.multithreading.threads.exception.executor;

import com.efficient.multithreading.threads.exception.normal.ThreadExceptionHandler;
import com.efficient.multithreading.threads.exception.normal.ThreadExceptionNotifier;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

import java.util.List;

public class NamedExceptionHandlingAlternateThreadFactory extends NamedThreadsFactory {

    private int count = 0;

    @Override
    public Thread newThread(Runnable runnable){
        Thread thread = super.newThread(runnable);
        if(++count % 2 == 0){
            thread.setUncaughtExceptionHandler(new ThreadExceptionNotifier());
        }
        return thread;
    }

}
