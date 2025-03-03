package com.learnjava.parallelstreams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;

/**
 * Always test code for performance while using parallel streams,
 * as unboxing operations takes time
 * */
public class ParallelStreamPerformance {

    public int sumUsingIntStream(int count, boolean isParallel){
        stopWatchReset();
        startTimer();
        IntStream intStream = isParallel ? IntStream.rangeClosed(0,count).parallel()
                : IntStream.rangeClosed(0,count);
        int sum = intStream.sum();
        timeTaken();
        return sum;
    }

    public int sumUsingIntegerList(List<Integer> inputList, boolean isParallel){
        stopWatchReset();
        startTimer();
        Stream<Integer> integerStream = isParallel ? inputList.parallelStream()
                : inputList.stream();
        int sum = integerStream.mapToInt(Integer::valueOf) // unboxing Integer to int
                .sum();
        timeTaken();
        return sum;
    }

    public int sumUsingStreamIterate(int limit, boolean isParallel){
        stopWatchReset();
        startTimer();
        Stream<Integer> integerStream = isParallel ? Stream.iterate(0, i -> i+1).parallel()
                : Stream.iterate(0, i -> i+1);
        int sum = integerStream.limit(limit+1).reduce(0,Integer::sum);
        timeTaken();
        return sum;
    }

}
