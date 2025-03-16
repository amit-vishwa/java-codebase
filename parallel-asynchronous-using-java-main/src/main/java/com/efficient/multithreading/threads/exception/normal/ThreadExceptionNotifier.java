package com.efficient.multithreading.threads.exception.normal;

public class ThreadExceptionNotifier implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        sendMail(t.getName(), e);
    }

    private void sendMail(String threadName, Throwable e){
        System.out.println("=> " + this + " notified developer with an email => Thread - \""
                + threadName + "\" threw exception: " + e);
    }

}
