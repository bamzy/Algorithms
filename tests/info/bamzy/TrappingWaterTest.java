package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrappingWaterTest {
    private TrappingWater tp;
    @Before
    public void setUp(){
        tp = new TrappingWater();
    }

    @Test
    public  void runTest(){

        assertEquals(1,tp.trap(new int[]{5,4,1,2}));
        assertEquals(6,tp.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9,tp.trap(new int[]{4,2,0,3,2,5}));
    }
}
