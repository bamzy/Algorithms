package info.bamzy;
/**
 * 239. Sliding Window Maximum
 * Hard
 * 15.2K
 * 501
 * Companies
 * You are given an array of integers nums, there is a sliding window
 * of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 */

import java.util.PriorityQueue;

public class MaximumSlidingWindow {
    private class Data {
        public int index;
        public int val;
        public Data(int val,int index) {this.index = index; this.val = val;}
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int counter = 0;
        PriorityQueue<Data> pq = new PriorityQueue<>((Data c1, Data c2) -> Integer.compare(c2.val, c1.val));
        for(int i=0;i<k;i++) pq.add(new Data(nums[i],i));

        for(int i=0;i<nums.length-k+1;i++){
            while(pq.peek().index<i) pq.poll();
            res[counter++] = pq.peek().val;
            if(i+k<nums.length) pq.add(new Data(nums[i+k],i+k));

        }
        return res;

    }
}
