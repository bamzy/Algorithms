package com.bamzy;


public class Main {

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));
    }
}
