package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class EggDropTest {
    private EggDrop eggDrop;
    @Before
    public void setUp(){
        eggDrop = new EggDrop();
    }

    @Test
    public  void runTest(){
       assertEquals(2, eggDrop.solve_recursive(2,2));
       assertEquals(14, eggDrop.solve_recursive(2,100));
       assertEquals(2, eggDrop.solve_recursive(2,3));
       assertEquals(3, eggDrop.solve_recursive(3,6));

    }
}
