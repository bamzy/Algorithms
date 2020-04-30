package com.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KClosestPointToOrigin {
    // Quick Select based algo - O(n) on average
    // The idea is that if we quickselect by some pivot, on average in linear time
    // we'll reduce the problem to a problem of half the size.
    // O(n) + O(n/2) + ... O(1) = O(2n)
    public int[][] kClosest(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    // The main idea is that we don't have to maintain the order the elements before
    // and after the pivot
    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        int dist = dist(pivot);
        while (l < r) {
            while (l < r && dist(A[r]) >= dist)
                r--;
            A[l] = A[r]; // Move this A[r] to l as it is smaller than pivot
            while (l < r && dist(A[l]) <= dist)
                l++;
            A[r] = A[l]; // Move this A[l] to r as it is larger than pivot
        }
        A[l] = pivot; // Finally put the pivot at l
        return l;
    }

    private int dist(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
