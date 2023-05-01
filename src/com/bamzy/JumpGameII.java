package com.bamzy;

/**
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated
 * such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 */
public class JumpGameII {

    int min = Integer.MAX_VALUE;
    Integer[] minJumpFromGivenIndexToEnd;  //min jump to the end position
    public int jump(int[] nums) {
        minJumpFromGivenIndexToEnd = new Integer[nums.length];
        minJumpFromGivenIndexToEnd[nums.length-1] = 0;
//        if(nums.length==1) return 0;
        return rec(nums,0);
    }
    //[1,2,3]
    public Integer rec(int[] nums, int currentIndex){
        if (currentIndex>=nums.length) return null;
        if(minJumpFromGivenIndexToEnd[currentIndex]!= null) return minJumpFromGivenIndexToEnd[currentIndex];
        if(nums[currentIndex]+currentIndex>=nums.length-1) {
            minJumpFromGivenIndexToEnd[currentIndex] = 1;
            return 1;
        } else {
            Integer tmpMin = Integer.MAX_VALUE;
            for(int i=currentIndex+1; i<=currentIndex+ nums[currentIndex];i++){
                Integer rec = rec(nums, i);
                if(rec== null) continue;
                tmpMin = Math.min(rec + 1, tmpMin);



            }
            if (Math.abs(tmpMin)== Integer.MAX_VALUE) return null;
             minJumpFromGivenIndexToEnd[currentIndex] = Math.abs(tmpMin);
            return tmpMin;
        }

    }
    public static void runTest(){
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{1,2,3}));
        System.out.println(jg.jump(new int[]{2,3,1,1,4}));
        System.out.println(jg.jump(new int[]{2,3,0,1,4}));
        System.out.println(jg.jump(new int[]{0}));
    }
}
