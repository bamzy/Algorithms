package com.bamzy;

import java.util.HashMap;

/**
 * find the longest substring in a given string which only has k distinct characters
 */
public class LongestSubstringWithKDistinctVals {
    public int solve(String a, int k){
        int max = 1;
        if (a.length()==0) return 0;
        HashMap<Character,Integer> tmp = new HashMap<>();
        for (int i =0;i<a.length();i++){
            tmp.clear();
            tmp.put(a.charAt(i),1);
            for(int j=i+1;j<a.length();j++) {
                if (tmp.containsKey(a.charAt(j))) tmp.put(a.charAt(i), tmp.get(a.charAt(j)) + 1);
                else tmp.put(a.charAt(j),1);
                if(tmp.size()>k) {
                    break;
                } else {
                    max = Math.max(j-i+1,max);

                }
            }

        }
        return max;
    }
    /**
    /** this one is O(n)
     /** aabbcc , 1
     **/
    public int solve2(String a, int k){
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int start=0,end=0;
        for(int i=0;i<a.length();i++){
            if(!map.containsKey(a.charAt(end))) map.put(a.charAt(end),1);
            else map.put(a.charAt(end),map.get(a.charAt(end))+1);
            if (map.size()>k){
                if(map.containsKey(a.charAt(start))){
                    map.put(a.charAt(start),map.get(a.charAt(start))-1);
                    if(map.get(a.charAt(start))<=0) map.remove(a.charAt(start));
                }
                start++;
            } else {
                max = Math.max(max,end-start+1);
            }
            end++;
        }
        return max;
    }
    public static void runTest(){
        LongestSubstringWithKDistinctVals l = new LongestSubstringWithKDistinctVals();
        System.out.println(l.solve2("ababccde",1));
        System.out.println(l.solve2("ababccde",2));
        System.out.println(l.solve2( "aabbcc", 2));
    }
}
