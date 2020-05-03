package com.bamzy;

public class Pow {
    private double powHelp(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = powHelp(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return powHelp(x, n);
    }
}
