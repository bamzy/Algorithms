package com.bamzy;

import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuickSortTest {
    private  QuickSort quickSort;
    @BeforeAll
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
    @Test
    void quickSortException() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> quickSort.getException());
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
    @AfterAll
    @Test
    @Tag ("aaa")
    void afterAllDone() {
        assumeTrue(true);
        assertAll(
                () -> assertEquals(1,quickSort.sort(new int[]{1})),
                () -> assertEquals(1,quickSort.sort(new int[]{1,2})),
                () -> assertEquals(1,quickSort.sort(new int[]{1,3}))
        );
        System.out.println("We're all done");
    }
}