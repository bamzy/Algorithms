package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringDuplicateRemovalByCountTest {
    private StringDuplicateRemovalByCount stringDuplicateRemovalByCount;
    @Before
    public void setUp(){
        stringDuplicateRemovalByCount = new StringDuplicateRemovalByCount();
    }

    @Test
    public  void runTest(){
      assertEquals("in",stringDuplicateRemovalByCount.solve("assassin",2));
      assertEquals("",stringDuplicateRemovalByCount.solve("assassin",1));
      assertEquals("ab",stringDuplicateRemovalByCount.solve("ssab",2));
      assertEquals("abs",stringDuplicateRemovalByCount.solve("absss",2));
      assertEquals("ab",stringDuplicateRemovalByCount.solve("abssss",2));
      assertEquals("",stringDuplicateRemovalByCount.solve("assa",2));
      assertEquals("abcd",stringDuplicateRemovalByCount.solve("abcd",2));
      assertEquals("",stringDuplicateRemovalByCount.solve("aaaa",4));
      assertEquals("a",stringDuplicateRemovalByCount.solve("aaaa",3));

    }
}
