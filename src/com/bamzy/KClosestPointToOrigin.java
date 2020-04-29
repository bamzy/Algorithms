package com.bamzy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KClosestPointToOrigin {
    class Item {
        int index;
        double distnace;

        public Item(int index, double distnace) {
            this.index = index;
            this.distnace = distnace;
        }
    }
    class SortbyroDistance implements Comparator<KClosestPointToOrigin.Item>
    {
        public int compare(KClosestPointToOrigin.Item a, KClosestPointToOrigin.Item b)
        {
            var v = a.distnace - b.distnace;
            if (v > 0)
                return 1;
            else if (v < 0)
                return -1;
            else return 0;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        List<Item> list = new ArrayList<>(points.length);
        for (int i = 0; i< points.length; i++){
            list.add(new Item(i,Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1])));
        }
        list.sort(new SortbyroDistance());
        int[][] res = new int[K][2];
        for (int i=0; i< K;i++) {
            res[i][0] = points[list.get(i).index][0];
            res[i][1] = points[list.get(i).index][1];
        }
        return res;
    }
}
