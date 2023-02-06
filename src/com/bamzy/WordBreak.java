package com.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 */
public class WordBreak {
    boolean result = false;
    Boolean[] mem;
    public boolean wordBreak(String s, List<String> wordDict) {
//        "applepen"
         mem = new Boolean[s.length()];

        HashSet<String> hash = new HashSet<>();
        for(int i=0;i<wordDict.size();i++ ){
            hash.add(wordDict.get(i));
        }
        return rec(s,0,hash);
    }

    public boolean rec(String s,int index,HashSet<String> wordDict){

        int len = s.length();
        if(this.mem[index]!=null) return this.mem[index];
        if(index>= len) return true;
        if(wordDict.contains(s.substring(index))) return true;
        boolean thisresut = false;
        for(int i = index+1;i<=len;i++){
            if (i<len && s.charAt(i)==' ') continue;
            if (wordDict.contains(s.substring(index,i))) {
                boolean nextRes =  rec(s,i,wordDict);
                thisresut = nextRes|| thisresut;
                if(nextRes) {
                    this.mem[index]=true;
                    return true;
                }
            }
        }
        this.mem[index] = thisresut;
        return thisresut;
    }
    public static void runTest(){
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
        System.out.println(wb.wordBreak("applepen", Arrays.asList("apple", "pen")));
        System.out.println(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wb.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        System.out.println(wb.wordBreak("goalspecial", Arrays.asList("go","goal","goals","special")));
    }
}
