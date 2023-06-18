package info.bamzy;
/*
16. 3Sum Closest
Medium

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=0;
        int dist = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(nums));
        for (int i =0;i<nums.length;i++){
            int currentNumber  = nums[i];
            int closest = _sum2Closest(nums,i,target-currentNumber)+currentNumber;
            if (Math.abs( closest-target)<dist){
                dist = Math.abs( closest-target);
                res = closest;
            }
        }
        return res;
    }

    //[-4,-2,-1,2,3,5,5], t=2,index=0
    //left : 1  1   1   2
    //right: 6  5   4   4
    private int _sum2Closest(int[] nums,int index, int target){
        int left=0,right=nums.length-1;
        int sum=0;
        while (left<right){
            if (left==index) {left++; continue;}
            if (right==index) {right--;continue;}
            sum = nums[left]+nums[right];
            if (sum==target) return sum;
            else if (sum<target) left++;
            else right--;
        }
        return sum;
    }


}
