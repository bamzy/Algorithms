package info.bamzy;

import info.bamzy.amazon.ReverseWordsInSentence;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReverseWordsInSentenceTest {
    private ReverseWordsInSentence reverseWordsInSentence;
    @Before
    public void setUp(){
        reverseWordsInSentence = new ReverseWordsInSentence();
    }

    @Test
    public  void runTest(){

        String reverse = reverseWordsInSentence.reverse("| Hello Worlds |");
        assertEquals(0,"| Worlds Hello |".compareTo(reverse));

    }
}
