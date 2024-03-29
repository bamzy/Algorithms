package info.bamzy;

/**
 * 1143. Longest Common Subsequence
 * Medium
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 */
public class LongestCommonSubsequent {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(),len2=text2.length();
        int[][] dp = new int[len1][len2];
        int initval = 0;
        for(int j=0;j<len2;j++){
            if(text1.charAt(0)==text2.charAt(j)) {
                initval = 1;
            }
            dp[0][j]=initval;
        }
        initval= 0;
        for(int i=0;i<len1;i++ ){
            if(text1.charAt(i)==text2.charAt(0)) initval=1;
            dp[i][0] = initval;
        }

        for(int i=1;i<len1;i++ ){
            for(int j=1;j<len2;j++){
                if(text1.charAt(i)==text2.charAt(j)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1-1][len2-1];
    }
}
