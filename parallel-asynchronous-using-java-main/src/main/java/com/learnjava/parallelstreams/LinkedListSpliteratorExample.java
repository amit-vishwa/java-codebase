package com.learnjava.parallelstreams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;

/**
 * LinkedList may not perform well with ParallelStream as compared to ArrayList.
 * Since parallel stream performs additional tasks of splitting, executing and joining,
 * it takes more time than sequential stream.
 * LinkedLists may take time to split and join.
 * */
public class LinkedListSpliteratorExample {

    public List<Integer> multiples(LinkedList<Integer> numbers, int multiple, boolean isParallel){
        stopWatchReset();
        startTimer();
        Stream<Integer> numberStream = isParallel ? numbers.parallelStream() : numbers.stream();
        List<Integer> multiples = numberStream.map(number -> number * multiple).toList();
        timeTaken();
        return multiples;
    }

}
