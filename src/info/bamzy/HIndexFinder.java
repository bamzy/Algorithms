package info.bamzy;

import java.util.Arrays;

/**
 * 274. H-Index
 *
 * Given an array of integers citations where citations[i]
 * is the number of citations a researcher received for their
 * ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * The h-index is defined as the maximum value of h such that
 * the given researcher has published at least h papers that
 * have each been cited at least h times.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 *
 */
public class HIndexFinder {
    public int hIndex(int[] citations) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(citations);
        int start = 0,end=citations.length;
        while(end>=start){
            int midIndex = (start+end)/2;
            if(isValid(midIndex,citations)) {
                start = midIndex+1;
                max = Math.max(max,midIndex);
            }
            else end = midIndex-1;
        }
        return max;
    }
    private boolean isValid(int hindex, int[] cis){
        int count= 0;
        for(int ci: cis){
            if(hindex<=ci) count++;
        }
        if(count>=hindex) return true;
        return false;
    }
}
