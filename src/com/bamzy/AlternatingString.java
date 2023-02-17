package com.bamzy;

/**
 * 1864. Minimum Number of Swaps to Make the Binary String Alternating
 *
 * Given a binary string s, return the minimum number of character swaps to make it alternating,
 * or -1 if it is impossible.
 *
 * The string is called alternating if no two adjacent characters are equal. For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
 *
 * Any two characters may be swapped, even if they are not adjacent.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "111000"
 * Output: 1
 * Explanation: Swap positions 1 and 4: "111000" -> "101010"
 * The string is now alternating.
 *
 * Example 2:
 * Input: s = "010"
 * Output: 0
 * Explanation: The string is already alternating, no swaps are needed.
 *
 *  Example 3:
 * Input: s = "1110"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] is either '0' or '1'.
 */
//111000 --- 101010 or 010101
public class AlternatingString {
    public int minSwaps(String s) {
        char[] a = s.toCharArray();
        char[] beginWithZero = new char[s.length()];
        char[] beginWithOne = new char[s.length()];

        int zeroCharacter = 0;
        int oneCharacter = 1;
        for (int i =0;i<a.length;i++){
            beginWithZero[i] = (char)(zeroCharacter+'0');
            beginWithOne[i] = (char)(oneCharacter+'0');
            zeroCharacter = (zeroCharacter==1)? 0:1;
            oneCharacter = (oneCharacter==1)? 0:1;



        }
        int first = compare(a,beginWithOne);
        int second = compare(a,beginWithZero);
        if (first==second && first == Integer.MAX_VALUE) return -1;
        return Math.min(first,second);
    }
    private int compare(char[] src, char[] dest){
        int switchCounter = 0;
        int mismatchCounter = 0;
        for (int i =0 ;i < src.length; i++){
            if(src[i]=='0' && dest[i]=='1') {mismatchCounter++; switchCounter++;}
            else if(src[i]=='1' && dest[i]=='0') {mismatchCounter--;};
        }
        if (mismatchCounter != 0 ) return Integer.MAX_VALUE;
        else return switchCounter;
    }
    public static void runTest(){
        AlternatingString as = new AlternatingString();
        System.out.println(as.minSwaps("111000"));
        System.out.println(as.minSwaps("010"));
        System.out.println(as.minSwaps("101"));
        System.out.println(as.minSwaps("1110"));
    }
}
