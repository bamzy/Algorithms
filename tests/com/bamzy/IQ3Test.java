package com.bamzy;

import org.junit.jupiter.api.*;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IQ3Test {


    @Test
    void quickSortArrayEmpty() {
        assertEquals(3,InterviewQ2.add(1,2));
        assertEquals((long)Integer.MAX_VALUE+2,InterviewQ2.add(Integer.MAX_VALUE,2));
//        assertEquals(Integer.MAX_VALUE+Integer.MAX_VALUE,InterviewQ2.add(Integer.MAX_VALUE,Integer.MAX_VALUE));
//        assertEquals(Integer.MAX_VALUE+Integer.MAX_VALUE,InterviewQ2.add(Integer.MAX_VALUE,Integer.MAX_VALUE));
//        assertEquals(Integer.MAX_VALUE+Integer.MAX_VALUE,InterviewQ2.add(Integer.MAX_VALUE,Integer.MAX_VALUE));
    }

}