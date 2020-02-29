package com.bamzy;
/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.
Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> findThreeSum(int[] nums) {
        HashMap<Integer, Integer> numbers= new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        int tempSum;
        for (int num : nums) {
            if (numbers.containsKey(num)){
                numbers.put(num, numbers.get(num)+1);
            } else
                numbers.put(num, 1);
        }
        for (int i = 0 ; i < nums.length - 1 ; i++){
            for (int j = +1 ; j < nums.length ; j++){
                tempSum = nums[i]+nums[j];
                if (numbers.containsKey(-tempSum)){
                    ArrayList<Integer> node = new ArrayList<>();
                    node.add(nums[i]);
                    node.add(nums[j]);
                    node.add(-tempSum);
                    results.add(node);
                }
            }
        }
        return results;

    }
}
