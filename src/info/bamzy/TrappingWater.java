package info.bamzy;
/**
 * Given n non-negative integers representing an
 * elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */

import java.util.PriorityQueue;

public class TrappingWater {
    public int trap(int[] height) {
        int len = height.length;
        int[] biggestLeft = new int[len];
        int[] biggestRight = new int[len];
        PriorityQueue<Integer> minq = new PriorityQueue<>((Integer c1, Integer c2) -> Integer.compare(c2, c1));
        for(int i: height) minq.add(i);

        biggestRight[len-1]= 0;

        int max = 0;
        for(int i=0;i<len;i++){
            biggestLeft[i]=max;
            max = Math.max(max,height[i]);
        }
        max = 0;
        for(int i=len-1;i>=0;i--){
            biggestRight[i]=max;
            max = Math.max(max,height[i]);

        }
        int sum = 0;

        for(int i=0;i<len;i++){
            int ch = height[i];
            int min =Math.min(biggestLeft[i],biggestRight[i]);
            if(min>ch) sum+=min-ch;
        }
        return sum;
    }
}
