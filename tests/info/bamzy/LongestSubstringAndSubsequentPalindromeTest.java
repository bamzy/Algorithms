package info.bamzy;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LongestSubstringAndSubsequentPalindromeTest {
    private LongestPalindromicSubsequent lps;
    @Before
    public void setUp(){
        lps = new LongestPalindromicSubsequent();
    }

    @Test
    public  void runTest(){

        assertEquals("a",lps.longestSubstringPalindrome("a"));
        assertEquals("bcdcb",lps.longestSubstringPalindrome("bcdcba"));
        assertEquals("abcdcba",lps.longestSubstringPalindrome("abcdcba"));
        assertEquals("aa",lps.longestSubstringPalindrome("aa"));
        assertEquals("aca",lps.longestSubstringPalindrome("aca"));
        assertEquals("",lps.longestSubstringPalindrome(""));
        assertEquals("zyz",lps.longestSubstringPalindrome("abcdzyzfgg"));
        assertEquals("zyyz",lps.longestSubstringPalindrome("abcdzyyzfgg"));
        assertEquals("bab",lps.longestSubstringPalindrome("babad"));
        assertEquals("bb",lps.longestSubstringPalindrome("cbbd"));


        assertEquals(4,lps.solutionForLongestSubsequentString("bbbab"));
        assertEquals(2,lps.solutionForLongestSubsequentString("cbbd"));
        assertEquals(4,lps.solutionForLongestSubsequentString("acfghbbda"));

    }
}
