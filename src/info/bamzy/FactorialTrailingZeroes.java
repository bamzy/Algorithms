package info.bamzy;

import java.math.BigInteger;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {

        long x=5;
        long fiveCount=0;
        while(x<=n)
        {
            long q=n/x;
            fiveCount=fiveCount+q;
            x=x*5;
        }
        return (int)fiveCount;

    }

}
