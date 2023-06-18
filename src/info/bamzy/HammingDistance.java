package info.bamzy;
/*
The Hamming distance between two integers is the
number of positions at which the corresponding bits
are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding
*/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int counter = 0;
        boolean[] st1 = toBaseTwo(x);
        boolean[] st2 = toBaseTwo(y);

        for (int i = 0; i<32; i++){
            if (st1[i]!=st2[i])
                counter++;
        }
        return counter;
    }
    boolean[] toBaseTwo(int input){
        boolean[] res = new boolean[32];
        int index = 31;
//        res[index--] = input % 2 != 1;
        while (input > 0){
            int resid = input%2;
            if (resid != 0)
                res[index] = true;
            index--;
            input = input/2;
        }
        return res;
    }
}
