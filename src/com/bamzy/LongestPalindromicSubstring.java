package com.bamzy;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0, end=0, length = s.length(), finalStart = 0, finalEnd = 0, size = 0;
        char[] input = s.toCharArray();
        while (start < length && end < length){
            if (isPalindrome(input, start,end++)){
                if (end - start > size)
                {
                    size = end - start;
                    finalEnd = end;
                    finalStart = start;
                }

            } else
                start++;
        }
        return new String(input).substring(finalStart,finalEnd);
    }

    private boolean isPalindrome(char[] input, int start, int end) {
        if (end == start)
            return true;
        while (end >= start){
            if (input[end] == input[start]){
                end--;
                start++;
            } else
                return false;

        }
        return true;
    }
}
