package com.bamzy;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return -1 * dividend;
        }
        int quotient = 0, sign = 1;
        if ((dividend > 0 && divisor <0) || (dividend<0 && divisor > 0))
            sign = -1;
        long dividend1 = Math.abs(dividend);
        if (dividend1 == Integer.MIN_VALUE)
            dividend1 = Integer.MAX_VALUE+1;
        long divisor1 = Math.abs(divisor);
        if (divisor1 == Integer.MIN_VALUE)
            divisor1 = Integer.MAX_VALUE+1;
        while (dividend1>=divisor1){
            dividend1 -= divisor1;
            quotient++;
        }
        return quotient*sign;
    }
}
