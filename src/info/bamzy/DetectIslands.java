package info.bamzy;

import java.util.*;

public class DetectIslands {

    private void traverseArray(char[][] grid,  int i, int j,boolean[][] seen) {
        if (i < grid.length && i >= 0 && j >= 0 && j < grid[i].length) {
            if (seen[i][j] || grid[i][j] == '0')
                return;
            seen[i][j] = true;
            traverseArray(grid, i - 1, j, seen);
            traverseArray(grid, i + 1, j, seen);
            traverseArray(grid, i, j + 1, seen);
            traverseArray(grid, i, j - 1, seen);
        } else
            return;

    }

    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0)
            return 0;
        boolean [][] seen = new boolean[grid.length][grid[0].length];
        for (int i=0; i< grid.length ; i++){
            for (int j=0; j<grid[i].length; j++ ){
                if (!seen[i][j] && grid[i][j] == '1') {
                    traverseArray(grid, i, j, seen);
                    result++;
                }
            }
        }
        return result;
    }
}
