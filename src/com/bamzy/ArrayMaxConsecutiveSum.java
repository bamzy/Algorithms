package com.bamzy;
/*Given an array of integers, find the maximum possible sum you can
get from one of its contiguous subarrays. The
subarray from which this sum comes must contain at least 1 element.

Example

For inputArray = [-2, 2, 5, -11, 6], the output should be
[0 -2 0 5 -6 0]
arrayMaxConsecutiveSum2(inputArray) = 7.

The contiguous subarray that gives the maximum possible sum is [2, 5],
 with a sum of 7.

In O(inputArray.length) time, you can construct the prefix sum
array prefix, with inputArray + 1 elements. The first element should
be set to zero, and the sum of the all the elements up to and
including i are in prefix[i+1]. The sum of the elements from i to j
will be stored in prefix[j+1] - prefix[i].

Keep track of the minimum prefix sum you have seen so far in a
separate array (i.e. min[i] would be the minimum prefix sum
you get from the first i elements). By passing through the
list once, you can make min[i] an O(inputArray.length) operation.
You are interested in the maximum of prefix[i] and min[i].



 */
public class ArrayMaxConsecutiveSum {
    int arrayMaxConsecutiveSum2(int[] inputArray)
    {


        int size = inputArray.length;

        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + inputArray[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;


    }
}
