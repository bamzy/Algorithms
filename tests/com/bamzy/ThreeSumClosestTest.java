package com.bamzy;
import com.bamzy.ThreeSum;
import com.bamzy.ThreeSumClosest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ThreeSumClosestTest {
    private ThreeSumClosest tsc;
    @Before
    public void setUp(){
        tsc = new ThreeSumClosest();
    }

    @Test
    public  void runTest(){

        assertEquals(tsc.threeSumClosest(new int[]{-1,2,1,-4},1),2);
        assertEquals(tsc.threeSumClosest(new int[]{0,0,0},1),0);
    }
}
