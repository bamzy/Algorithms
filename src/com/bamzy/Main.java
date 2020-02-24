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


//        char[][] grid = {
//                {'3', '.', '.', '1', '4', '.', '.', '2', '.'},
//                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
//                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
//                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
//                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
//                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
//                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
//        Sudoku sudoku = new Sudoku();
//        System.out.println("Result is: " + sudoku.sudoku2(grid));

//        String[] crypt = {"SEND", "MORE", "MONEY"};
//        String[] crypt2 = {"TEN", "TWO", "ONE"};
//        char[][] solution = {{'O', '0'},
//                {'M', '1'},
//                {'Y', '2'},
//                {'E', '5'},
//                {'N', '6'},
//                {'D', '7'},
//                {'R', '8'},
//                {'S', '9'}};
//        char[][] solution2 = {{'O', '1'},
//                {'T', '0'},
//                {'W', '9'},
//                {'E', '5'},
//                {'N', '4'}};
//        CryptSolution cryptSolution = new CryptSolution();
//        System.out.println("Result is:" + cryptSolution.isCryptSolution(crypt,solution) );
//        System.out.println("Result is:" + cryptSolution.isCryptSolution(crypt2,solution2) );

//        PalindromeLinkedLists palindromeLinkedLists = new PalindromeLinkedLists();
//        ListNode<Integer> a = new ListNode(1);
//        ListNode<Integer> b = new ListNode(2);
//        ListNode<Integer> c = new ListNode(3);
//        ListNode<Integer> d = new ListNode(1);
//        ListNode<Integer> e = new ListNode(2);
//        ListNode<Integer> f = new ListNode(3);
//        a.next=b;b.next=c;c.next=d;d.next=e;e.next=f;
//        System.out.println("Result is: " + palindromeLinkedLists.isListPalindrome(a));

//        HugeLinkedListNumbers hugeLinkedListNumbers = new HugeLinkedListNumbers();
//        ListNode<Integer> a = new ListNode(1);
//        ListNode<Integer> b = new ListNode(9999);
//        ListNode<Integer> c = new ListNode(9999);
//        ListNode<Integer> d = new ListNode(9999);
//        ListNode<Integer> e = new ListNode(9999);
//        ListNode<Integer> f = new ListNode(9999);
//        ListNode<Integer> g = new ListNode(9999);
//        b.next=c;c.next=d;d.next=e;e.next=f;f.next=g;
//        System.out.println("Result is: " + hugeLinkedListNumbers.addTwoHugeNumbers(a,b));


//        MergeLinkedLists mergeLinkedLists = new MergeLinkedLists();
//        ListNode<Integer> a = new ListNode(1);
//        ListNode<Integer> b = new ListNode(1);
//        ListNode<Integer> c = new ListNode(2);
//        ListNode<Integer> d = new ListNode(4);
//        ListNode<Integer> e = new ListNode(0);
//        ListNode<Integer> f = new ListNode(3);
//        ListNode<Integer> g = new ListNode(5);
//        a.next=b;b.next=c;c.next=d;e.next=f;f.next=g;
//        System.out.println("Result is: " + mergeLinkedLists.mergeTwoLinkedLists(a,e));


//        TraverseTree traverseTree = new TraverseTree();
//        Tree<Integer> a = new Tree<>(1);
//        Tree<Integer> b = new Tree<>(2);
//        Tree<Integer> c = new Tree<>(4);
//        a.left = b; a.right=c;
//        Tree<Integer> d = new Tree<>(3);
//        Tree<Integer> e = new Tree<>(5);
//        b.right = d; c.left = e;
//
//        System.out.println("Result is: "+traverseTree.traverseTree(a));


//        TraverseTree traverseTree = new TraverseTree();
//        Tree<Integer> a = new Tree<>(0);
//        Tree<Integer> b = new Tree<>(1);
//        Tree<Integer> c = new Tree<>(3);
//        Tree<Integer> d = new Tree<>(1);
//        Tree<Integer> e = new Tree<>(4);
//        a.left = b;
//
//
//        System.out.println("Result is: "+traverseTree.digitTreeSum(a));

//        FileSystemManager fileSystemManager = new FileSystemManager();
//        fileSystemManager.longestPath("user\n\tpictures\n\tdocuments\n\t\tnotes.txt");
//        System.out.println("Result is:" + fileSystemManager.longestPath("dir\n    file.txt"));

//        ContainsDuplicates containsDuplicates = new ContainsDuplicates();
//        System.out.println(containsDuplicates.containsDuplicates(new int[]{1,2,3,1}));

//        ContainsDuplicates containsDuplicates = new ContainsDuplicates();
//        System.out.println(containsDuplicates.sumOfTwo(new int[]{1,2,3},new int[]{10,20,30,40},42));

//        ContainsDuplicates containsDuplicates = new ContainsDuplicates();
//        System.out.println(containsDuplicates.sumInRange(new int[]{3,0,-2,6,-3,2},new int[][]{{0,2},{2,5},{0,5}}));
//        System.out.println(containsDuplicates.sumInRange(new int[]{-1000},new int[][]{{0,0}}));


        MinSubstringWithAllChars minSubstringWithAllChars = new MinSubstringWithAllChars();
        System.out.println(minSubstringWithAllChars.minSubstringWithAllChars("adobecodebanc","abc"));
    }
}
