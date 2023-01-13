package com.bamzy;

import java.util.HashMap;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 */
public class DP_tribbonaci {
    public int tribonacci(int n) {
        HashMap<Integer,Integer> res = new HashMap<>();
        res.put(0,0);
        res.put(1,1);
        res.put(2,1);
        return tribonacciRec(n,res);
    }
    private int tribonacciRec(int n, HashMap<Integer,Integer> res){
        if(n<0) return 0;
        if(res.containsKey(n)) return res.get(n);
        else {
            int tmp = tribonacciRec(n-3,res) + tribonacciRec(n-2,res) + tribonacciRec(n-1,res);
            res.put(n,tmp);
            return tmp;
        }

    }
    public static void runTest(){
        DP_tribbonaci dpf = new DP_tribbonaci();
        System.out.println(dpf.tribonacci(25));
        System.out.println(dpf.tribonacci(4));
    }
}
