package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LongestWordInDictionaryTest {
    private LongestWordInDictionary longestWordInDictionary;
    @Before
    public void setUp(){
        longestWordInDictionary = new LongestWordInDictionary();
    }

    @Test
    public  void runTest(){
        List<Integer> answers = Arrays.asList(10, 12);
        assertEquals("apple", longestWordInDictionary.longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"}));
        assertEquals("world", longestWordInDictionary.longestWord(new String[]{"w","wo","wor","worl","world"}));
    }
}
