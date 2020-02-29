package com.bamzy;

import java.math.BigInteger;
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
        BigInteger big = new BigInteger("1000000007");
        BigInteger sums[] = new BigInteger[nums.length+1];
        sums[0] = BigInteger.valueOf(0);
        BigInteger tempSum = BigInteger.valueOf(0);
        for (int i = 0; i < nums.length ; i++){
            tempSum = tempSum.add(BigInteger.valueOf(nums[i])) ;
            sums[i+1] = tempSum;
        }
        BigInteger finalSum= BigInteger.valueOf(0);
        for (int[] query : queries) {
            finalSum = finalSum.add(sums[query[1] + 1].subtract(sums[query[0]]) )  ;
        }
        return finalSum.mod(big).intValue();
    }



}
