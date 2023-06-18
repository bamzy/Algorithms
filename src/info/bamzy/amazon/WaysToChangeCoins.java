package info.bamzy.amazon;

import java.util.HashSet;

/**
 * How many ways can you make change with coins and a total amount
 * Suppose we have coin denominations of [1, 2, 5] and the total amount is 7.
 * We can make changes in the following 6 ways:
 * 1,1,1,1,1,1,1
 * 1,1,1,1,1,2
 * 1,1,1,2,2
 * 1,1,2,2,2
 * 1,1,5
 * 2,5
 */
public class WaysToChangeCoins {

    //[1,3,4] , 7
//   []   [ 1 , 0  , 0  , 0  , 0  , 0  , 0 ]
//   [1]  [ 1 , 1  , 1  , 1  , 1  , 1 , 1 ]
// [1,3]  [ 1 , 1  , 1  , 2  ,   ,   ,  ]
//[1,3,4] [ 1 ,   ,   ,   ,   ,   ,  ]
    public int solve(int[] coins, int target){
        int[][] waysToChangePerAmount  = new int[coins.length+1][target+1];
        for (int i=0;i<=coins.length;i++) {
            for (int amount = 0; amount <= target; amount++) {
                if(i==0 ){
                    waysToChangePerAmount[i][amount]  =0;
                }
                if (amount==0) {
                    waysToChangePerAmount[i][amount] = 1;
                }
            }
        }

        for (int i=1;i<=coins.length;i++) {
            int coin = coins[i-1];
            for (int amount = 1; amount <= target; amount++) {

                if(amount-coin<0) waysToChangePerAmount[i][amount] = waysToChangePerAmount[i-1][amount];
                else waysToChangePerAmount[i][amount] = waysToChangePerAmount[i-1][amount]+waysToChangePerAmount[i][amount-coin];

            }
        }
        return waysToChangePerAmount[coins.length][target];
    }


}
