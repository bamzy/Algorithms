package com.bamzy;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        QuickSortRec qsrec = new QuickSortRec();
        int[] input = {1};
        System.out.println("raw:"+Arrays.toString(input));
        qsrec.solveQuickSortSwap(input,0,input.length-1);
        System.out.println("Final Result:"+Arrays.toString(input));
    }
}
