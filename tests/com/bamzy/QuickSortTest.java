package com.bamzy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void quickSortArrayBasic() {
        QuickSort quickSort = new QuickSort();
        int[] input = new int[]{5, 4, 3, 2, 1};
        int[] res = quickSort.sort(input);
        assertArrayEquals(new int[]{1,2,3,4,5},res);
    }

    @Test
    void quickSortArrayEmpty() {
        QuickSort quickSort = new QuickSort();
        int[] input = new int[0];
        int[] res = quickSort.sort(input);
        assertArrayEquals(new int[]{},res);
    }
}