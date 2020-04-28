package com.bamzy;

public class MaxScore {
    public int maxScore(String s) {
        int oneCounter = 0;
        int max = 0;
        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == '1')
                oneCounter++;
        }
        int leftPoints = 0, rightPoints = oneCounter;
        for (int i = 0; i< s.length()-1; i++){
            if (s.charAt(i) == '1'){
                rightPoints--;
            }
            if (s.charAt(i) == '0'){
                leftPoints++;
            }
            max = Math.max(leftPoints+rightPoints, max);
        }
        return max;
    }
}
