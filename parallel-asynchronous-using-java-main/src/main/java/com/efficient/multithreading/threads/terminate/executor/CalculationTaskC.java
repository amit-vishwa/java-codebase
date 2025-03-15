package com.efficient.multithreading.threads.terminate.executor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class CalculationTaskC implements Callable<Long> {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private final int DATASET_SIZE = 100000;

    private boolean isThreadInterrupted = false;

    public CalculationTaskC(){
        this.instanceNumber = ++count;
        this.taskId = "CalculationTaskC-" + instanceNumber;
    }

    @Override
    public Long call() throws Exception{
        String threadName = Thread.currentThread().getName();
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Starting #####");
        long totalTimeTakenInMillis = 0;
        for(int i = 0; i < 1000; i++){
            System.out.println("[" + threadName + "] <" + this.taskId + "> Current running average = "
                    + (i == 0 ? 0 : totalTimeTakenInMillis/(2*i)));
            long timeTakenInMillis = doComplexCalculation();
            totalTimeTakenInMillis += timeTakenInMillis;
            if(Thread.interrupted()){
                System.out.println("[" + threadName + "] <" + this.taskId + "> Interrupted. Cancelling...");
                isThreadInterrupted = true;
                break;
            }
        }
        System.out.println("[" + threadName + "] <" + this.taskId
                + "> Retrieving 'INTERRUPTED' status again: " + Thread.interrupted());
        System.out.println("##### [" + threadName + "] <" + this.taskId + "> Ending #####");
        return isThreadInterrupted ? -1 : totalTimeTakenInMillis/(2*1000);
    }

    private long doComplexCalculation(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 3; i++){
            Collections.sort(generateDataSet());
        }
        return System.currentTimeMillis() - startTime;
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
