package info.bamzy;
/*
Given an unsorted array return whether an increasing subsequence of
length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
*/
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid=Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if (nums[i] < min)
                min = nums[i];
            else if (nums[i]>min && nums[i]<mid )
                mid = nums[i];
            else if (nums[i] > mid)
                return true;
        }
        return false;
    }
}
