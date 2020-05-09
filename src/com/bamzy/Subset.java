package com.bamzy;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets1(int[] nums) {
        // start with [[]]
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList<Integer>());

        // keep adding each input number to all the sub-set till now
        for(int num : nums ){
            //subsets till now iteration one by one
            int n = ans.size();
            for(int j = 0 ; j<n; j++){
                List<Integer> each = new ArrayList(ans.get(j));
                each.add(num);
                ans.add(each);
            }
        }
        return ans;

    }
    // TC: O(2 ^ N * N)
    // SC: O(2 ^ N * N)
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(subset, nums, 0, res);
        return res;
    }

    private void helper(List<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, nums, i + 1, res);
            subset.remove(subset.size() - 1);
        }

    }

}
