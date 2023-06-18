package info.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        int rem = 1;
        for (int i = digits.length-1;i>=0;i--){
            int currDigit = digits[i];
            int digSum = currDigit+rem;

            if(digSum/10>0){
                digits[i] = digSum%10;
                rem = digSum/10;
            } else {
                rem = 0;
                digits[i]= digSum;
            }
            if(rem==0) break;

        }
        Integer[] tmp = new Integer[20];
        List<Integer> list = new ArrayList<>();
        for (int i : digits)
        {
            list.add(i);
        }
        if(rem!=0){

            list.add(0,rem);
        }
        return list.stream().mapToInt(i -> i).toArray();

    }



    public static void runTest() {
        PlusOne po = new PlusOne();
        System.out.println(Arrays.toString(po.plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(po.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(po.plusOne(new int[]{9})));
    }
}
