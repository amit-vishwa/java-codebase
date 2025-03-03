package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListSpliteratorExampleTest {

    LinkedListSpliteratorExample linkedListSpliteratorExample = new LinkedListSpliteratorExample();

    @RepeatedTest(15)
    void multiplesUsingStream(){
        // given
        int size = 1000000;
        LinkedList<Integer> numbers = DataSet.generateIntegerLinkedList(size);
        // when
        List<Integer> multiples = linkedListSpliteratorExample.multiples(numbers, 2, false);
        // then
        assertEquals(size, multiples.size());
    }

    @RepeatedTest(15)
    void multiplesUsingParallelStream(){
        // given
        int size = 1000000;
        LinkedList<Integer> numbers = DataSet.generateIntegerLinkedList(size);
        // when
        List<Integer> multiples = linkedListSpliteratorExample.multiples(numbers, 2, true);
        // then
        assertEquals(size, multiples.size());
    }

}