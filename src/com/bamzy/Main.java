package com.bamzy;


public class Main {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,4}));
        System.out.println(lis.lengthOfLIS(new int[]{10}));
        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
