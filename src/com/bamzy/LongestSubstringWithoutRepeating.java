package com.bamzy;

import javax.swing.*;
import java.util.*;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, size = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex,-1);
        while (end < s.length()){
            if (charIndex[s.charAt(end)] == -1 || (charIndex[s.charAt(end)] != -1 && charIndex[s.charAt(end)] < start)){
                charIndex[s.charAt(end)] = end++;
                size = Math.max(size, end-start);
            } else {
                start = charIndex[s.charAt(end)]+1;
                charIndex[s.charAt(end)] = end++;
            }
        }
        return size;

    }
}
