package com.learnjava.parallelstreams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * While computing the result, stream and parallel stream
 * maintains same order for ordered collection.
 * For unordered collection, it does not retain same order.
 * OrderedSpliterator is used by ordered collections while splitting.
 * UnOrderedSpliterator is used by unordered collections while splitting.
 * */
public class ParallelStreamResultOrder {

    public static List<Integer> orderedCollection(){
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        return numbers.stream().parallel().map(number -> number*2).toList();
    }

    public static Set<Integer> unorderedCollection(){
        Set<Integer> numbers = Set.of(1,2,3,4,5,6,7,8,9,10);
        return numbers.stream().map(number -> number*2).collect(Collectors.toSet());
    }

    public static void main(String[] args){
        System.out.println(orderedCollection());
        System.out.println(unorderedCollection());
    }

}
