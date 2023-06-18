package info.bamzy.facebook;

import java.util.ArrayList;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * Constraints:
 * 	· 1 <= nums.length <= 104
 * 	· -104 <= nums[i] <= 104
 * 	· nums is sorted in non-decreasing order.
 *
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 */
public class SquaredArraySort {
    // 16 1 0 9 100
    //lastNeg = 1     0  0
    //first pos = 2   3  4
    //res  = [0, 1,  9  , 16 ,
    public int[] solve(int[] nums){
        ArrayList<Integer> res = new ArrayList<>();
        int lastNgtv = -1;
        for(int i=0;i< nums.length;i++){
            if(nums[i]<0) lastNgtv = i;
            nums[i]= nums[i]*nums[i];
        }
        if (lastNgtv==-1) return nums;
        int firstPstv = lastNgtv+1;
        while(lastNgtv>= 0 || firstPstv<nums.length){

            if(lastNgtv<0 && firstPstv<nums.length){
                res.add(nums[firstPstv++]);

            } else if( lastNgtv>=0 && firstPstv>=nums.length){
                res.add(nums[lastNgtv--]);
            } else {
                if (nums[lastNgtv] > nums[firstPstv]) {
                    res.add(nums[firstPstv++]);
                } else {
                    res.add(nums[lastNgtv--]);
                }
            }
        }
        return res.stream().mapToInt(i->i).toArray();

    }
}
