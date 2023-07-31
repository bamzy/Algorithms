package info.bamzy;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequentTest {
    private LongestCommonSubsequent longestCommonSubsequent;
    @Before
    public void setUp(){
        longestCommonSubsequent = new LongestCommonSubsequent();
    }

    @Test
    public  void runTest(){
        assertEquals(3, longestCommonSubsequent.longestCommonSubsequence("abcde","ace"));
        assertEquals(0, longestCommonSubsequent.longestCommonSubsequence("abc","def"));

    }
}


