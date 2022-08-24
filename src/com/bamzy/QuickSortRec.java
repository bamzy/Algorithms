package com.bamzy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class QuickSortRec {
//    public ArrayList<Integer> solveQuickSort(int[] input,int low,int high){
//        ArrayList<Integer> result = new ArrayList<>();
//        if(high<low) return null;
////        if(high==low) return new ArrayList<Integer>(Arrays.asList(input));
//        ReturnValues position = findpartitionposition(input);
//        if(position==null) return null;
//        int[] less = Arrays.copyOfRange(position.arr, 0, position.partition);
//        ArrayList<Integer> pl = solveQuickSort(less, low, less.length-1);
//        int[] more = Arrays.copyOfRange(position.arr, position.partition + 1, position.arr.length - 1);
//        ArrayList<Integer> pr = solveQuickSort(more,low,more.length-1);
//        result.addAll(pl);
//        result.addAll(pr);
//        return result;
//    }
//    public ReturnValues findpartitionposition(int[] input){
//        int h = input.length-1;
//        if(input.length==1) return new ReturnValues(input,0);
//        ArrayList<Integer> less = new ArrayList<>();
//        ArrayList<Integer> more = new ArrayList<>();
//        HashMap<String, Object> res = new HashMap<>();
//        if(h>=0 ) {
//            int pivot = input[h];
//            for (int i=0;i<h;i++){
//                if(input[i]<pivot) less.add(input[i]);
//                if(input[i]>pivot) more.add(input[i]);
//            }
//            less.add(pivot);
//            int position = less.size()-1;
//            less.addAll(more);
//            return new ReturnValues(less.stream().mapToInt(Integer::intValue).toArray(),position);
//        }
//        return null;
//
//    }
//    private class ReturnValues{
//        public int[] arr;
//        public int partition;
//        public ReturnValues(int[] arr,int partition){
//            this.arr = arr;
//            this.partition = partition;
//        }
//
//    }
    public void solveQuickSortSwap(int[] input,int low,int high){

        if(high<=low) return ;
        int position = findPartitionPositionSwap(input,low,high);


        solveQuickSortSwap(input, low, position-1);
        System.out.println("low:"+low+ " pos:"+(position-1)+" ltmp Result:"+Arrays.toString(input));
        solveQuickSortSwap(input, position+1, high);
        System.out.println("low:"+(position+1)+ " high:"+high+" rtmp Result:"+Arrays.toString(input));


    }
    public int findPartitionPositionSwap(int[] input,int low,int high){
        if(input.length==0) return 0;
        int pivot = input[high];

        int lesscandidateposition = low;
        for (int j=low;j<high;j++){
            if (input[j]>=pivot) {

            } else {
                swap(input,j,lesscandidateposition);
                lesscandidateposition++;
            }

        }
        swap(input,lesscandidateposition,high);
        return lesscandidateposition;
    }
    public void swap(int[] input,int pos1,int pos2){
        int tmp = input[pos1];
        input[pos1]= input[pos2];
        input[pos2]= tmp;
    }
}
