package com.bamzy;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MergeTwoSortedArrays mrg = new MergeTwoSortedArrays();
        long[] res = mrg.mergetwosortedarrays(new long[]{7},new long[]{1,2,4,6,8,9});
        System.out.println(Arrays.toString(res));

        MergeSort mrgs = new MergeSort();
        long[] input = {99,5,4,1,0,9999999,99997};
        long[] res2 = mrgs.solveMergeSort(input);
        System.out.println(Arrays.toString(res2));
    }
}
