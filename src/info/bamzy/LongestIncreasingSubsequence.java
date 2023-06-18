package info.bamzy;
/*
Given an unsorted array of integers, find the length of
longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101],
therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary
for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE, count;
        for (int i = 0; i < nums.length ; i++) {
            int first = nums[i];
            count = 1;
            for (int j = i; j<nums.length ; j++){
                int second = nums[j];
                if (first < second){
                    first = second;
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
