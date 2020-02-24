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
    int modulo(int a){
        if (a > 0 )
            return a%100000007;
        else return 1000000007+a;
    }
    int sumInRange(int[] nums, int[][] queries) {
        BigInteger big = new BigInteger("1000000007");
        int sums[] = new int[nums.length+1];
        int tempSum = 0;
        for (int i = 0; i < nums.length ; i++){
            tempSum = tempSum + nums[i];
            sums[i+1] = tempSum;
        }
        int finalSum=0 ;
        for (int[] query : queries) {

            finalSum = finalSum + sums[query[1] + 1] - sums[query[0]];

        }
     BigInteger a  = new BigInteger(Integer.toString(finalSum));
        return a.mod(big).intValue();
    }



}
