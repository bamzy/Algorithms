package com.bamzy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    List<List<Integer>> res;
    public List<List<Integer>> permute1(int[] nums) {
        res = new ArrayList<>();
        rec1(nums, new ArrayList<>(), new HashSet<Integer>(),0);
        return res;
    }

    private void rec1(int[] nums, ArrayList<Integer> partialResult, HashSet<Integer> used, int index) {
        if (index == nums.length  ) {
            res.add(partialResult);
            return;
        }
        for (int num : nums) {
            if (!used.contains(num)) {
                partialResult.add(num);
                used.add(num);
                rec1(nums, (ArrayList<Integer>) partialResult.clone(), (HashSet<Integer>) used.clone(), index + 1);
                int i = 4;
            }
        }
    }
    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void rec(int start, int[] nums, List<List<Integer>> result){
        int n = nums.length;
        if(start == n){
            List<Integer> list = new ArrayList<>();
            for(int a : nums)
                list.add(a);
            result.add(list);
            return;
        }

        for(int i=start; i<n; i++){
            swap(start, i, nums);
            rec(start+1, nums, result);
            swap(start, i, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0)
            return result;

        rec(0,nums,result);

        return result;
    }
}
