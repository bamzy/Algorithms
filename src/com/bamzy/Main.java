package com.bamzy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SortedSquareArray sortedSquareArray = new SortedSquareArray();
        int[] a = new int[]{-10,-9,-5,-3,1,2,3,4};
        sortedSquareArray.sortSquared(a);
        sortedSquareArray.printResult();
    }
}
