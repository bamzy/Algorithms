package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HIndexFinderTest {
    private HIndexFinder hIndexFinder;
    @Before
    public void setUp(){
        hIndexFinder = new HIndexFinder();
    }

    @Test
    public  void runTest(){

        assertEquals(3, hIndexFinder.hIndex(new int[]{3,0,6,1,5}));
        assertEquals(1, hIndexFinder.hIndex(new int[]{1,3,1}));
    }
}
