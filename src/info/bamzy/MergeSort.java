package info.bamzy;


import java.util.Arrays;

public class MergeSort {
    private  MergeTwoSortedArrays mrger = new MergeTwoSortedArrays();

  public long[] solveMergeSort(long[] input){
      int len = input.length;
      if(len<=1) return input;
      int middlePosition = len/2;
      return mrger.mergetwosortedarrays(solveMergeSort(Arrays.copyOfRange(input,0,middlePosition)),solveMergeSort(Arrays.copyOfRange(input,middlePosition,input.length)));
  }
}
