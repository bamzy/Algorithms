package com.bamzy;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        MergeTwoSortedArrays mrg = new MergeTwoSortedArrays();
        long[] res = mrg.mergetwosortedarrays(new long[]{7},new long[]{1,2,4,6,8,9});
        System.out.println(Arrays.toString(res));

        MergeSort mrgs = new MergeSort();
        long[] input = {99,5,4,1,0,9999999,99997};
        long[] res2 = mrgs.solveMergeSort(input);
        System.out.println(Arrays.toString(res2));

        TwoStringPermutation tsp = new TwoStringPermutation();
        tsp.findStringPermutation("abcdeabc","abc");

        BinarySearchLC704 bs = new BinarySearchLC704(new long[]{-1,0,3,5,9,12});
        System.out.println(bs.findIndexBinarySearch(2));

        FindAllPositiveIntegerSolution fapis = new FindAllPositiveIntegerSolution();
        HashMap<Long, ArrayList<FindAllPositiveIntegerSolution.Couple>> tmp = fapis.solve(1,100);

        SortedSet<Long> keys = new TreeSet<>(tmp.keySet());
        for (Long name : keys) {
            String key = name.toString();
            ArrayList<FindAllPositiveIntegerSolution.Couple> couples = tmp.get(name);
            String value = "";
            for (FindAllPositiveIntegerSolution.Couple couple : couples) {
                value = value+ "("+ couple.getA()+ ","+couple.getB()+ ")-";
            }

//            System.out.println(key + " " + value);
            // do something
        }

       StringPermutationRecursive sbr = new StringPermutationRecursive();
        ArrayList<String> result = sbr.solve("abcefg");
        System.out.println(result.size()+result.toString());

        StringBuilder stb = new StringBuilder();
        System.out.println("capacity:"+stb.capacity());
        stb.append("abcdefghijklmnopqr");
        System.out.println("capacity:"+stb.capacity());
        stb.append("123");
        stb.ensureCapacity(77);
        System.out.println("capacity:"+stb.capacity());
        stb.trimToSize();
        System.out.println("capacity:"+stb.capacity());
        System.out.println("value:"+stb.toString());



        NNode root = new NNode(100);
        NNode one = new NNode(50);
        NNode two = new NNode(200);
        NNode three = new NNode(25);
        NNode four = new NNode(45);
        NNode five = new NNode(375);
        root.left = one;
        root.right = two;
        one.left = three;one.right = four;
        two.right = five;

        PrintLevelTree plt = new PrintLevelTree();
        plt.solve(root);

        CheckIfBinaryTreeIsSearchBinaryTree cbtissbt = new CheckIfBinaryTreeIsSearchBinaryTree();
        System.out.println(cbtissbt.check(root));
    }
}
