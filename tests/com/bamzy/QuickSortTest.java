package com.bamzy;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private  QuickSort quickSort;

    @BeforeEach
    public  void doSomeSetup(){
        quickSort = new QuickSort();
    }

    @Test
    void quickSortArrayBasic() {
         quickSort.save = true;
        int[] input = new int[]{5, 4, 3, 2, 1};
        int[] res = quickSort.sort(input);
        assertArrayEquals(new int[]{1,2,3,4,5},res);
    }

    @Test
    void quickSortArrayEmpty() {
        int[] input = new int[0];
        int[] res = quickSort.sort(input);
        assertArrayEquals(new int[]{},res);
    }
    @Disabled("ignore this for now")
    @Test
    void quickSortException() throws Exception {
        quickSort.getException();
    }
    @Test
    void unfinishedTest() {
        quickSort.unfinished(true);
    }

    @Test
    void deltaOfDoubleValues() {
        double a = 2.07;
        double b = 2.08;
        assertEquals(a,b,0.1);
    }
}