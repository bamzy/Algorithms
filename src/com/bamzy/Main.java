package com.bamzy;


public class Main {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
//        System.out.println(coinChange.coinChange(new int[]{1,2,5},11));
//        System.out.println(coinChange.coinChange(new int[]{2},3));
        System.out.println(coinChange.coinChange(new int[]{186,419,83,408},6249));
    }
}
