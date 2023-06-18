package info.bamzy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Example 3:
Input: arr = [0,1,2,4,6,7,9,11], k=4, x=3
Output: [0,1,2,4]

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
 */
public class LC658FindKClosestElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //TODO validation
        if(k<1|| k>arr.length) return null;
        if(arr.length==0||arr.length>104) return null;
        LinkedList<Integer> result = new LinkedList<>();
        int xindex = -1;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==x) xindex =i;
        }
        if (xindex == -1 ) { //x does not exist in arr
            boolean added = false;
            int[] newarr = new int[arr.length+1];
            for (int i=0;i<arr.length;i++){
                if(x<arr[i]) {
                    System.arraycopy(arr,0,newarr,0,i);
                    newarr[i] = x;
                    xindex = i;
                    System.arraycopy(arr,i,newarr,i+1,arr.length-i);
                    added = true;
                    break;

                }
            }
            if(!added){
                System.arraycopy(arr,0,newarr,0,arr.length);
                newarr[arr.length]=x;
                xindex = arr.length;
            }
            arr = newarr;
        }

        int prevIndex = xindex;
        int nextIndex = xindex+1;
        System.out.println(Arrays.toString(arr));
        System.out.println(xindex);
        for (int j=0; j<k; j++){
            if(prevIndex<0 || (nextIndex< arr.length && Math.abs(x-arr[prevIndex]) > Math.abs(x-arr[nextIndex]))  ) {
                result.add(arr[nextIndex]);
                nextIndex++;
            }
            else if (nextIndex>=arr.length || (prevIndex >=0 && Math.abs(x-arr[prevIndex]) <= Math.abs(x-arr[nextIndex])) ) {
                result.addFirst(arr[prevIndex]);
                prevIndex = prevIndex-1;
            }

        }

        return result;
    }


}
