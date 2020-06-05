package com.bamzy;


import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MovingMedian movingMedian = new MovingMedian();
        System.out.println(movingMedian.ArrayChallenge(new int[]{ 3, 1, 3, 5, 10, 6, 4, 3, 1}));
        System.out.println(movingMedian.ArrayChallenge(new int[]{ 5,2,4,6}));
        System.out.println(movingMedian.ArrayChallenge(new int[]{ 1,2,4,6}));
        System.out.println(movingMedian.ArrayChallenge(new int[]{ 10}));
        System.out.println(movingMedian.ArrayChallenge(new int[]{ 100,1}));

    }
}
