package com.bamzy;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 *
 * Constraints:
 */
public class SQRTx {
    public int mySqrt(int x){
        return solve2(x);
    }
    private int sqrtRec(int res,int base){
        if (res == 1 || res == 0) return res;
        long next = (base+1)*(base+1);
        int prev = base*base;
        if(prev<=res &&  next >= res) return base;
        else if (next< res) return  sqrtRec(res,base+1);
        else  return sqrtRec(res,base-1);

    }
    private int solve(int res){
        int i;

        long lres = res;
        for (i =0;i<=res;i++){
            long left = ((long)i*(long)i);
            long right = ((long)i+1)*((long)i+1);
            if(left <=lres && right > lres) break;
        }
        return i;
    }
    private int solve2(int res){
        long l = 0;
        long r = res;
        long mid;
        long tmp = 0;
        while(l<=r){
            mid = (l+r)/2;
            tmp =mid * mid;
            if ( tmp ==  res ) return (int)mid;
            else if (tmp<res ) l = mid+1;
            else r = mid;

            if(tmp<res && (mid+1)*(mid+1)>res) return (int)mid;

        }

        return -1;
    }
    public static void runTest(){
        SQRTx sqrTx = new SQRTx();
        System.out.println("SQRT:"+sqrTx.solve2(8));
        System.out.println("SQRT:"+sqrTx.solve2(8));
        System.out.println("SQRT:"+sqrTx.solve2(9));
        System.out.println("SQRT:"+sqrTx.solve2(0));
        System.out.println("SQRT:"+sqrTx.solve2(1));
        System.out.println("SQRT:"+sqrTx.solve2(17));
        System.out.println("SQRT:"+sqrTx.solve2(122));

    }
}
