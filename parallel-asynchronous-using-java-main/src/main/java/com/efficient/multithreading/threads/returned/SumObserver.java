package com.efficient.multithreading.threads.returned;

public class SumObserver implements ResultListener<Integer> {

    private String taskId;

    public SumObserver(String taskId){
        this.taskId = taskId;
    }

    @Override
    public void notifyResult(Integer result) {
        System.out.println("Sum of " + taskId + " is " + result);
    }
}
