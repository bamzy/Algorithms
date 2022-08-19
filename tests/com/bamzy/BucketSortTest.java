package com.bamzy;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.Assert.*;

public class BucketSortTest {
    BucketSort bucketSort;
    @Test
    @Tag("Critical")
    public void setup(){
        bucketSort = new BucketSort();
    }
    @Test
    public void sort() {
        double[] res = bucketSort.sort(new double[]{3,2,1,5,4,32,43},2);
//        assertArrayEquals(new double[]{1,2,3,4,5,32,43}, new double[]{1,2});
    }
}