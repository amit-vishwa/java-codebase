package com.efficient.multithreading.threads.terminate.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoopTaskF implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private final int DATASET_SIZE = 100000;

    public LoopTaskF(){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskF-" + instanceNumber;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Starting #####");
        for(int i = 1; ;i++){
            System.out.println("[" + threadName + "] <" + this.taskId + "> Tick tick: " + i);
            doComplexCalculation();
            if(Thread.interrupted()){
                System.out.println("[" + threadName + "] <" + this.taskId + "> Interrupted. Cancelling...");
                break;
            }
        }
        System.out.println("[" + threadName + "] <" + this.taskId
                + "> Retrieving 'INTERRUPTED' status again: " + Thread.interrupted());
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Ending #####");
    }

    private void doComplexCalculation(){
        for(int i = 0; i < 3; i++){
            Collections.sort(generateDataSet());
        }
    }

    private List<Integer> generateDataSet() {
        List<Integer> intList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < DATASET_SIZE; i++){
            intList.add(random.nextInt(DATASET_SIZE));
        }
        return intList;
    }

}
