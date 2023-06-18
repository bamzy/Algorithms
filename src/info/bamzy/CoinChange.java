package info.bamzy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
You are given coins of different denominations and a
total amount of money amount. Write a function to compute
the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of
the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        Arrays.sort(coins);
        res[0] = 0;
        for (int i = 1; i < res.length ; i++) {
            res[i] = findMin(res,i,coins);
        }
        return res[res.length-1];
    }
    public int coinChange1(int[] c, int m) {

        int[] a = new int[m+1];
        for(int i = 1; i<=m; i++){
            int min = m+1;
            for(int j=0; j<c.length; j++){
                if(i>=c[j]){
                    min = Math.min(min, a[i-c[j]] + 1);
                }
            }
            a[i] = min;
        }
        return a[m] == m+1 ? -1 : a[m];
    }

    private int findMin(int[] res, int currentIndex, int[] coins) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (currentIndex-coin >= 0){
                if (currentIndex-coin == 0)
                    min = Math.min(min,1);
                else if (currentIndex-coin > 0 ) {
                    if (res[currentIndex-coin] != -1)
                        min = Math.min(min, res[currentIndex - coin] + 1);

                }
            } else
                break;
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

}
