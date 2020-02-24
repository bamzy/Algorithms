package com.bamzy;
/*You have two strings, s and t. The string t contains only unique elements.
Find and return the minimum consecutive substring of s that contains all of the elements from t.

It's guaranteed that the answer exists. If there are several answers, return the one which starts from the smallest index.

Example

For s = "adobecodebanc" and t = "abc", the output should be
minSubstringWithAllChars(s, t) = "banc".*/
public class MinSubstringWithAllChars {


    String minSubstringWithAllChars(String s, String t) {
        if (t.length() == 0)
            return "";
        int finalStart=0, finalEnd=0, finalSize = s.length()+1;
        for (int i=0; i< s.length(); i++){
            for (int j=i; j < s.length(); j++ ){
                if (checkAllCharsExist(s.substring(i, j+1),t) && (j-i+1) < finalSize ){
                    finalSize = j-i+1;
                    finalStart = i;
                    finalEnd = j+1;
                    break;
                }
            }
        }

        return s.substring(finalStart,finalEnd);
    }

    private boolean checkAllCharsExist(String tempText, String t) {
        for (int i=0; i< t.length(); i++){
            if (!tempText.contains(Character.toString(t.charAt(i))))
                return false;
        }
        return true;
    }

}
