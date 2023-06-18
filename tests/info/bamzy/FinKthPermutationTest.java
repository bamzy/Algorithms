package info.bamzy;

import info.bamzy.amazon.FindKthPermutation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinKthPermutationTest {
    private FindKthPermutation findKthPermutation;
    @Before
    public void setUp(){
        findKthPermutation = new FindKthPermutation();
    }

    @Test
    public  void runTest(){


        int[] solve3 = findKthPermutation.solve(new int[]{1, 2, 3,4}, 12);
        int[] solve = findKthPermutation.solve(new int[]{1, 2, 3}, 5);
        int[] solve2 = findKthPermutation.solve(new int[]{1, 2, 3}, 6);
        assertEquals(3, solve[0]);
        assertEquals(1, solve[1]);
        assertEquals(2, solve[2]);

        assertEquals(3, solve2[0]);
        assertEquals(2, solve2[1]);
        assertEquals(1, solve2[2]);

        assertEquals(2, solve3[0]);
        assertEquals(4, solve3[1]);
        assertEquals(3, solve3[2]);
        assertEquals(1, solve3[3]);


    }
}
