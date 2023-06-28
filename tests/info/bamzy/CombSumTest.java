package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombSumTest {
    private CombSum combSum;
    @Before
    public void setUp(){
        combSum = new CombSum();
    }

    @Test
    public  void runTest(){

        combSum.combinationSum(new int[]{2,3,6,7},7);
    }
}
