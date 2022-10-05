package com.bamzy;

import java.util.HashSet;

/*
* You are given a dictionary of words and a large input string.
* You have to find out whether the input string can be completely segmented
* into the words of a given dictionary. The following two examples elaborate on
* the problem further.

Given a dictionary of words.

apple
apple
pear
pie
Input string of “applepie” can be segmented into dictionary words.

apple
pie
Input string “applepeer” cannot be segmented into dictionary words.

apple
peer
* */
public class StringSegmentations {
    public boolean segment(HashSet<String> dictionary, String input){
        for (int i = 1; i < input.length(); i++){
            if (dictionary.contains(input.substring(0,i))) {
                if (input.substring(i)==""||dictionary.contains(input.substring(i))) return true;
            }
            return segment(dictionary, input.substring(i));

        }
        return false;
    }
    public boolean sovle2(HashSet<String> dictionary, String input){
        int begin = 0;
        if (input == "") return true;
        int end = begin+1;
        for (int i=0;i<=input.length();i++){

            String firstWord = input.substring(0,i);
            String secondWord = "";
            if(i<input.length()) secondWord = input.substring(i);
            if(firstWord=="" || dictionary.contains(firstWord)) {
                if(dictionary.contains(secondWord)||secondWord=="") return true;

            }
        }
        return false;
    }
    public boolean betterSegment(HashSet<String> dictionary, String input){
        if(sovle2(dictionary,input)) return true;
        for (int i=1;i<=input.length();i++){
            if(sovle2(dictionary,input.substring(0,i)) ) return betterSegment(dictionary,input.substring(i));
        }
        return false;
    }
}
