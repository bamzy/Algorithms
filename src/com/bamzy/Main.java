package com.bamzy;

public class Main {

    public static void main(String[] args) {
        DetectIslands detectIslands = new DetectIslands();
//        detectIslands.numIslands(new char[][]{   {1,1,1,1,0}
//                                                ,{1,1,0,1,0}
//                                                ,{1,1,0,0,0}
//                                                ,{0,0,0,0,0}});
        detectIslands.numIslands(new char[][]{   {'1','0','0','0','1'}
                                                ,{'1','0','0','0','1'}
                                                ,{'1','0','0','0','1'}
                                                ,{'1','1','1','1','1'}});
    }
}
