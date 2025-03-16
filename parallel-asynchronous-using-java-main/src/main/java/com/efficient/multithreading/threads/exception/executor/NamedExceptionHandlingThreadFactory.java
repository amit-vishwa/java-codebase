package com.efficient.multithreading.threads.exception.executor;

import com.efficient.multithreading.threads.exception.normal.ThreadExceptionHandler;
import com.efficient.multithreading.threads.exception.normal.ThreadExceptionNotifier;
import com.efficient.multithreading.threads.naming.NamedThreadsFactory;

import java.util.Arrays;
import java.util.List;

public class NamedExceptionHandlingThreadFactory extends NamedThreadsFactory {

    List<Thread.UncaughtExceptionHandler> handlers = List.of(new ThreadExceptionHandler(), new ThreadExceptionNotifier());

    @Override
    public Thread newThread(Runnable runnable){
        Thread thread = super.newThread(runnable);
        thread.setUncaughtExceptionHandler(handlers.get((int)(System.currentTimeMillis() % 2)));
        return thread;
    }

}
