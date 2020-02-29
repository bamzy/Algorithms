package com.bamzy;

public class FibCalculator {
    public int simpleFib(int n){
        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        else
            return simpleFib(n-1) + simpleFib(n-2);
    }

    public int dynamicFibCalculator(int n){
        int[] list = new int[n];
        list[0] = list[1] = 1;
        for (int i=2; i<n ; i++) {
            list[i] = list[i-1] + list[i-2];
        }
        return list[n-1];
    }
}
