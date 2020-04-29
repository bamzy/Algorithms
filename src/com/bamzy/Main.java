package com.bamzy;


public class Main {

    public static void main(String[] args) {
       KClosestPointToOrigin kClosestPointToOrigin = new KClosestPointToOrigin();
//       kClosestPointToOrigin.kClosest(new int[][]{{1,3},{-2,2}},1);
       kClosestPointToOrigin.kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2);
    }
}
