package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Collect performs on collection with mutable objects
 * Reduce performs operations on immutable objects.
 * Collect is more efficient than reduce.
 * */
public class CollectVsReduce {

    /**
     * Collect is performing mutable operation using StringBuilder.
     * It is appending the new string with current one.
     * */
    public static String collect(List<String> names){
        return names.stream().collect(Collectors.joining());
    }

    /**
     * Reduce is performing immutable operation using + operator.
     * It is creating new concatenated string everytime + operator is used.
     * */
    public static String reduce(List<String> names){
        return names.stream().reduce("", (name1,name2)->name1+name2);
    }

    public static void main(String[] args){
        List<String> names = DataSet.namesList();
        System.out.println(collect(names));
        System.out.println(reduce(names));
    }

}
