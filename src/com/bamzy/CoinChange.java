package com.bamzy;

import java.util.Arrays;
import java.util.Collections;

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
    int minCoins = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        reverse(coins);
        rec(coins,amount,0);
        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }
    public static void reverse(int[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = input[i]; input[i] = input[last - i];
            input[last - i] = temp;
        }
    }



    private void rec(int[] coins, int amount, int coinNum) {
        if (amount == 0)
            minCoins = Math.min(minCoins,coinNum);
        if (amount<0)
            return;
        for (int coin : coins) {
            rec(coins, amount-coin,coinNum+1);
        }
    }
}
