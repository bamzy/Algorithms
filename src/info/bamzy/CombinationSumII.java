package info.bamzy;

import java.util.*;

public class CombinationSumII {
    private List<List<Integer>> finalres = new ArrayList<>();
    private HashSet<String> myset = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> res = new ArrayList<>();
        System.out.println(Arrays.toString(candidates));
        rec(candidates,0,0,target,res);
        return finalres;
    }
    private String getKey(List<Integer> res){
        String str = "";
        Collections.sort(res);
        for(int i: res){
            str +=  "|"+i;

        }
        return str;
    }
    //1,1,2,5,6,7,10
    private void rec(int[] candidates,int index,int sum, int target, List<Integer> res){
        if(myset.contains(getKey(res))) return;
        if(index>=candidates.length) return;
        System.out.println("sum: "+ sum + " index: "+ index);
        if(target==sum){
            List<Integer> tmp = new ArrayList<>(res);
            System.out.println(Arrays.toString(res.toArray()));
            myset.add(getKey(tmp));
            finalres.add(tmp);
            return;
        } else if(target<sum) return;
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]+sum<=target){
                res.add(candidates[i]);
                rec(candidates,index+1,sum+candidates[i],target,res);
                res.remove(res.size()-1);
            }
            rec(candidates,index+1,sum,target,res);

        }
    }
}
