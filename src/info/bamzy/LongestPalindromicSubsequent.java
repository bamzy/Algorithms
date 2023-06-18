package info.bamzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
516. Longest Palindromic Subsequence
Medium
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or
no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

 */
public class LongestPalindromicSubsequent {
    HashMap<String , Boolean> map ;
    public String longestSubstringPalindrome(String s){
        map = new HashMap<>();
        int max = 0;
        String res = "";

        for (int i=0;i<s.length();i++)
            for (int j=i;j<s.length();j++){

                if (ispalindrome(s,i,j) && j-i+1>max) {
                    max = j-i+1;
                    res = s.substring(i,j+1);
                }

            }
        return res;
    }
    // bcdcba

    private boolean ispalindrome(String s, int i, int j){
        String key = i + "|" + j;
        if (map.containsKey(key)) return map.get(key);
        boolean res = false;
        if(j<i) res = false;
        else if(i==j) res= true;
        else if(j==i+1 && s.charAt(i) == s.charAt(j) ) res= true;
        else res = (s.charAt(i)==s.charAt(j) && ispalindrome(s,i+1,j-1));

        map.put(key,res);
        return res;
    }
    public List<String> getAllSubsequentString(String s){
        List<String> result = new ArrayList<>();
        recGen(0,s,"",result);
        return result;


    }

    private void recGen(int i, String s, String current, List<String> result) {
        if(i==s.length()) {
            result.add(current);
            return;
        }
        recGen(i+1,s,current,result);
        recGen(i+1,s,current+s.charAt(i),result);

    }
    HashMap<String, Integer> memo ;
    public int longestSubsequentPalindrome(String s, int i , int j){
        int res = 0;
        if (j<i) return 0;
        String key = i + "|" + j;
        if (memo.containsKey(key)) return memo.get(key);
        if (i==j) {
            res = 1;
        } else {
            if (s.charAt(i) == s.charAt(j)) return 2 + longestSubsequentPalindrome(s, i + 1, j - 1);
            else {
                res = Math.max(longestSubsequentPalindrome(s, i + 1, j), longestSubsequentPalindrome(s, i, j - 1));
            }
        }
        memo.put(key,res);
        return res;
    }

    public int solutionForLongestSubsequentString(String s){
        memo =new HashMap<>();
        HashSet<Character> a = new HashSet<>();
        return longestSubsequentPalindrome(s,0,s.length()-1);
    }


}
