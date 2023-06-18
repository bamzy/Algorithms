package info.bamzy;

import java.math.BigInteger;

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
        BigInteger[] leftMultiplications = new BigInteger[nums.length];
        BigInteger[] rightMultiplications = new BigInteger[nums.length];
        BigInteger temp = BigInteger.valueOf(1);
        leftMultiplications[0] = BigInteger.valueOf(1);
        rightMultiplications[nums.length-1] = BigInteger.valueOf(1);
        for (int i=0 ; i<nums.length-1; i++){
            temp = temp.multiply(BigInteger.valueOf(nums[i])) ;
            leftMultiplications[i+1] = temp;
        }
        temp = BigInteger.valueOf(1);
        for (int i=nums.length-1 ; i > 0; i--){
            temp = temp.multiply(BigInteger.valueOf(nums[i])) ;
            rightMultiplications[i-1] = temp;
        }
        temp = BigInteger.valueOf(0);
        for (int i=0;i<nums.length;i++){
            temp = temp.add( (leftMultiplications[i].multiply(rightMultiplications[i]).mod(BigInteger.valueOf(m))));
        }
        return temp.mod(BigInteger.valueOf(m)).intValue();
    }
    int productExceptSelfWithout1(int[] nums, int m){
        int sum = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] * sum + product;
            sum %= m;
            product *= nums[i];
            product %= m;
        }
        return sum;
    }

}
