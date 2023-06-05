package com.bamzy.amazon;

/**
 * min ways to breat target into a list of coins with given denominations
 */
public class MinWaysToChangeCoin {
    //[1,3,4,5]
    //[ 0 , 1 , 2 , 1 , 1 , 1 , 2, 2 ]
    public int solve(int[] coins, int target){
        int[] minWays = new int[target+1];
        minWays[0] = 0;
        for (int currentAmount=1;currentAmount<=target;currentAmount++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<coins.length;j++){
                int coin = coins[j];
                int rem = currentAmount - coin;
                if(rem <0) continue;
                if (minWays[rem]==Integer.MAX_VALUE) continue;
                min = Math.min(1+minWays[rem],min);
            }
            minWays[currentAmount] = min;
        }

        return minWays[target]==Integer.MAX_VALUE? -1 : minWays[target];
    }
}
