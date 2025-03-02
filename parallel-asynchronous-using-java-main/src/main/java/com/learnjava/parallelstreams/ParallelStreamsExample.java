package com.learnjava.parallelstreams;

import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Parallel Streams can be used for Data Parallelism instead of ForkJoin
 * */
public class ParallelStreamsExample {

    public static void main(String[] args){
        List<String> names = DataSet.namesList();
        System.out.println(names);
        CommonUtil.startTimer();
        List<String> nameList = new ParallelStreamsExample().transformString(names);
        System.out.println(nameList);
        CommonUtil.timeTaken();
    }

    public List<String> transformString(List<String> names){
        return names
                .stream() // this will execute sequentially
                .parallel() // this will transform to parallel execution
                .map(this::transformString)
                .toList();
    }

    public List<String> transformString_1(List<String> names, boolean isParallel){
        Stream<String> nameStream = isParallel ? names.parallelStream():
                names.parallelStream().sequential();

        return nameStream
                .map(this::transformString)
                .toList();
    }

    public String transformString(String name){
        CommonUtil.delay(500);
        return name.length() + "-" + name;
    }

}
