package com.bamzy;
/*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
then reverse the first k characters and leave the other as original.



Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"


Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
 */
public class LTAssesment1Q1 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length();i = i+2*k){
            int end = i + 2 * k;
            int beg = i;
            String substr = "";
            if(end<=s.length()){
                 sb.append(revSubStr(s.substring(beg,beg+k)));
                 sb.append(s.substring(beg+k,end));
            } else {
                substr = s.substring(i);
                if (substr.length()<k){
                    sb.append(revSubStr(substr));
                } else if (substr.length()>=k && substr.length()<2*k){
                    sb.append(revSubStr(s.substring(beg,beg+k)));
                    sb.append(s.substring(beg+k));
                }

            }

        }
        return sb.toString();
    }
    public String revSubStr(String input){
        StringBuilder sb = new StringBuilder();
        for (int i=input.length()-1;i>=0;i--){
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

}
