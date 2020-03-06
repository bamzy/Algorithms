package com.bamzy;

public class LongestPalindromicSubstring {
    //bafcfabad
    public String longestPalindrome(String s) {
        int length = s.length(), finalStart = 0, finalEnd=0, size = 0, counter = 0;
        boolean[][] dpTable = new boolean[s.length()][s.length()];
        for (int i = length ; i > 0 ; i-- ) {
            for (int j = 0 ; j < i ;j++){
                if (counter == 0)
                    dpTable[j][j+counter] = true;
                if (counter == 1 && s.charAt(j) == s.charAt(j+counter) )
                    dpTable[j][j+counter] = true;
                if (counter > 1 && dpTable[j+1][j+counter-1] && s.charAt(j) == s.charAt(j+counter) )
                    dpTable[j][j+counter] = true;
                if (dpTable[j][j+counter]) {
                    if (counter+1> size){
                        size = counter+1;
                        finalStart = j;
                        finalEnd = j+counter;
                    }
                }
            }
            counter++;
        }
        return s.substring(finalStart,finalEnd+1);
    }

}
