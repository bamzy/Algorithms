package com.bamzy;
/*Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid
with numbers in such a way that each column, each row, and each of the nine
3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents
a valid Sudoku puzzle according to the layout rules described above. Note that the
puzzle represented by grid does not have to be solvable.*/
public class Sudoku {
    boolean sudoku2(char[][] grid) {
        int size = grid.length, rowVal , colVal;
        int squareSize = 3;
        for (int i=0 ; i < size ; i++) {
            int []rowDuplicates = new int[size+1];
            int []columnDuplicates = new int[size+1];
            for (int j=0 ; j < size; j++){
                if (grid[i][j] != '.') {
                    rowVal = Integer.parseInt(Character.toString(grid[i][j])) ;
                    rowDuplicates[rowVal] = rowDuplicates[rowVal]+1;
                    if (rowDuplicates[rowVal] > 1)
                        return false;
                }
                if (grid[j][i] != '.') {
                    colVal = Integer.parseInt(Character.toString(grid[j][i])) ;
                    columnDuplicates[colVal] = columnDuplicates[colVal]+1;
                    if (columnDuplicates[colVal] > 1)
                        return false;
                }
            }
        }

        int multiplication = size/squareSize;
        for (int k=0;k<multiplication; k++) {
            for (int l = 0; l < multiplication; l++) {
                int[] squareDuplicates = new int[squareSize*squareSize+1];
                if (checkSquare(grid, squareSize, k, l, squareDuplicates)) return false;
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] grid, int squareSize, int k, int l, int[] squareDuplicates) {
        int colVal;
        for (int i = k*3; i < k*3 + squareSize; i++) {
            for (int j = l*3; j < l*3 + squareSize; j++) {
                if (grid[i][j] != '.') {
                    colVal = Integer.parseInt(Character.toString(grid[i][j]));
                    squareDuplicates[colVal] = squareDuplicates[colVal]+1;
                    if (squareDuplicates[colVal] > 1)
                        return true;
                }
            }
        }
        return false;
    }
}
