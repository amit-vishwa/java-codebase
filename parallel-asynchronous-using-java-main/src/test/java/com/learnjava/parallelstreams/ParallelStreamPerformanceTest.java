package com.learnjava.parallelstreams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamPerformanceTest {

    ParallelStreamPerformance parallelStreamPerformance = new ParallelStreamPerformance();

    @Test
    void sumUsingIntStream() {
        // given
        int count = 1000000;
        // when
        int sum = parallelStreamPerformance.sumUsingIntStream(count, false);
        System.out.println("IntStream Sum using sequential stream: " + sum);
        // then
        assertEquals(1784293664, sum);
    }

    @Test
    void sumUsingIntStreamParallel() {
        // given
        int count = 1000000;
        // when
        int sum = parallelStreamPerformance.sumUsingIntStream(count, true);
        System.out.println("IntStream Sum using parallel stream: " + sum);
        // then
        assertEquals(1784293664, sum);
    }

    @Test
    void sumUsingIntegerList() {
        // given
        List<Integer> inputList = List.of(1,2,3,4,5);
        // when
        int sum = parallelStreamPerformance.sumUsingIntegerList(inputList, false);
        System.out.println("Integer List Sum using sequential stream: " + sum);
        // then
        assertEquals(15, sum);
    }

    @Test
    void sumUsingIntegerListParallel() {
        // given
        List<Integer> inputList = List.of(1,2,3,4,5);
        // when
        int sum = parallelStreamPerformance.sumUsingIntegerList(inputList, true);
        System.out.println("Integer List Sum using parallel stream: " + sum);
        // then
        assertEquals(15, sum);
    }

    @Test
    void sumUsingStreamIterate() {
        // given
        int count = 1000000;
        // when
        int sum = parallelStreamPerformance.sumUsingStreamIterate(count, false);
        System.out.println("Stream Iterate Sum using sequential stream: " + sum);
        // then
        assertEquals(1784293664, sum);
    }

    @Test
    void sumUsingStreamIterateParallel() {
        // given
        int count = 1000000;
        // when
        int sum = parallelStreamPerformance.sumUsingStreamIterate(count, true);
        System.out.println("Stream Iterate Sum using parallel stream: " + sum);
        // then
        assertEquals(1784293664, sum);
    }

}