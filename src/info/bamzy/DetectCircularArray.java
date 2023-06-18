package info.bamzy;

import java.util.HashSet;

public class DetectCircularArray {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0; i< nums.length; i++){
            HashSet<Integer> res = traverse(nums,i);
            if(res!= null && res.size()>1) return true;
        }
        return false;
    }

    private HashSet<Integer> traverse(int[] nums, int start){
        int len = nums.length;
        HashSet<Integer> visitedIndexes = new HashSet<>();
        boolean positive = false;
        int origStart = start;
        if (nums[start]>0) positive=true;
        while(true){
            if( (positive && nums[start]<0) || !positive && nums[start]>0) return null;
            if(visitedIndexes.contains(start)){
                if(start==origStart) return visitedIndexes;
                return null;
            }
            visitedIndexes.add(start);
            start = (start+nums[start])%len;
            if(start<0) start = len+start;
        }

    }

    public static void runTest(){
        DetectCircularArray dca = new DetectCircularArray();
        System.out.println(dca.circularArrayLoop(new int[]{2,-1,1,2,2}));
        System.out.println(dca.circularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));
        System.out.println(dca.circularArrayLoop(new int[]{1,-1,5,1,4}));
        System.out.println(dca.circularArrayLoop(new int[]{-1,-2,-3,-4,-5}));
    }
}
