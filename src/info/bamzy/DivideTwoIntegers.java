package info.bamzy;

public class DivideTwoIntegers {
    public int divide1(int dividend, int divisor) {
        double a = dividend, b= divisor;
        if (b == 1) {
            if (b == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return (int)a;
        }
        if (a == -1) {
            if (b == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return (int)(-1 * a);
        }
        int quotient = 0, sign = 1;
        if ((dividend > 0 && divisor <0) || (dividend<0 && divisor > 0))
            sign = -1;
        double dividend1 = Math.abs(a);
        double divisor1 = Math.abs(b);
        while (dividend1>=divisor1){
            dividend1 -= divisor1;
            quotient++;
        }
        return quotient*sign;
    }
    double ans = 0;
    double cur;
    public int divide(int dividend, int divisor) {
        double a = dividend;
        double b = divisor;
        double m =1;
        if(a < 0 && b < 0){
            a = -a;
            b = -b;
        }
        if(a > 0 && b < 0){
            b = -b;
            m = -1;
        }
        if(a < 0 && b > 0){
            a = -a;
            m = -1;
        }
        cur = a;
//        help(b, a, 1);
        help1(b, a, 0);
        ans = ans * m;
        if(ans > Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
        if(ans < Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
        return (int)ans;
    }
    private void help(double divisor, double dividend, double times) {
        if (divisor > dividend) return;
        help(divisor + divisor, dividend, times + times);
        if (divisor <= cur) {
            ans = ans + times;
            cur = cur - divisor;
        }
    }private void help1(double divisor, double dividend, double times) {
        if (divisor > dividend) {
            ans = times;
            return;
        }
        help1(divisor , dividend-divisor, times + 1);
//        if (divisor <= cur) {
//            ans = ans + times;
//            cur = cur - divisor;
//        }
    }
}
