package com.bamzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Hint: If any cell of the matrix has a zero we can
record its row and column number using additional memory.
But if you don't want to use extra memory then you can manipulate
the array instead. i.e. simulating exactly what the question says.
*/
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                        rows.add(i);
                        columns.add(j);
                }
            }
        }
        for (Integer column : columns) {
            for (Integer row : rows) {

            }
        }
        for(int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || columns.contains(j))
                    matrix[i][j] = 0;
            }
        }
        return;
    }

    public void inPlaceSetZeroes(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setZeroRowColumn(matrix, i,j);
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }


        return;
    }

    private void setZeroRowColumn(int[][] matrix, int row, int column) {
        for (int i=0; i< matrix[0].length ; i++)
            if (matrix[row][i] != 0)
                matrix[row][i] = Integer.MAX_VALUE;
        for (int i=0; i< matrix.length ; i++)
            if (matrix[i][column] != 0)
                matrix[i][column] = Integer.MAX_VALUE;
        matrix[row][column] = 0;
    }
}
