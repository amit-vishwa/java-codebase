package com.learnjava.parallelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;

/**
 * Spliterators split the collections,
 * there are different spliterators for different collections.
 * */
public class ArrayListSpliteratorExample {

    public List<Integer> multiples(ArrayList<Integer> numbers, int multiple, boolean isParallel){
        stopWatchReset();
        startTimer();
        Stream<Integer> numberStream = isParallel ? numbers.parallelStream() : numbers.stream();
        List<Integer> multiples = numberStream.map(number -> number * multiple).toList();
        timeTaken();
        return multiples;
    }

}
