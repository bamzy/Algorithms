package com.bamzy;

import java.util.LinkedList;

import static java.lang.Math.abs;

public class SortedSquareArray {
    /*Squares and Sorts the input array*/
    int size;
    int[] result;
    public int[] sortSquared(int[] input)
    {
        size = input.length;
        result = new int[size];
        int fp = 0;
        int lp = input.length-1;
        while(true){
            if (fp >= lp)
                break;

            if (abs(input[fp]) > abs(input[lp])) {
                addToResult(input[fp]);
                fp++;
            }
            else {
                addToResult(input[lp]);
                lp--;
            }
        }
        return result;

    }
    private void addToResult(int input){
        result[size-1] = input*input;
        size--;
    }
    public void printResult(){
        for (int i : result) {
            System.out.println(i);
        }
    }
}
