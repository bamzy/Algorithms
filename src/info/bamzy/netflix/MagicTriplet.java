package info.bamzy.netflix;

import java.util.ArrayList;

/**
 * find triplets in an array where their sum is zero
 */
public class MagicTriplet {
    // [-3,2,-1,0,1,2,4]
//    [-4,-3,-1,0,1,2,2,4]
    ArrayList<int[]> solve(int[] input) {
        ArrayList<int[]> result = new ArrayList<>();
        myQuickSort(input,0,input.length-1);
        for(int i=0;i<input.length;i++){
            int l =0,r=input.length-1;
            while(l<r){
                if(l==i) {l++; continue;}
                if(r==i) {r--; continue;}
                int twoSum = input[l] + input[r];
                if(twoSum+input[i]==0){
                    result.add(new int[]{input[r],input[l],input[i]});
                    if(input[r]==input[r-1]) r--;
                    else l++;
                } else if (twoSum+input[i]>0) r--;
                else l++;
            }
        }
        return result;
    }
    public void myQuickSort(int[] input,int start,int end){
       int pi = parition(input,start,end);
       if( pi!=-1){

           myQuickSort(input,pi+1,end);
            myQuickSort(input,start,pi-1);
       }

    }

    private int parition(int[] input,int start,int end){
        if(end <= start) return -1 ;
        int pivot = input[start];
        int beforePivotIndex = start;

        for(int i=start+1; i<= end;i++){
            if(input[i]<pivot){
                beforePivotIndex++;
                swap(input,i,beforePivotIndex);
            }
        }
        swap(input,start,beforePivotIndex);
        return beforePivotIndex;
    }

    private void swap(int[] input, int srcIndex,int destIndex){
        int tmp = input[srcIndex];
        input[srcIndex] = input[destIndex];
        input[destIndex] = tmp;
    }



    public static void runTest(){
        int[] test = new int[]{-4,-3,2,-1,0,1,2,4};
        MagicTriplet mt = new MagicTriplet();
        mt.solve(test);
        System.out.println("hi");
    }
}
