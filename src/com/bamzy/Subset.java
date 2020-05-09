package com.bamzy;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        rec(0,nums,res);
        return res;
    }
    public void rec(int start, int[] nums, List<List<Integer>> res){
        if (start == nums.length){
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        }
        for (int i=start ; i< nums.length; i++){
            swap(i,start,nums);
            rec(start+1,nums,res);
            swap(start,i,nums);
        }
    }

    private void swap(int i, int start, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
