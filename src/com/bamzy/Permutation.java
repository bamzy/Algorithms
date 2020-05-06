package com.bamzy;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        rec(nums, new ArrayList<>(),0);
        return res;
    }

    private void rec(int[] nums, List<Integer> partial, int index) {
        partial.add(nums[index]);
        if (index >= nums.length -1 ) {
            res.add(partial);
            return;
        }
        for (int i = 0 ; i < nums.length ; i++)
                rec(nums,new ArrayList<>(partial),index+1);
    }
}
