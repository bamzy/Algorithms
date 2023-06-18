package info.bamzy;

import info.bamzy.amazon.StringSegmentation;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class StringSegmentationTest {
    private StringSegmentation stringSegmentation;
    @Before
    public void setUp(){
        stringSegmentation = new StringSegmentation();
    }

    @Test
    public  void runTest(){
        HashSet<String> dict = new HashSet<>();
        dict.add("apple");
        dict.add("lep");
        dict.add("applepa");
        dict.add("b");
        assertEquals(true, stringSegmentation.check(dict,"applepab"));
        assertEquals(false, stringSegmentation.check(dict,"applepie"));
        assertEquals(false, stringSegmentation.check(dict,"appl"));

    }
}
