package info.bamzy;

import info.bamzy.amazon.WaysToChangeCoins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaysToChangeCoinTest {
    private WaysToChangeCoins waysToChangeCoins;
    @Before
    public void setUp(){
        waysToChangeCoins = new WaysToChangeCoins();
    }

    @Test
    public  void runTest(){

        assertEquals(6,waysToChangeCoins.solve(new int[]{1,2,5},7));
        assertEquals(5,waysToChangeCoins.solve(new int[]{1,3,4},7));
        assertEquals(6,waysToChangeCoins.solve(new int[]{1,3,4},8));
        assertEquals(0,waysToChangeCoins.solve(new int[]{9},7));

    }
}
