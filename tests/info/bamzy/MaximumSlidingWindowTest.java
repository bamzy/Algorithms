package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MaximumSlidingWindowTest {
    private MaximumSlidingWindow maximumSlidingWindow;
    @Before
    public void setUp(){
        maximumSlidingWindow = new MaximumSlidingWindow();
    }

    @Test
    public  void runTest(){
        int[] tmp = maximumSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        assertArrayEquals(tmp, new int[]{3,3,5,5,6,7});
        int[] tmp1 = maximumSlidingWindow.maxSlidingWindow(new int[]{1}, 1);
        assertArrayEquals(tmp1, new int[]{1});
    }
}
