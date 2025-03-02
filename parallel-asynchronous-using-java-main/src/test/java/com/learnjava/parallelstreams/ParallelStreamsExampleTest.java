package com.learnjava.parallelstreams;

import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamsExampleTest {

    ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();

    @Test
    void transformString() {
        // given
        List<String> names = DataSet.namesList();
        // when
        CommonUtil.stopWatchReset();
        CommonUtil.startTimer();
        List<String> resultList = parallelStreamsExample.transformString(names);
        CommonUtil.timeTaken();
        // then
        assertEquals(4,resultList.size());
        resultList.forEach(name->assertTrue(name.contains("-")));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void transformString1(boolean isParallel) {
        // given
        List<String> names = DataSet.namesList();
        // when
        CommonUtil.stopWatchReset();
        CommonUtil.startTimer();
        List<String> resultList = parallelStreamsExample.transformString_1(names, isParallel);
        CommonUtil.timeTaken();
        // then
        assertEquals(4,resultList.size());
        resultList.forEach(name->assertTrue(name.contains("-")));
    }

}