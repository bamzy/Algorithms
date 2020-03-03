package com.bamzy;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            int index  = i ;
            while (index < s.length()){
                if (!chars.contains(s.charAt(index))) {
                   chars.add(s.charAt(index));
                   size = Math.max(index-i+1, size);
                } else {
                   chars.clear();
                   break;
                }
                index++;
            }
        }
        return size;




    }
}
