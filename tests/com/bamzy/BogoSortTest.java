package com.bamzy;

import com.bamzy.amazon.CheckTreeIsBTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BogoSortTest {
    private BogoSort bogoSort;
    @Before
    public void setUp(){
        bogoSort = new BogoSort();
    }

    @Test
    public  void runTest(){

        bogoSort.sort();

    }
}
