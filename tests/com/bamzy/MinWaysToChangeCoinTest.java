package com.bamzy;

import com.bamzy.amazon.MinWaysToChangeCoin;
import com.bamzy.amazon.WaysToChangeCoins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinWaysToChangeCoinTest {
    private MinWaysToChangeCoin minWaysToChangeCoin;
    @Before
    public void setUp(){
        minWaysToChangeCoin = new MinWaysToChangeCoin();
    }

    @Test
    public  void runTest(){

        assertEquals(2, minWaysToChangeCoin.solve(new int[]{1,3,4,5},7));
        assertEquals(-1, minWaysToChangeCoin.solve(new int[]{4,5},11));

    }
}
