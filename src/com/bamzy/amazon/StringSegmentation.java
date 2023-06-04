package com.bamzy.amazon;

import java.util.HashMap;
import java.util.HashSet;

/**
 * You are given a dictionary of words and a large input string.
 * You have to find out whether the input string can be completely segmented
 * into the words of a given dictionary.
 * The following two examples elaborate on the problem further.
 *
 * Given a dictionary of words.
 *
 * apple
 * apple
 * pear
 * pie
 * Input string of “applepie” can be segmented into dictionary words.
 * apple
 * pie
 *
 *
 * Input string “applepeer” cannot be segmented into dictionary words.
 * apple
 * peer
 *
 * [apple,lep,applepa,b]
 */
public class StringSegmentation {

    public boolean check(HashSet<String> dict, String target){
        if (dict.contains(target)) return true;
        for (int i =0 ;i< target.length();i++){
            String substring = target.substring(0, i);
            if( dict.contains(substring))  {
                boolean res = check(dict,target.substring(i));
                if (res) return true;
            }
        }
        return false;
    }
}
