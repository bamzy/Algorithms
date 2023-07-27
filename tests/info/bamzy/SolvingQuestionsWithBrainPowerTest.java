package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolvingQuestionsWithBrainPowerTest {
    private SolvingQuestionsWithBrainPower solvingQuestionsWithBrainPower;
    @Before
    public void setUp(){
        solvingQuestionsWithBrainPower = new SolvingQuestionsWithBrainPower();
    }

    @Test
    public  void runTest(){
        assertEquals(5, solvingQuestionsWithBrainPower.mostPoints(new int[][]{new int[]{3,2}, new int[]{4,3},new int[]{4,4},new int[]{2,5}}));
        assertEquals(7, solvingQuestionsWithBrainPower.mostPoints(new int[][]{new int[]{1,1}, new int[]{2,2},new int[]{3,3},new int[]{4,4},new int[]{5,5}}));
        assertEquals(79, solvingQuestionsWithBrainPower.mostPoints(new int[][]{new int[]{12,46}, new int[]{78,19},new int[]{63,15},new int[]{79,62},new int[]{13,10}}));

    }
}
