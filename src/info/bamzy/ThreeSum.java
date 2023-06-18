package info.bamzy;
/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.
Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> findThreeSum(int[] nums) {
        Set<List<Integer>> threeSumSet  = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int k = nums.length-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                }
                else if (sum > 0){
                    k--;
                }
                else if (sum < 0){
                    j++;
                }
            }

        }
        return new ArrayList<>(threeSumSet);
    }


}
