package info.bamzy;

import info.bamzy.facebook.SquaredArraySort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SquaredArraySortTest {
    private SquaredArraySort squaredArraySort;
    @Before
    public void setUp(){
        squaredArraySort = new SquaredArraySort();
    }

    @Test
    public  void runTest(){
       assertArrayEquals(new int[]{0,1,9,16,100},squaredArraySort.solve(new int[]{-10,-4,-3,-1,0}));
       assertArrayEquals(new int[]{0,1,9,16,100},squaredArraySort.solve(new int[]{-4,-1,0,3,10}));

    }
}
