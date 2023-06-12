package com.bamzy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StringDuplicateRemovalByCount {
    //assassin
    String solve(String s, int k){
        boolean search = true;
        if(k==1) return "";
        if(k>s.length()) return s;
        Stack<Character> q = new Stack<>();

        //s : assb
        //q: a            s    ss
        // current :      s     s
        // begIndex :     1     1
        // endIndex:      0     2
        while (search && s.length()>0){
            search=false;
            q.clear();
            q.push(s.charAt(0));
            int begDuplicateIndex=0,endDuplicateIndex=0;
            for(int i =1 ;i < s.length();i++){
                Character currentChar = s.charAt(i);
                if(q.peek() == currentChar) {
                    q.push(currentChar);
                    endDuplicateIndex = i;
                } else {
                    q.clear();
                    q.push(currentChar);
                    begDuplicateIndex = i;
                }
                if(q.size()==k && endDuplicateIndex>=begDuplicateIndex){
                    search = true;
                    s = s.substring(0,begDuplicateIndex)+s.substring(endDuplicateIndex+1);

                    break;
                }
            }
        }
        return s;

    }
}
