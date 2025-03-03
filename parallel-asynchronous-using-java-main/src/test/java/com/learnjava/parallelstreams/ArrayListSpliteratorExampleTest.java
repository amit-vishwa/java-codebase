package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

import static com.learnjava.util.CommonUtil.noOfCores;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListSpliteratorExampleTest {

    ArrayListSpliteratorExample arrayListSpliteratorExample = new ArrayListSpliteratorExample();

    @RepeatedTest(15)
    void multiplesUsingStream(){
        // given
        int size = 1000000;
        ArrayList<Integer> numbers = DataSet.generateArrayList(size);
        // when
        List<Integer> multiples = arrayListSpliteratorExample.multiples(numbers, 2, false);
        // then
        assertEquals(size, multiples.size());
    }

    @RepeatedTest(15)
    void multiplesUsingParallelStream(){
        // given
        int size = 1000000;
        ArrayList<Integer> numbers = DataSet.generateArrayList(size);
        // when
        List<Integer> multiples = arrayListSpliteratorExample.multiples(numbers, 2, true);
        // then
        assertEquals(size, multiples.size());
    }

}