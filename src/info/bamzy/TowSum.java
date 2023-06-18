package info.bamzy;

import java.util.HashMap;

public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i< nums.length; i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i],i);
            Integer index = map.get(target - nums[i]);
            if ( index != null && index != i ) {
                return new int[]{i, index};
            }
        }
        return null;
    }
}
