package info.bamzy;

import java.util.HashSet;
import java.util.Set;

/*
Write an algorithm to determine if a number n is "happy".
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by
the sum of the squares of its digits, and repeat the process
until the number equals 1 (where it will stay), or it loops
endlessly in a cycle which does not include 1. Those numbers for
which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
public class HappyNumber {
    public boolean isHappy(int n) {
        int res = 0;
        boolean cycleFlag = false;
        Set<Integer> keep = new HashSet<>();
        while (!cycleFlag && res !=1 ){
            res = 0;
            while(n > 0){
                int resid = n % 10;
                res += resid*resid;
                n = n/10;
            }
            n = res;
            if (keep.contains(res))
                cycleFlag = true;
            else
                keep.add(res);

        }
        if (cycleFlag)
            return false;
        else if (res == 1)
            return true;
        return false;
    }
}
