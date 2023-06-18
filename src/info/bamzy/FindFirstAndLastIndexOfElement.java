package info.bamzy;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


 */
public class FindFirstAndLastIndexOfElement {
    private int earliest = Integer.MAX_VALUE;
    private int latest = Integer.MIN_VALUE;
    public int[] searchRange(int[] nums, int target) {
        recSearch(nums,0,nums.length-1,target);
        if(earliest == Integer.MAX_VALUE) earliest = -1;
        if(latest == Integer.MIN_VALUE) latest = -1;
        return new int[]{earliest,latest};
    }
    private void recSearch(int[] nums, int start,int end,int target){
        if(start > end) return;
        if (end>=nums.length) return;

        int middleIndex = (start+end)/2;
        if(nums[middleIndex]>target ){
            recSearch(nums,start,middleIndex-1,target);
        } else if (nums[middleIndex]< target){
            recSearch(nums,middleIndex+1,end,target);
        } else {
            earliest = Math.min(middleIndex, earliest);
            latest = Math.max(middleIndex, latest);
            recSearch(nums,middleIndex+1,end,target);
            recSearch(nums,start,middleIndex-1,target);
        }
    }
    public static void runTest(){
        FindFirstAndLastIndexOfElement f = new FindFirstAndLastIndexOfElement();
        System.out.println(f.searchRange(new int[]{5,7,7,8,8,10},8));
        System.out.println(f.searchRange(new int[]{5,7,7,8,8,10},6));
        System.out.println(f.searchRange(new int[]{},0));
    }
}
