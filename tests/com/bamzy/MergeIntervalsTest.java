package com.bamzy;

import com.bamzy.google.TwoArraysOneTarget;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MergeIntervalsTest {
    private MergeIntervals mergeIntervals;
    @Before
    public void setUp(){
        mergeIntervals = new MergeIntervals();
    }

    @Test
    public  void runTest(){
        List<Integer> answers = Arrays.asList(10, 12);
        int[][] merged = mergeIntervals.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        assertTrue(merged[0][0]==1 && merged[0][1]==6);
    }
}
