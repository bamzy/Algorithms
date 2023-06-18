package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MagicDictionaryTest {
    private MagicDictionary magicDictionary;
    @Before
    public void setUp(){

        magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"});
    }

    @Test
    public  void runTest(){
        List<Integer> answers = Arrays.asList(10, 12);
        assertEquals(false, magicDictionary.search("ba"));
    }
}
