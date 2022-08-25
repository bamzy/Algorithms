package com.bamzy;


import java.util.Arrays;

public class MergeTwoSortedArrays {

  public long[] mergetwosortedarrays(long[] a,long[] b){
      int aLength = a.length;
      int bLength = b.length;
      if(aLength==0) return b;
      if(bLength==0) return a;
      int maxlength = Math.max(aLength, bLength);
      long[] result = new long[aLength+bLength]; //space of O(aLength+bLength)
      int apointer = 0;
      int bpointer = 0;
      int resPointer = 0;
      boolean aCovered = false;
      boolean bCovered = false;
      for (int i=0;i<aLength+bLength;i++){
          if(!aCovered&&(bCovered||a[apointer]<b[bpointer])) {
              result[resPointer] = a[apointer];
              apointer++;
              if(apointer>=aLength)aCovered = true;
          }
          else if(!bCovered&&(aCovered||a[apointer]>=b[bpointer])) {
              result[resPointer] = b[bpointer];
              bpointer++;
              if(bpointer>=bLength)bCovered = true;
          }
          resPointer++;
      }
      return result;
  }
}
