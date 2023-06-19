package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExtraCharactersInStringTest {
    private ExtraCharactersInString extraCharactersInString;
    @Before
    public void setUp(){
        extraCharactersInString = new ExtraCharactersInString();
    }

    @Test
    public  void runTest(){

        assertEquals(3, extraCharactersInString.minExtraChar("sayhelloworld",new String[]{"hello","world"}));
        assertEquals(1, extraCharactersInString.minExtraChar("aacbb",new String[]{"aa","bb"}));
        assertEquals(1, extraCharactersInString.minExtraChar("leetscode",new String[]{"leet","code"}));
    }
}
