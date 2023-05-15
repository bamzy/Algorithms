package com.bamzy;

import java.util.ArrayList;
import java.util.List;

/*
39. Combination Sum
Medium

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []

 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(candidates,target,0,0,new ArrayList<>());
        return result;
    }
    ///[2,3,6,7]
    public void rec(int[] candidates, int target, int sumSoFar, int index,List<Integer> tmpResult){
        if (sumSoFar> target) return;

        if(target==sumSoFar){
            result.add(tmpResult);
            return;
        }
        if(index>=candidates.length) return ;
        int thisNumber = candidates[index];
        int counter = 0;
        List<Integer> current = new ArrayList<>(tmpResult);
         rec(candidates,target,sumSoFar,index+1,current);
         int upperBound = (target-sumSoFar)/thisNumber;
        while (counter < upperBound){
            sumSoFar = sumSoFar+thisNumber;
            current.add(thisNumber);
            rec(candidates,target,sumSoFar,index+1,current);
            counter++;

        }
    }
    public static void runTest(){
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> temp = cs.combinationSum(new int[]{2, 3, 5, 7}, 7);
        System.out.println();
    }

}
