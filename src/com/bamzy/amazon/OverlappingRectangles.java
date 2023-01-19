package com.bamzy.amazon;

/**
 * An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.
 * Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.
 *
 * Example 1:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Example 3:
 * Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * Output: false
 */
public class OverlappingRectangles {
    public boolean pointInRect(int[] rect,int[] point){
        int left = rect[0];
        int bottom = rect[1];
        int right = rect[2];
        int top = rect[3];
        int x = point[0];
        int y = point[1];
        return x < right && x > left && y < top && y > bottom;
    }
    public int[][] getCorners(int[] rect){
        return new int[][]{{rect[0],rect[1]},{rect[0],rect[3]},{rect[2],rect[3]},{rect[2],rect[1]}};
    }
    public boolean solve(int[] rect1, int[] rect2){
        int[][] corners = getCorners(rect1);
        for (int[] ints : corners) {
            if (pointInRect(rect2, ints)) return true;
        }
        corners = getCorners(rect2);
        for (int[] corner : corners) {
            if (pointInRect(rect1, corner)) return true;
        }
        return false;
    }

    public static void runTest(){
        OverlappingRectangles overlappingRectangles = new OverlappingRectangles();
        System.out.println(overlappingRectangles.solve(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
        System.out.println(overlappingRectangles.solve(new int[]{0,0,1,1}, new int[]{1,0,2,0}));
        System.out.println(overlappingRectangles.solve(new int[]{0,0,1,1}, new int[]{2,2,3,3}));
    }
}
