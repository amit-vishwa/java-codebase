package com.learnjava.parallelstreams;

import java.util.List;

public class ReduceExample {

    public int sum(List<Integer> inputList){
        return inputList
                .stream()
                .parallel()
                // 1 will be added to each chunks (i.e.single element) in parallelStream and only once in stream
//                .reduce(1,Integer::sum);
                .reduce(0,Integer::sum);
    }

    public int product(List<Integer> inputList){
        return inputList.parallelStream()
                // identity is multiplied with each element after splitting
                .reduce(1,(a,b)->a*b);
    }

}
