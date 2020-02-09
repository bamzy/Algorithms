package com.bamzy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SortedSquareArray sortedSquareArray = new SortedSquareArray();
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] a = new int[]{-10,-9,-5,-3,1,2,3,4};
        sortedSquareArray.sortSquared(a);
        sortedSquareArray.printResult();

        int[] b = new int[]{2,1,3,7,4,5,99,17,8};
        System.out.println(longestConsecutiveSequence.getLongestSubsetSize(b));
    }
}
