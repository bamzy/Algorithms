package info.bamzy;

import java.util.*;

/*Given an array nums of n integers and an integer target, are
there elements a, b, c, and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/
public class FourSum {
    public List<List<Integer>> fourSumSlow(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        HashSet<String> hash  = new HashSet<>();
        HashMap<Integer, Integer> counts  = new HashMap<>();
        HashMap<Integer, ArrayList<int[]>> coupleSums  = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int current = nums[i];
            if(!counts.containsKey(current)) counts.put(current,1); else counts.put(current,counts.get(current)+1);
            for(int j=i+1;j<nums.length;j++){
                int thisSum = nums[i]+nums[j];
                if(!coupleSums.containsKey(thisSum)){
                    ArrayList<int[]> tmpList = new ArrayList<>();
                    coupleSums.put(thisSum,tmpList);
                }
                coupleSums.get(thisSum).add(new int[]{nums[i],nums[j]});

            }
        }
        for (int keySum: coupleSums.keySet()){
            if(coupleSums.containsKey(target-keySum)){
                List<int[]> firstList = coupleSums.get(keySum);
                List<int[]> secondList = coupleSums.get(target-keySum);
                findCombinations(hash,result,counts,firstList,secondList);
            }
        }

        return result;
    }
    private void findCombinations(HashSet<String> hash, List<List<Integer>> result,HashMap<Integer, Integer> counts,List<int[]> first,List<int[]> second){
        for(int i=0;i<first.size();i++){
            for(int j=0;j<second.size();j++){
                int[] firstCouple = first.get(i);
                int[] secondCouple = second.get(j);
                Integer[] quad = new Integer[]{firstCouple[0],firstCouple[1],secondCouple[0],secondCouple[1]};
                HashMap<Integer,Integer> quadCounts = new HashMap<>();
                for(int k =0;k<4;k++) if(!quadCounts.containsKey(quad[k])) quadCounts.put(quad[k],1); else quadCounts.put(quad[k],quadCounts.get(quad[k])+1);
                boolean accepted  = true;
                for (int tmpKey: quadCounts.keySet()) if (quadCounts.get(tmpKey)>counts.get(tmpKey)) accepted = false;
                List<Integer> tmpList = Arrays.asList(quad);
                String thisHash = myHash(tmpList);

                if(accepted && !hash.contains(thisHash )) {
                    result.add(tmpList);
                    hash.add(thisHash);
                }
            }
        }
    }
    private String myHash(List<Integer> input){
        Collections.sort(input);
        return input.get(0)+"|"+input.get(1)+"|"+input.get(2)+"|"+input.get(3);

    }


    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> hash  = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int firstNumber = nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                int secondNumber = nums[j];
                int left = j+1;
                int right = nums.length-1;
                while (left< right){
                    long tmpSum = (long)firstNumber+(long)secondNumber+(long)nums[left]+(long)nums[right];
                    if(tmpSum == target){
                        List<Integer> tmpList = Arrays.asList(firstNumber, secondNumber, nums[left], nums[right]);
                        if(!hash.contains(myHash(tmpList))) {
                            result.add(tmpList);
                            hash.add(myHash(tmpList));
                        }
                        left++;
                    } else if (tmpSum<target){
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return result;
    }
    public static void runTest(){
        FourSum fs = new FourSum();
//        List<List<Integer>> tmp = fs.fourSumSlow(new int[]{-2, -1, 0,0,1, 2}, 0);
        List<List<Integer>> tmp0 = fs.fourSumOptimal(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        List<List<Integer>> tmp1 = fs.fourSumOptimal(new int[]{-2, -1, 0,0,1, 2}, 0);
        List<List<Integer>> tmp2 = fs.fourSumOptimal(new int[]{2,2,2,2,2}, 8);

    }
}
