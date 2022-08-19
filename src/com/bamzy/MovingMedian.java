package com.bamzy;

import java.util.Arrays;

public class MovingMedian {

    public  String ArrayChallenge(int[] arr) {
        // Some edge case handling
        if (arr.length == 0 || arr.length == 1)
            return "";
        // Window Size
        int N = arr[0];

        //Final Result
        String mmResult = "" ;
        arr = Arrays.copyOfRange(arr,1,arr.length);
        //Iterate through items exept first one
        for (int i=1; i<= arr.length; i++){
            mmResult = mmResult+","+getMiddle(subarray(arr, i-N,i)) ;
        }

        return mmResult.substring(1);
    }

    private  int[] subarray(int[] input,int startIndex, int endIndex){
        if (startIndex < 0)
            startIndex = 0;
        return Arrays.copyOfRange(input,startIndex,endIndex);
    }
    private  int getMiddle(int[] arr){
        Arrays.sort(arr);
        return (arr.length % 2 == 0)? (arr[arr.length/2]+arr[arr.length/2-1])/2 : arr[arr.length/2];
    }

}
