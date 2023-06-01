package com.bamzy.google;

import java.util.Arrays;
import java.util.HashMap;

/*
given two arrays nums1 & nums2 of integer numbers find a pair of numbers [nums1[i],nums2[j]] where
nums1[i]+nums2[j] is closest to a given target number
 */
public class TwoArraysOneTarget {
    public int findClosestToTarget(int[] nums1, int[] nums2 , int target) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        Integer[][] tmp = new Integer[n][m];
        for (Integer[] row : tmp)
            Arrays.fill(row, Integer.MIN_VALUE);
        HashMap<Integer, int[]> blockedRows = new HashMap<>();
        HashMap<Integer, int[]> blockedColumns = new HashMap<>();
        //nums1: [-1,4,5,7,8] n = 5
        //nums2: [-6,1,2,3,5,7] m = 6
        // j  5
        // i  0
        // sum

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (alreadyBlocked(blockedRows, blockedColumns, i, j)) continue;
                int sum = nums1[i] + nums2[j];
                tmp[i][j] = sum;
                if (sum == target) return sum;
                else if (sum < target) {
                    blockedRows.put(i, new int[]{0, j - 1});
                } else {
                    blockedColumns.put(j,new int[]{i+1,n-1});
                    break;
                }

            }
        }
        int closest = Integer.MAX_VALUE;
        Integer answer=null;
        System.out.println(Arrays.toString(tmp));
        for (int j = m - 1; j > 0; j--) {
            for (int i = 0; i < n; i++) {
                if (alreadyBlocked(blockedRows, blockedColumns, i, j)) continue;
                if(closest>Math.abs(target-tmp[i][j])){
                    closest = Math.abs(target-tmp[i][j]);
                    answer = tmp[i][j];
                }

            }
        }
        return answer;
    }

    private boolean alreadyBlocked(HashMap<Integer, int[]> blockedRows, HashMap<Integer, int[]> blockedColumns, int i, int j) {
        int[] br = blockedRows.get(i);
        int[] bc = blockedColumns.get(j);
        if (br != null && j>=br[0] && j<=br[1] ) return true;
        if (bc != null && i>=bc[0] && j<=bc[1] ) return true;
        return false;
    }
}
