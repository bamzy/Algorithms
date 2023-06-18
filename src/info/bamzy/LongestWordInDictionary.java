package info.bamzy;

import java.util.*;

/**
 * Given an array of strings words representing an English Dictionary,
 * return the longest word in words that can be built one character at a
 * time by other words in words.
 *
 * If there is more than one possible answer, return the longest word with the smallest
 * lexicographical order. If there is no answer, return the empty string.
 *
 * Note that the word should be built from left to right with each additional character
 * being added to the end of a previous word.
 *
 *
 *
 * Example 1:
 * Input: words = ["w","wo","wor","worl","world"]
 * Output: "world"
 * Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 *
 * Example 2:
 * Input: words = ["a","banana","app","appl","ap","apply","apple"]
 * Output: "apple"
 * Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 *
 */
public class LongestWordInDictionary {

    HashSet<String> map = new HashSet<>();
    public String longestWord(String[] words) {
//        Arrays.sort(words);
        HashSet<String> dict = new HashSet<>(Arrays.asList(words));
        String ans="";
        int max = Integer.MIN_VALUE;
        for (String word : words) {
            if(word.length()<max) continue;
            if(recCheck(word,dict)){
                map.add(word);
                if(max<word.length() || ( max==word.length() && word.compareTo(ans)<0 ) ){
                    ans = word;
                    max = word.length();
                }
            }
        }
        return ans;
    }
    public boolean recCheck(String word,HashSet<String> dict){
        if(word.equals("")) return true;
        if(map.contains(word)) return true;
        if(dict.contains(word)) return recCheck(word.substring(0,word.length()-1),dict);
        return false;
    }
}
