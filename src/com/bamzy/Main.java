package com.bamzy;

public class Main {
    public static void main(String[] args) {
        int[][] test2 = new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};

        NetworkDelayTime t = new NetworkDelayTime();
        t.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,  2);
        t.networkDelayTime(test2,5,  5);
    }
}
