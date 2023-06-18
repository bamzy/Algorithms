package info.bamzy;

import java.util.HashMap;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 */
public class DP_fibbonaci {
    public int fib(int n) {
        HashMap<Integer,Integer> res = new HashMap<>();
        res.put(0,0);
        res.put(1,1);
        return fibRec(n,res);
    }
    private int fibRec(int n, HashMap<Integer,Integer> res){
        if(n<0) return 0;
        if(res.containsKey(n)) return res.get(n);
        else {
            int tmp = fibRec(n-2,res) + fibRec(n-1,res);
            res.put(n,tmp);
            return tmp;
        }

    }
    public static void runTest(){
        DP_fibbonaci dpf = new DP_fibbonaci();
        System.out.println(dpf.fib(17));
    }
}
