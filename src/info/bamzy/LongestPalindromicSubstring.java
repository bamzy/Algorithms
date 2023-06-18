package info.bamzy;

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
    public String longestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 0,len1,len2,len,finalStart=0,finalEnd=0;
        for (int i=0 ; i<s.length()-1 ; i++){
             len1 = expand(chars,i,i);
             len2 = expand(chars,i,i+1);
             len = Math.max(len1,len2);
            if (len > finalEnd - finalStart) {
                finalStart = i - (len - 1) / 2;
                finalEnd = i + len / 2;
            }
        }
        return s.substring(finalStart,finalEnd+1);
    }

    private int expand(char[] input, int start, int end) {
        int size = 0;
        while ( start >= 0 && end < input.length && input[start] == input[end]){
            start--;
            end++;
        }
        return end-start-1;
    }
}
