package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MinimumSpeedToArriveOnTimeTest {
    private MinimumSpeedToArriveOnTime minimumSpeedToArriveOnTime;
    @Before
    public void setUp(){
        minimumSpeedToArriveOnTime = new MinimumSpeedToArriveOnTime();
    }

    @Test
    public  void runTest(){
        assertEquals(3,minimumSpeedToArriveOnTime.minSpeedOnTime(new int[]{1,3,2}, 3));
        assertEquals(1,minimumSpeedToArriveOnTime.minSpeedOnTime(new int[]{1,3,2}, 6));
        assertEquals(10000000,minimumSpeedToArriveOnTime.minSpeedOnTime(new int[]{1,1,100000}, 2.01));

    }
}
