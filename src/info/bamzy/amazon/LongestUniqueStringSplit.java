package info.bamzy.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * Note that the partition is done so that after concatenating all the parts in order,
 * the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 * Constraints:
 * •	1 <= s.length <= 500
 * •	s consists of lowercase English letters.
 */
public class LongestUniqueStringSplit {
    HashMap<Character, int[]> indexes  = new HashMap<>();
    public  int[] solve(String input){
        int[] tmp;
        indexes.clear();
        for(int i = 0; i<input.length(); i++){
            if(indexes.containsKey(input.charAt(i)) ) {
                tmp = indexes.get(input.charAt(i));
                tmp[1] = i;
                indexes.put(input.charAt(i),tmp);
            } else indexes.put(input.charAt(i),new int[]{i,i});
        }
        HashMap<Character,int[]> finished = new HashMap<>();

        int[][] arr = new int[indexes.size()][2];
        int counter = 0;
        for (Character ch: indexes.keySet()){
            arr[counter++] = indexes.get(ch);
        }
        ArrayList<int[]> firstRes = merge(arr, finished);
        int[] res = new int[firstRes.size()];
        counter = 0;
        for (int[] item: firstRes){
            if(item[0]==-1&&item[1]==-1) continue;
            res[counter++] = item[1]-item[0]+1;

        }
        return res;
    }
    private ArrayList<int[]> merge(int[][] indexes, HashMap<Character,int[]> finished){
        ArrayList<int[]> result = new ArrayList<>();
         for(int i =0 ;i<indexes.length-1;i++){

             int[] thisKeyIndex = indexes[i];
             int baseStart = thisKeyIndex[0];
             int baseEnd = thisKeyIndex[1];
             if(baseEnd==-1 && baseStart==-1) continue;
             int tmp =1;
             for (int j=i+1;j<indexes.length;j++){
                 int[] otherKeyIndex = indexes[j];
                 if(otherKeyIndex[0]==-1&&otherKeyIndex[1]==-1) continue;
                 if(overlap(baseStart,baseEnd,otherKeyIndex[0],otherKeyIndex[1])){

                     baseStart = Math.min(otherKeyIndex[0], baseStart);
                     baseEnd = Math.max(otherKeyIndex[1], baseEnd);
                     indexes[i] = new int[]{baseStart, baseEnd};
                     indexes[j] = new int[]{-1,-1};
//                        merge(indexes,finished);

                 }
             }
            result.add(new int[]{baseStart,baseEnd});
//             finished.put(key,new int[] {indexes.get(key)[0],indexes.get(key)[1]});

        }
         return result;
    }
    private boolean overlap(int s1,int e1, int s2, int e2){
        if((s1>=s2 && s1 <= e2) || (e1>=s2 && e1 <= e2) || (s2>=s1 && s2<=e1) || (e2>=s1 && e2<=e1)) return true;
        return false;
    }
    public static void runTest(){
        LongestUniqueStringSplit lu = new LongestUniqueStringSplit();
        int[] res2 = lu.solve("eccbbbbdec");
        int[] res1 = lu.solve("ababcbacadefegdehijhklij");
        int[] res3 = lu.solve("abcdefga");
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }
}
