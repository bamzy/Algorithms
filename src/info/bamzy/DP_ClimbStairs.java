package info.bamzy;

import java.util.HashMap;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Example 3:
 *
 * Input: n =4
 * Output: 5
 *  1+1+1+1
 *  1+1+2
 *  1+2+1
 *  2+1+1
 *  2+2
 *
 *  Input n =5
 *  Output:
 *  1+1+1+1+1
 *  1+2+1+1
 *
 */
public class DP_ClimbStairs {
    private HashMap<Integer,Integer> waysMap = new HashMap<>();
    public int climbStairs(int steps){
        int[] a;
        Math.max(1,2);
        return countRec(steps);
    }
    private int countRec (int remainingSteps){
        if(remainingSteps <= 0) return  0;
        if (remainingSteps == 1) return 1;
        if (remainingSteps == 2) return 2;
        if (waysMap.containsKey(remainingSteps) ) return waysMap.get(remainingSteps);
        else {
            int res = countRec(remainingSteps-1) + countRec(remainingSteps-2);
            waysMap.put(remainingSteps,res);
            return res;
        }

    }
    public static void runTest(){
        DP_ClimbStairs dp_climbStairs = new DP_ClimbStairs();
        System.out.println(dp_climbStairs.climbStairs(3));
        System.out.println(dp_climbStairs.climbStairs(4));
        System.out.println(dp_climbStairs.climbStairs(5));
        System.out.println(dp_climbStairs.climbStairs(6));
    }

}
