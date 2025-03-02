package com.learnjava.forkjoin;

import com.learnjava.util.DataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static com.learnjava.util.CommonUtil.delay;
import static com.learnjava.util.CommonUtil.stopWatch;
import static com.learnjava.util.LoggerUtil.log;

/**
 * ForkJoin was introduced in Java 7.
 * Complex code in before Java 8 version style.
 * Not so developer friendly.
 * It uses the principle of Data Parallelism.
 * RecursiveTask extending ForkJoinTask is used when method returns value,
 * else RecursiveAction is used.
 * */
public class ForkJoinUsingRecursion extends RecursiveTask<List<String>> {

    private List<String> inputList;

    public ForkJoinUsingRecursion(List<String> inputList){
        this.inputList = inputList;
    }

    public static void main(String[] args) {

        stopWatch.start();
        List<String> resultList = new ArrayList<>();
        List<String> names = DataSet.namesList();
        log("names : "+ names);

        // create fork join pool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // create fork join task
        ForkJoinUsingRecursion forkJoinUsingRecursion = new ForkJoinUsingRecursion(names);
        // invoke or add task in shared worker thread
        resultList = forkJoinPool.invoke(forkJoinUsingRecursion); // get result after join

        stopWatch.stop();
        log("Final Result : "+ resultList);
        log("Total Time Taken : "+ stopWatch.getTime());
    }


    private static String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    }

    @Override
    protected List<String> compute() {
        // base condition for recursion
        if(inputList.size() <= 1){
            List<String> resultList = new ArrayList<>();
            inputList.forEach(name -> resultList.add(addNameLengthTransform(name)));
            return resultList;
        }
        // add fork and join logic
        int mid = inputList.size() / 2;
        // fork logic
        ForkJoinTask<List<String>> leftInputList = new ForkJoinUsingRecursion(inputList.subList(0, mid)).fork();
        inputList = inputList.subList(mid, inputList.size());
        List<String> rightResult = compute(); // recursive call
        List<String> leftResult = leftInputList.join(); // join all
        leftResult.addAll(rightResult); // add both left right side of list
        return leftResult;
    }
}
