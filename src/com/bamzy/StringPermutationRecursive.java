package com.bamzy;

import java.util.ArrayList;

/*
Example: Design an algorithm to print all permutations of a string. For simplicity, assume all characters are unique.
Consider a test string abcdefg.
Case "a" --> {"a"}
Case "ab" - -> {"ab", "ba"}
Case "abc" --> {"abc","acb","bac","bca","cab","cba"}
 */
public class StringPermutationRecursive {

    public ArrayList<String> solve(String input){
        ArrayList<String> result = new ArrayList<>();
        findAllPermutation(result,"",input);
        return result;
    }
    public void findAllPermutation(ArrayList<String> result ,String prefix,String input){
        if(input.length()==1) result.add(prefix+input);
        for (int i=0;i<input.length();i++){
            findAllPermutation(result, prefix + input.charAt(i),except(input,i)) ;
        }

    }
    public String except(String input,int index){
        return input.substring(0,index)+input.substring(index+1);
    }
}
