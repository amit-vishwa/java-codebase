package com.learnjava.parallelstreams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReduceExampleTest {

    ReduceExample reduceExample = new ReduceExample();

    @Test
    void sum() {
        // given
//        List<Integer> inputList = List.of(1,2,3,4,5);
        List<Integer> inputList = List.of();
        // when
        int sum = reduceExample.sum(inputList);
        // then
//        assertEquals(15,sum);
        assertEquals(0,sum);
    }

    @Test
    void product() {
        // given
//        List<Integer> inputList = List.of(1,2,3,4,5);
        List<Integer> inputList = List.of();
        // when
        int product = reduceExample.product(inputList);
        // then
//        assertEquals(120,product);
        assertEquals(1,product);
    }
}