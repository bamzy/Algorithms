package com.bamzy;

public class LongestPalindromicSubstring {
    //bafcfabad
    public String longestPalindrome(String s) {
        int length = s.length(), finalStart = 0, finalEnd = 0, size = 0, counter = 0;
        boolean[][] dpTable = new boolean[s.length()][s.length()];
        for (int i=0 ; i < length ; i++) {
                dpTable[i][i] = true;
        }

        char[] input = s.toCharArray();
        for (int i=0 ; i < length-1 ; i++){
            for (int j = i ; j < length; j++){
                if (isPalindrome(dpTable,input,i,j)){
                    if (size < j - i + 1){
                       finalEnd = j;
                       finalStart = i;
                       size = j-i+1;
                    }
                }
            }
        }
        return new String(input).substring(finalStart,finalEnd);
    }

    private boolean isPalindrome(boolean[][] dpTable,char[] input, int start, int end) {
        if (end == start) {
//            dpTable[start][end] = true;
            return true;
        }
        if (end - start == 1 && input[end] == input[start]){
            dpTable[start][end] = true;
            return true;
        }
        if (end-start > 1 && dpTable[start + 1][end - 1] && input[start] == input[end] ){
           dpTable[start][end] = true;
           return true;
        }
        dpTable[start][end] = false;
        return false;
    }
}
