package com.bamzy;

import java.math.BigInteger;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i=1;i<=n;i++) {
            res = res.multiply(BigInteger.valueOf(i));

        }
        int counter = 0;
        while (res.mod(BigInteger.valueOf(10)) == BigInteger.valueOf(0)){
            res = res.divide(BigInteger.valueOf(10)) ;
            counter++;
        }
        return counter;

    }

}
