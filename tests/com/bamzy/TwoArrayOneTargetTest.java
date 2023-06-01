package com.bamzy;

import com.bamzy.google.TwoArraysOneTarget;
import org.junit.Before;
import org.junit.Test;

//import static org.hamcrest.core.AnyOf.anyOf;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TwoArrayOneTargetTest {
    private TwoArraysOneTarget twoArraysOneTarget;
    @Before
    public void setUp(){
        twoArraysOneTarget = new TwoArraysOneTarget();
    }

    @Test
    public  void runTest(){
        List<Integer> answers = Arrays.asList(10, 12);
        int closestToTarget = twoArraysOneTarget.findClosestToTarget(new int[]{5, 2, -1, 7, 14}, new int[]{3, 7, 5, -6, 1, 2}, 11);
        assertTrue(answers.contains(closestToTarget) );
    }
}
