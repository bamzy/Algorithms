package info.bamzy.google;

/***
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegularExpression {
    //a..d    abcd
    // a*b    aaaaaab
    public boolean match(String input, String p){
        if(input.isEmpty()) return p.isEmpty();
        if(!p.isEmpty() ) {
            boolean firstLetterMatches = p.charAt(0) == '.' || p.charAt(0) == input.charAt(0);
            if (p.length()>1 && p.charAt(1) == '*'){
               return firstLetterMatches && match(input.substring(1),p);
            }
            if (firstLetterMatches)
                return match(input.substring(1), p.substring(1));
            else return false;
        }
        return false;
    }

    public boolean solve(String input, String p){
        String newInput = input;
        return match(input,p);
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void runTest(){
        RegularExpression regex = new RegularExpression();
        System.out.println(regex.solve("aa","a"));
        System.out.println(regex.solve("abc","a..d"));
        System.out.println(regex.solve("aaa","a*a"));
        System.out.println(regex.solve("bfsadfasdbbb","b.*"));
//        System.out.println(regex.isMatch("abc","a..d"));
    }
}
