package com.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

You may assume the input array always has a valid answer.



Example 1:

Input: nums = [3,5,2,1,6,4]
Output: [3,5,1,6,2,4]
Explanation: [1,6,2,5,3,4] is also accepted.
Example 2:

Input: nums = [6,6,5,6,3,8]
Output: [6,6,5,6,3,8]


Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 104
It is guaranteed that there will be an answer for the given input nums.


Follow up: Could you solve the problem in O(n) time complexity?
 */
public class LTGoogleAssesment2 {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        int median = kthSmallestNumber(nums, m);

        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (copy[j] < median) {
                swap(copy, i++, j++);
            } else if (copy[j] > median) {
                swap(copy, j, k--);
            } else {
                j++;
            }
        }

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }

    private int kthSmallestNumber(int[] nums, int k) {
        Random random = new Random();

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }

        int l = 0, r = nums.length - 1;
        k--;

        while (l < r) {
            int m = getMiddle(nums, l, r);

            if (m < k) {
                l = m + 1;
            } else if (m > k) {
                r = m - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int getMiddle(int[] nums, int l, int r) {
        int i = l;

        for (int j = l + 1; j <= r; j++) {
            if (nums[j] < nums[l]) swap(nums, ++i, j);
        }

        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    int findKthSmallestElement(int[] nums,int k){
        int newnums[] = pivotize(nums,0,nums.length-1,k);
        return newnums[k];
    }
    public int[] pivotize(int[] nums, int beg,int end,int k){
        int length = nums.length;
        if (k>length||k<0) return null;
        int pivotIndex = beg;
        int pivot = nums[pivotIndex];
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();
        int lastIndexOfBigger = beg;
        for(int i=beg+1;i<=end;i++){
            if(nums[i]<pivot) {
                smaller.add(nums[i]);
            } else bigger.add(nums[i]);
        }
        int finalIndex = smaller.size();
        smaller.add(pivot);
        smaller.addAll(bigger);
        int[] newnums = smaller.stream().mapToInt(i -> i).toArray();
        if(finalIndex==k) return newnums;
        else if (finalIndex<k) return pivotize(newnums,finalIndex,end,k);
        else return pivotize(newnums,beg,finalIndex,k);
    }
}
