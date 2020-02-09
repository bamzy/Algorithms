package com.bamzy;

import java.util.HashMap;

/*This class returns the longest consecutive set of elements in an array*/
public class LongestConsecutiveSequence {
    public int getLongestSubsetSize(int[] input){
        int maxSize = 0;
        int tempSize;
        HashMap<Integer,Boolean> list = new HashMap<>();
        // Initialize the hashmap
        for (int value : input) {
            list.put(value,false);
        }

        // Find elements that are smaller than something
        for (int value : input) {
            if (list.containsKey(value+1)  )
                list.put(value,true);
        }

        // Find elements that are bigger that something
        for (int value : input) {
            if (list.containsKey(value-1) )
                list.put(value,false);
        }
        for (int value : input) {
            tempSize = 0;
            int temp = value;
            if (list.get(value) == true )
                while (true){
                    if (list.containsKey(temp+1) ) {
                        tempSize++;
                        temp++;
                    } else {
                        break;
                    }
                }
                if (tempSize > maxSize)
                    maxSize = tempSize;
        }

        return maxSize;
    }
}
