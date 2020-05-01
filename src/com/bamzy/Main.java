package com.bamzy;


public class Main {

    public static void main(String[] args) {

       KClosestPointToOrigin kClosestPointToOrigin = new KClosestPointToOrigin();
//       kClosestPointToOrigin.kClosest(new int[][]{{1,3},{-2,2}},1);
        var ints = kClosestPointToOrigin.kClosest(new int[][]{{4, 3}, {3, -2}, {-2, 3}, {1, 2}, {0, 2}, {2, 2}, {0, 0}, {1, 1}}, 2);
    }
}
