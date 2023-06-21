package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumCostToMakeArrayEqualTest {
    private MinimumCostToMakeArrayEqual minimumCostToMakeArrayEqual;
    @Before
    public void setUp(){
        minimumCostToMakeArrayEqual = new MinimumCostToMakeArrayEqual();
    }

    @Test
    public  void runTest(){

        assertEquals(1907611126748L, minimumCostToMakeArrayEqual.minCost(new int[]{735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518},new int[]{724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614}));
        assertEquals(8, minimumCostToMakeArrayEqual.minCost(new int[]{1,3,5,2},new int[]{2,3,1,14}));
    }
}
