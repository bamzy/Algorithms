package com.bamzy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
public class PascalTriangle {
    private Integer[][] cache;
    public List<List<Integer>> generate(int numRows) {
        cache = new Integer[numRows][numRows];
        cache[0][0] = 1;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            populate(numRows-1,i,numRows);
        }
        for(int i=0;i<numRows;i++){

            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j=0;j<numRows;j++){
                if(cache[i][j]!=0 && cache[i][j]!=null) tmp.add(cache[i][j]);
            }
            result.add(tmp);

        }
        return result;

    }
    public int populate(int row,int col,int numRows){
//        if(row==0&&col==0) return 1;
        if( row < 0 || row >= numRows || col < 0 || col >= numRows) return 0;
        if(cache[row][col]!=null) return cache[row][col];
        int res = populate(row-1,col,numRows)+populate(row-1,col-1,numRows);
        cache[row][col] = res;
        return res;

    }
    public static void runTest(){
        PascalTriangle pt = new PascalTriangle();
        List<List<Integer>> res1 = pt.generate(2);
        List<List<Integer>> res2 = pt.generate(3);
        List<List<Integer>> res3 = pt.generate(4);
    }
}
