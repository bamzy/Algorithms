package info.bamzy;

import java.util.HashMap;

/**
 *  *   Given two non-empty arrays of integers, write a function that determines
 *   whether the second array is a subsequence of the first one.
 *
 *  A subsequence of an array is a set of numbers that aren't necessarily adjacent
 *   in the array but that are in the same order as they appear in the array. For
 *   instance, the numbers <span>[1, 3, 4]</span> form a subsequence of the array
 *   <span>[1, 2, 3, 4]</span>, and so do the numbers <span>[2, 4]</span>. Note
 *   that a single number in an array and the array itself are both valid
 *   subsequences of the array.
 *
 * Sample Input
 * array= [5, 1, 22, 25, 6, -1, 8, 10]
 * sequence = [1, 6, -1, 10]
 * Sample Output: true
 *
 */
public class ValidateSubsequentArrays {
    //
    //5=>0, 1=>1, 22=>2, 25=>3, 6=>4, -1 =>5, 8=>6, 10=>7
    //
    //
    //

    public boolean solve(int[] array, int[] sequence){
        HashMap<Integer,Integer> indexes = new HashMap<>();
        for (int i =0 ; i<array.length;i++){
            indexes.put(array[i],i);
        }
        for( int i = 0 ; i< sequence.length-1; i++){
            if (indexes.get(sequence[i])> indexes.get(sequence[i+1])) return false;
        }
        return true;

    }
    public static void runTest(){
        ValidateSubsequentArrays vs = new ValidateSubsequentArrays();
        System.out.println(vs.solve(new int[]{5,1,22,25,6,-1,8,10}, new int[]{1,6,10,-1}));

    }
}
