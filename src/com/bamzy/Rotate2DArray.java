package com.bamzy;

public class Rotate2DArray {
    int[][] rotateImage(int[][] a) {
        int n = a.length - 1, tempVal1, tempVal2, tempVal3;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j < n - i ; j++) {
                tempVal1 = a[j][n-i];
                a[j][n-i] = a[i][j];
                tempVal2 = a[n - i][n - j];
                a[n - i][n - j] = tempVal1;
                tempVal3 = a[n-j][i];
                a[n-j][i] = tempVal2;
                a[i][j] = tempVal3;
            }
        }
        return a;
    }
}
