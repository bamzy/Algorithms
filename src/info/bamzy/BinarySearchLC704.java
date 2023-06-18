package info.bamzy;
/*
Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.*/
public class BinarySearchLC704 {
    private long[] input;
    public BinarySearchLC704(long[] input){
        this.input = input;
    }
    public int findIndexBinarySearch(long target){
        return recsearch(input,target,0,input.length-1);

    }
    public int recsearch(long[] input,long target,int beg,int end){
        if (end<beg) return -1;
        if (end==beg&&input[end]!=target) return -1;
        int mid = (beg+end)/2;
        if (input[mid]==target) return mid;

        if (input[mid]<target) return recsearch(input,target,mid+1, end);
        else if (input[mid]>target) return recsearch(input,target,beg, mid);
        return -1;

    }


}
