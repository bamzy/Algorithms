package info.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>()
        {@Override
        public int compare(int[] o1,int[] o2){return Integer.compare(o1[0],o2[0]);}
        });
        // System.out.println(Arrays.toString(intervals[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int i =0;i<intervals.length;i++){
            list.add(new int[]{intervals[i][0],intervals[i][1]});
        }

        List<int[]> result = new ArrayList<>();
        int[] next = null;
        while (list.size()>0){
            int[] current = list.get(0);
            if(list.size()>1) next = list.get(1);
            else next = null;
            if ( next != null && current[1]>=next[0]){
                int[] tmp = new int[]{current[0],Math.max(current[1],next[1])};
                list.remove(current);
                list.remove(next);
                list.add(0,tmp);
            } else {
                list.remove(current);
                result.add(current);
            }

        }
        int[][] res = new int[result.size()][2];
        for (int i=0;i<result.size();i++) res[i] = result.get(i);
        return  res;
    }
}
