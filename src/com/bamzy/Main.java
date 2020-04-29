package com.bamzy;


public class Main {

    public static void main(String[] args) {
        CampusBikeAssignment campusBikeAssignment = new CampusBikeAssignment();
//        campusBikeAssignment.matchWorkersToBikes(new int[][]{{0,0},{2,1}},new int[][]{{1,2},{3,3}});
        campusBikeAssignment.matchWorkersToBikes(new int[][]{{0,0},{1,1},{2,0}},new int[][]{{1,0},{2,2},{2,1}});
    }
}
