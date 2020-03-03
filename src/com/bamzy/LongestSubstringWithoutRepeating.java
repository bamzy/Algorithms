package com.bamzy;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, size = 0;
        Map<Character, Integer> charIndex = new HashMap<>();
        while (end < s.length()){
            if (!charIndex.containsKey(s.charAt(end)) || (charIndex.containsKey(s.charAt(end)) && charIndex.get(s.charAt(end)) < start)){
                charIndex.put(s.charAt(end), end++);
                size = Math.max(size, end-start);
            } else {
                start = charIndex.get(s.charAt(end))+1;
                charIndex.put(s.charAt(end),end++);
            }
        }
        return size;

    }
}
