package com.bamzy;

public class SortColor {
    public void sortColors(int[] nums) {
        int zeroCounter = 0, oneCounter = 0, twoCounter = 0;
        for (int num : nums) {
            if (num == 0)
                zeroCounter++;
            else if (num == 1)
                oneCounter++;
            else if (num == 2)
                twoCounter++;
        }
        for (int i =0; i< nums.length; i++){
            if (i<zeroCounter)
                nums[i] = 0;
            else if (i>= zeroCounter && i < zeroCounter+ oneCounter)
                nums[i] = 1;
            else if (i>= oneCounter+zeroCounter && i<zeroCounter+oneCounter+twoCounter)
                nums[i] = 2;
        }
    }
}
