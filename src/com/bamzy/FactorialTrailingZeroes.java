package com.bamzy;

import java.math.BigInteger;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int fiveCounter = 0,temp;
        for (int i=1;i<=n;i++) {
            temp = i;
            while (temp%5==0 ) {
                fiveCounter++;
                temp = temp / 5;
            }
        }
        return fiveCounter;

    }

}
