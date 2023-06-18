package info.bamzy.google;

import java.util.HashSet;

/**
 * in a 2D array of zeros and ones removed all the ones that are not immediately connected
 * to either of 4 sides of the matrix or another 1  horizontally or vertically
 * but not diagonally
 *
 *
 * example:
 {{1,1,1,0,0,0},
 {0,0,0,0,1,1},
 {0,1,1,0,1,0},
 {1,0,1,1,1,1},
 {0,1,1,0,0,0},
 {1,1,1,0,1,0}}
 *
 * output:
 * |1,1,1,0,0,0|
 * |1,0,0,0*,0,1|
 * |0,1,1,0,0,0|
 * |1,1,1,0,0*,0|
 */
public class RemoveIslandFromMatrix {

    /**
     * Sudo Code:
     * for i in height{
     *    for j in width {
     *        connected(i,j,input)
     *    }
     * }
     * for( i in height) {
     *      for (j in height) {
     *          if(input[i][j] == 1 and map.cotains(i|j) input[i][j] = 0;
     *      }
     * }
     *
     * connected (i, j , input ){
     *      if(input[i][j] == 0 ) return false;
     *      if(map.contains(i|j) return true;
     *      if(i == 0 || i == input.length-1 ) return true;
     *      if(j==0 || j == input[0].length-1 ) return true;
     *
     *      if(connected(i-1,j) |  connected(i+1,j) | connected(i,j-1) | connected(i,j+1) )
     *          map.add(i|j);
     *          return true;
     *      return false;
     *
     *}
     *Run
     *
     *  }
     **/

    private HashSet<String> set = new HashSet();
    public int[][] resolve(int[][] input){
        HashSet<String> visited = new HashSet<>();
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                visited.clear();
                connected(i,j,input,visited);
            }
        }
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                    if(input[i][j]==1 && !set.contains(i+"|"+j)) input[i][j] = 0;
            }
        }
        return input;

    }
        /*|1,1,1,0,0,0|
        * |0,0,0,0,1,1|
        * |0,1,1,0,1,0|
        * |1,0,1,1,1,1|
        * |0,1,1,0,0,0|
        * |1,1,1,0,1,0|
        * set: [0|0,0|1,0|2]
        * i=1,j=4
        * set: [
        * */
    private boolean connected(int i, int j, int[][] input,HashSet<String> visited) {
            if(visited.contains(i+"|"+j)) return false;
            else visited.add(i+"|"+j);
            if(i<0 || i >= input.length-1 || j < 0 || j>= input[0].length ) return false;
            if(input[i][j] == 0) return false;
            if (this.set.contains(i+"|"+j)) return true;
            if(i ==0 || j == 0 || i == input.length-1 || j == input[0].length-1 ) {
                this.set.add(i+"|"+j);
                return true;
            }
            if( connected(i,j+1,input,visited) || connected(i,j-1,input,visited) || connected(i+1,j,input,visited) || connected(i-1,j,input,visited) ){
                this.set.add(i+"|"+j);
                return true;
            }
            return false;
    }

    public static void runTest(){
        int[][] test1 =  {{1,1,1,0,0,0},
            {0,0,0,0,1,1},
            {0,1,1,0,1,0},
            {0,0,0,1,0,0},
            {0,1,1,0,1,0},
            {1,0,1,1,1,1},
            {0,1,1,0,0,0},
            {1,1,1,0,1,0}};

        int[][] test2 =  {{1,0,0,0,0,0},
                {0,0,0,1,1,1},
                {0,0,0,0,1,0},
                {1,1,0,0,1,0},
                {1,0,0,0,0,0},
                {1,0,0,0,0,1},};

        RemoveIslandFromMatrix rm = new RemoveIslandFromMatrix();
        rm.resolve(test2);
    }

}
