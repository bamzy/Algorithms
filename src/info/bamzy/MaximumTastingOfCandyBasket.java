package info.bamzy;

import java.util.Arrays;

/*
2517. Maximum Tastiness of Candy Basket

You are given an array of positive integers price where price[i] denotes the price of the ith candy and a positive integer k.

The store sells baskets of k distinct candies. The tastiness of a candy basket is the smallest absolute difference of the prices of any two candies in the basket.

Return the maximum tastiness of a candy basket.



Example 1:

Input: price = [13,5,1,8,21,2], k = 3
Output: 8
Explanation: Choose the candies with the prices [13,5,21].
The tastiness of the candy basket is: min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8.
It can be proven that 8 is the maximum tastiness that can be achieved.
Example 2:

Input: price = [1,3,1], k = 2
Output: 2
Explanation: Choose the candies with the prices [1,3].
The tastiness of the candy basket is: min(|1 - 3|) = min(2) = 2.
It can be proven that 2 is the maximum tastiness that can be achieved.
Example 3:

Input: price = [7,7,7,7], k = 2
Output: 0
Explanation: Choosing any two distinct candies from the candies we have will result in a tastiness of 0.


Constraints:

2 <= k <= price.length <= 105
1 <= price[i] <= 109
 */
public class MaximumTastingOfCandyBasket {
    public int maximumTastiness(int[] price, int k) {
        int minTastiness = 0, maxTastiness = 1_000_000_000,mid=0;
        Arrays.sort(price);
        int max = Integer.MIN_VALUE;
        // maxTastiness = 20;

        while (minTastiness< maxTastiness){

            mid =(maxTastiness+minTastiness)/2;
            // System.out.println(mid);
            if (canbedone(price,mid,k)){
                max = Math.max(mid,max);
                minTastiness = mid+1;
            }
            else {

                maxTastiness = mid;
            }


        }
        return max;

    }
    private boolean canbedone(int[] price,int max,int k){
        int prev = price[0];
        int count = 1;
        for (int i=1;i<price.length;i++){
            if(price[i]-prev>=max) {count++;prev= price[i];}
        }
        if (count>=k) {
            // System.out.println("can be done for"+max);
            return true;
        }
        return false;
    }
    public static void runTest(){
        MaximumTastingOfCandyBasket mtcb = new MaximumTastingOfCandyBasket();
        System.out.println(mtcb.maximumTastiness(new int[]{13,5,1,8,21,2},3));
        System.out.println(mtcb.maximumTastiness(new int[]{7,7,7,7},3));
        System.out.println(mtcb.maximumTastiness(new int[]{1,7},2));
    }
}
