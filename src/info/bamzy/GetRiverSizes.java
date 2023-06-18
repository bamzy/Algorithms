package info.bamzy;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * 
 *   You're given a two-dimensional array (a matrix) of potentially unequal height
 *   and width containing only 0 and 1. Each
 *   0 represents land, and each 1 represents part of a
 *   river. A river consists of any number of 1s that are either
 *   horizontally or vertically adjacent (but not diagonally adjacent). The number
 *   of adjacent 1s forming a river determine its size.
 * 
 * 
 *   Note that a river can twist. In other words, it doesn't have to be a straight
 *   vertical line or a straight horizontal line; it can be L-shaped, for example.
 * 
 * 
 *   Write a function that returns an array of the sizes of all rivers represented
 *   in the input matrix. The sizes don't need to be in any particular order.
 * 
 * Sample Input
 * matrix:
 *  = [
 *   [1, 0, 0, 1, 0],
 *   [1, 0, 1, 0, 0],
 *   [0, 0, 1, 0, 1],
 *   [1, 0, 1, 0, 1],
 *   [1, 0, 1, 1, 0],
 * ]
 * 
 * Sample Output
 * [1, 2, 2, 2, 5] 
 *
 * 
 * 
 *
 *  [
 *      [1,  ,  , 1,  ],
 *      [1,  , 1,  ,  ],
 *      [ ,  , 1,  , 1],
 *      [1,  , 1,  , 1],
 *      [1,  , 1, 1,  ],
 *  ]
 * 
 * 
 */
public class GetRiverSizes {
    HashSet<String> visited = new HashSet<>();
    int currentMax;

    /*
     *   [1, 0, 0, 1, 0],
     *   [1, 0, 1, 0, 0],
     *   [0, 0, 1, 0, 1],
     *   [1, 0, 1, 0, 1],
     *   [1, 0, 1, 1, 0],
    * */
    public Integer[] solve(int[][] map){
        int height = map.length;
        int width = map[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i< height; i++ ){
            for(int j=0 ; j < width;j++){
                if(map[i][j]==1 && !visited.contains(getkey(i,j))){
                    currentMax = 0;
                    dfs(map,i,j,1);
                    result.add(this.currentMax);
                }
            }
        }
        return result.toArray(new Integer[0]);
    }
    private String getkey(int i, int j){
        return i+"|"+j;
    }
    private void dfs(int[][] map, int i, int j, int depth){
        if ( i<0 || j<0 || i>=map.length || j>=map[0].length ) return;
        visited.add(getkey(i,j));
        if(map[i][j]==0) return;
        if(depth>currentMax) currentMax = depth;
        if(!visited.contains(getkey(i+1,j))) dfs(map,i+1,j,depth+1);
        if(!visited.contains(getkey(i-1,j))) dfs(map,i-1,j,depth+1);
        if(!visited.contains(getkey(i,j+1))) dfs(map,i,j+1,depth+1);
        if(!visited.contains(getkey(i,j-1)))dfs(map,i,j-1,depth+1);

    }
    public static void runTest(){
        GetRiverSizes grs = new GetRiverSizes();
        Integer[] res = grs.solve(new int[][]{
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0}
        });
    }

}

