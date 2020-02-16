package com.bamzy;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        SortedSquareArray sortedSquareArray = new SortedSquareArray();
//        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
//        int[] a = new int[]{-10,-9,-5,-3,1,2,3,4};
//        sortedSquareArray.sortSquared(a);
//        sortedSquareArray.printResult();
//
//        int[] b = new int[]{2,1,3,7,4,5,99,17,8};
//        System.out.println(longestConsecutiveSequence.getLongestSubsetSize(b));
//
//        FibCalculator fibCalculator = new FibCalculator();
//
//        long startTime1 = System.currentTimeMillis();
//        System.out.println("Simple Fib is: " + fibCalculator.simpleFib(20));
//        long endTime1 = System.currentTimeMillis();
//        long duration1 = (endTime1 - startTime1);  //Total execution time in milli seconds
//        System.out.println(duration1);
//        System.out.println("Duration:" + duration1);
//
//        long startTime2 = System.currentTimeMillis();
//        System.out.println("DP Fib is " + fibCalculator.dynamicFibCalculator(20));
//        long endTime2 = System.currentTimeMillis();
//        long duration2 = (endTime2 - startTime2);  //Total execution time in milli seconds
//        System.out.println(duration2);
//        System.out.println("Duration:" + duration2);
//
//        StepClimber stepClimber = new StepClimber();
//        int res1 = stepClimber.simplePathCalculator(5);
//        int res2 = stepClimber.advancedPathCalculator(5, new int[]{1,2,3});
//        System.out.println("Step Climber:" + res1 + "   " + res2);
//
//        StringPermutation stringPermutation = new StringPermutation();
//        stringPermutation.permutation("god");


//        LargestPalindrome largestPalindrome = new LargestPalindrome();
//        System.out.println("Palindrome Results: "+ largestPalindrome.findLongestPalindromeBruteForce("abcdeffed"));

//        FirstMinimalDuplicate firstMinimalDuplicate = new FirstMinimalDuplicate();
//        System.out.println("Result is " + firstMinimalDuplicate.firstDuplicateWithArray(new int[]{2,1,3,5,3,2}));
//        System.out.println("Result is " + firstMinimalDuplicate.firstDuplicateWithArray(new int[]{2,2}));
//        System.out.println("Result is " + firstMinimalDuplicate.firstDuplicateWithArray(new int[]{2,4,3,5,1}));


//        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
//        System.out.println("Result is:" + firstNonRepeatingCharacter.findFirstNonRepeatingCharacter("abacabad"));
//        System.out.println("Result is:" + firstNonRepeatingCharacter.findFirstNonRepeatingCharacter("abacabaabacabaf"));


//        int[][] a = new int[][]{{1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}};
//        Rotate2DArray rotate2DArray = new Rotate2DArray();
//        System.out.println("Result is:"+ rotate2DArray.rotateImage(a));
        char[][] grid = {
                {'3', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
        Sudoku sudoku = new Sudoku();
        System.out.println("Result is: " + sudoku.sudoku2(grid));
    }
}
