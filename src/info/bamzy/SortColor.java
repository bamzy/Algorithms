package info.bamzy;

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
    public void sortColors1(int[] nums) {
        int start=0, end = nums.length-1, mid = 0, temp=0;
       while (mid <= end)
            if (nums[mid] == 1){
                mid++;
            } else if (nums[mid] == 2) {
                temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            } else if (nums[mid] == 0){
                temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                start++;
                mid++;
        }

    }
}
