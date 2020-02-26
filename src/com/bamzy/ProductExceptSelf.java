package com.bamzy;

public class ProductExceptSelf {
    int productExceptSelf(int[] nums, int m) {
        int multi = 1;
        int[] fnums = new int[nums.length];
        for (int num : nums) {
            multi = multi * num;
        }
        for (int i=0; i< fnums.length; i++) {
            fnums[i] = (multi/nums[i])%m;
        }
        int sum = 0;
        for (int fnum : fnums) {
            sum += fnum;
        }
        return sum%m;

    }
    int productExceptSelfWithout(int[] nums, int m){
        int[] leftMultiplications = new int[nums.length];
        int[] rightMultiplications = new int[nums.length];
        int allMultiplications,temp = 1;
        leftMultiplications[0] = 1;
        rightMultiplications[nums.length-1] = 1;
        for (int i=0 ; i<nums.length-1; i++){
            temp = temp * nums[i];
            leftMultiplications[i+1] = temp;
        }
        for (int i=nums.length-1 ; i<nums.length-1; i++){
            temp = temp * nums[i];
            leftMultiplications[i+1] = temp;
        }

    }

}
