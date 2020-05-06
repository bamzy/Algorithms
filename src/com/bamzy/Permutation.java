package com.bamzy;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        rec(nums, new ArrayList<>(),0,nums.length);
        return res;
    }

    private void rec(int[] nums, List<Integer> partial, int index,int size) {
        if (index >= size -1 ) {
            partial.add(nums[index]);
            return;
        }
        for (int i = 0 ; i < nums.length ; i++)
            if (i != index)
                rec(nums,partial,index+1,size);
    }
}
