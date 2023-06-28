package info.bamzy;

import java.util.ArrayList;
import java.util.List;

public class CombSum {
    int count = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        rec(candidates,0,0,target,res,new ArrayList<>());
        System.out.println(count);
        return res;
    }
    private boolean rec(int[] candidates, int index,int sum,int dest, List<List<Integer>> res,List<Integer> tmpList){
        // System.out.println(sum);
        if(sum==dest) {
            this.count++;
            res.add(new ArrayList<>(tmpList));

            return true;
        }
        if(sum>dest) return true;
        if(index>=candidates.length) return true;
        int thissum = sum;
        List<Integer> clone = new ArrayList<>(tmpList);
        while(thissum<=dest){

            rec(candidates,index+1,thissum,dest,res,clone);

            clone.add(candidates[index]);
            thissum += candidates[index];

        }
        return false;
    }
}
