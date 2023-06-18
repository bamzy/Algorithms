package info.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/*
Suppose we have coin denominations of [1, 2, 5] and the total amount is 7.
We can make changes in the following 6 ways:



 */
public class BreakAmountToCoinChange {
    ArrayList<ArrayList<Integer>> results;
    public void solve(int[] coins, int amount){
        HashSet<Integer> coinsHash = new HashSet<>();
        for(int i=0;i< coins.length;i++){
            coinsHash.add(coins[i]);
        }
        for(int i = 0;i<coins.length;i++){
            int adjAmount = amount-coins[i];
            ArrayList<Integer> currCoins = new ArrayList<>();
            currCoins.add(coins[i]);
            solveAmount(coinsHash,coins, adjAmount,currCoins);
        }


    }
    public void solveAmount(HashSet<Integer> coinsHash,int[] coins, int amount,ArrayList<Integer> currCoins){
        if (amount<0) {

            return;
        }
        if (amount==0){
            //print
            System.out.println("Result: "+Arrays.toString(currCoins.toArray()));
            return;

        }
        for(int i = 0 ; i < coinsHash.size();i++){
            ArrayList<Integer> clone = (ArrayList<Integer>) currCoins.clone();
            clone.add(coins[i]);
            solveAmount(coinsHash,coins,amount-coins[i],clone);
        }

    }
}
