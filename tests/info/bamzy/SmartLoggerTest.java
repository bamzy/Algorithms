package info.bamzy;

import info.bamzy.google.SmartLogger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmartLoggerTest {
    private SmartLogger logger;
    @Before
    public void setUp(){
        logger = new SmartLogger();
    }

    @Test
    public  void runTest(){
        assertEquals(true,logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        assertEquals(true,logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        assertEquals(false,logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        assertEquals(false,logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        assertEquals(false,logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        assertEquals(true,logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
        assertEquals(true,logger.shouldPrintMessage(11, "bamzy")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
        assertEquals(false,logger.shouldPrintMessage(11, "bar")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21


    }
}
