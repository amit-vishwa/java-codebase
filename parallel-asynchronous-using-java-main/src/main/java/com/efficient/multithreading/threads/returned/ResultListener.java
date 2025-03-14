package com.efficient.multithreading.threads.returned;

public interface ResultListener<T> {

    public void notifyResult(T result);

}
