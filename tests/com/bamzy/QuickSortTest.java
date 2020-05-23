package com.bamzy;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    QuickSort quickSort = new QuickSort();

    @Test
    void quickSortArrayBasic() {
        System.out.println(quickSort.save);
        quickSort.save = true;
        int[] input = new int[]{5, 4, 3, 2, 1};
        int[] res = quickSort.sort(input);
        assertArrayEquals(new int[]{1,2,3,4,5},res);
    }

    @Test
    void quickSortArrayEmpty() {
        System.out.println(quickSort.save);
        int[] input = new int[0];
        int[] res = quickSort.sort(input);
        assertArrayEquals(new int[]{},res);
    }
    @Disabled("ignore this for now")
    @Test
    void quickSortException() throws Exception {
        quickSort.getException();
    }
}