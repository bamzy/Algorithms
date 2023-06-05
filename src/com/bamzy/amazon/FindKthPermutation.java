package com.bamzy.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 10. Find Kth permutation
 * Given a set of ‘n’ elements, find their Kth permutation.
 * Consider the following set of elements:
 *
 *  [1,2,3]
 *  All permutations of the above elements are (with ordering):
 *  1st: 123
 *  2nd: 132
 *  3rd: 213
 *  4th: 231
 *  5th: 312
 *  6th: 321
 */
public class FindKthPermutation {
    //1,2,3,4
    // len = 4                 3    2
    // restFact = 6            2    1
    // index = 12-1 /6 == 1    2    1
    // k = 12-6 == 6           2    1
    // res = 2                 24
    public int[] solve(int[] digits,int k){
        Arrays.sort(digits);
        int counter = 0;
        int[] result = new int[digits.length];
        int start  = 0;
        if(k>factorial(digits.length) ) k = k%factorial(digits.length);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : digits) list.add(i);
        while(list.size()>0){
            int len = list.size();
            int restFact = factorial(len-1);
            int index = (k - 1) / restFact;

            result[counter++] = list.remove(index);
            k = k- index*restFact;
            if(k<0) k= 0;
        }
        return result;
    }
    int factorial(int n){
        if(n==1 || n==0) return 1;
        else return n*factorial(n-1);
    }
}
