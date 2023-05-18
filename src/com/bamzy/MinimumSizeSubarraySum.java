package com.bamzy;
/*
209. Minimum Size Subarray Sum
Medium

Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.



Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0,  end = 0;
        int sum = nums[0];
        int minLength = Integer.MAX_VALUE;
        // [2,3,1,2,4,3]
        // start: 0   0   0   0   1   2  3  3  4
        // end  : 0   1   2   3   4   4  4  5
        // sum   : 2  5   6   8   6  10  6  9
        // min                4      4      3
        while (end>=start && end<nums.length && start< nums.length ){
            if(sum>= target){
                minLength= Math.min(end-start+1,minLength);
                sum = sum - nums[start];
                start++;

            } else {

                end++;
                if(end<nums.length) sum = sum + nums[end];
            }
        }
        return (minLength== Integer.MAX_VALUE)? 0: minLength ;
    }
    public static void runTest(){
        MinimumSizeSubarraySum mn = new MinimumSizeSubarraySum();
        System.out.println(mn.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        System.out.println(mn.minSubArrayLen(4,new int[]{1,4,4}));
        System.out.println(mn.minSubArrayLen(20,new int[]{1,1,1,1,1,1,1}));
    }
}
