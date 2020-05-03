package com.bamzy;

public class Sqrt {
    private boolean found;
    private long finalRes = 0;
    public int mySqrt(int x) {

        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
         rec(1,x,x);
         return (int)finalRes;

    }

    private void rec(long start, long end,int val) {
        if (start>= end || found)
            return;

        long mid = (end + start) / 2;
        if (mid*mid == val || (val> mid*mid && val<(mid+1)*(mid+1))) {
            finalRes = mid;
            found = true;
            return;
        }
        if (mid*mid > val  )
            rec(start, mid,val);
        else
            rec(mid+1,end,val);

    }
}
