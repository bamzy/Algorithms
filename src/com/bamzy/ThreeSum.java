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
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> findThreeSum(int[] nums) {
        HashMap<Integer, Integer> numbers= new HashMap<>();
        List<List<Integer>> tempResults = new ArrayList<>();
        List<List<Integer>> finalResults = new ArrayList<>();
        int tempSum;
        for (int num : nums) {
            if (numbers.containsKey(num)){
                numbers.put(num, numbers.get(num)+1);
            } else
                numbers.put(num, 1);
        }
        for (int i = 0 ; i < nums.length - 1 ; i++){
            for (int j = i+1 ; j < nums.length ; j++){
                tempSum = nums[i]+nums[j];
                if (numbers.containsKey(-tempSum)){
                    ArrayList<Integer> temp = null;
                    if (nums[i] != nums[j] && nums[j] != -tempSum && nums[i] != -tempSum)
                        temp = createList(tempSum, nums[i], nums[j]);
                     else if (nums[i] == nums[j] && nums[i] == -tempSum && numbers.get(nums[i]) >=3)
                        temp = createList(tempSum, nums[i], nums[j]);
                     else if (nums[i] == nums[j] && nums[i] != -tempSum && numbers.get(nums[i]) >=2)
                        temp = createList(tempSum, nums[i], nums[j]);
                    else if (nums[i] == -tempSum && nums[i] != nums[j] && numbers.get(nums[i]) >=2)
                        temp = createList(tempSum, nums[i], nums[j]);
                    else if (-tempSum == nums[j] && nums[i] != -tempSum && numbers.get(nums[j]) >=2)
                        temp = createList(tempSum, nums[i], nums[j]);
                    if (temp != null && !tempResults.contains(temp))
                        tempResults.add(temp);
                }
            }
        }
        return tempResults;
    }

    private ArrayList<Integer> createList(int tempSum, int num, int num1) {
        ArrayList<Integer> node = new ArrayList<>();
        node.add(num);
        node.add(num1);
        node.add(-tempSum);
        Collections.sort(node);
        return node;
    }

    private boolean isDuplicate(List<Integer> first, List<Integer> second) {
//        List<Integer> temp = new ArrayList<>(second);
        HashMap<Integer, Integer> dups = new HashMap<>();
        for (int i=0;i<first.size();i++) {
            if (!dups.containsKey(first.get(i)))
                dups.put(first.get(i), 1);
            else
                dups.put(first.get(i), dups.get(first.get(i)) + 1);
        }
        for (int i=0;i<second.size();i++) {
            if (!dups.containsKey(second.get(i)))
                return false;
            else
                dups.put(second.get(i), dups.get(second.get(i)) - 1);
        }

        if (dups.get(first.get(0)) < 0 || dups.get(first.get(1)) < 0 || dups.get(first.get(2)) < 0)
            return false;
        return true;
    }
}
