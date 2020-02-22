package com.bamzy;

import java.util.HashMap;

public class ContainsDuplicates {
    boolean containsDuplicates(int[] a) {
        HashMap<Integer, Integer> counters = new HashMap<>();
        for (int i : a) {
            if (counters.containsKey(i))
                    return true;
            else
                counters.put(i,1);
        }
        return false;
    }
    boolean sumOfTwo(int[] a, int[] b, int v) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i : a) {
            if (!numbers.containsKey(i))
                numbers.put(i,1);
            else
                numbers.put(i,numbers.get(i)+1);
        }
        for (int i : b) {
            if (numbers.containsKey(v-i))
                return true;
        }
        return false;
    }

    int sumInRange(int[] nums, int[][] queries) {
        int sums[] = new int[nums.length];
        int tempSum = 0;
        for (int i = 0; i < nums.length ; i++){
            tempSum = tempSum + nums[i];
            sums[i] = tempSum;
        }
        int finalSum = 0;
        for (int[] query : queries) {
            finalSum = finalSum + (sums[query[1]]-sums[query[0]]);
        }
        return finalSum;
    }



}
