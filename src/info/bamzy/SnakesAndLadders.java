package info.bamzy;

/**
 * You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
 *
 * You start on square 1 of the board. In each move, starting from square curr, do the following:
 *
 * Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
 * This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
 * If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
 * The game ends when you reach the square n2.
 * A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.
 *
 * Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
 *
 * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
 * Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
 * Output: 4
 * Explanation:
 * In the beginning, you start at square 1 (at row 5, column 0).
 * You decide to move to square 2 and must take the ladder to square 15.
 * You then decide to move to square 17 and must take the snake to square 13.
 * You then decide to move to square 14 and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * This is the lowest possible number of moves to reach the last square, so return 4.
 * Example 2:
 *
 * Input: board = [[-1,-1],[-1,3]]
 * Output: 1
 *
 */
public class SnakesAndLadders {
    Integer[][] cache;
    public int snakesAndLadders(int[][] board) {
        this.cache = new Integer[board.length][board[0].length];
        return rec(board,board.length-1,0);
    }
    int convertToIndex(int[][] board, int i,int j){

        int w = board[0].length;
        int h = board.length;
        boolean startLeft = false;
        int add = 0;
        if(h%2 == 0 && (i+1)%2==0 ) startLeft = true;
        else if (h%2==1 && (i+1)%2==1 ) startLeft = true;
        if(startLeft) add = j+1;
        else add = (w-j);
        return (h-1-i)*w+add;
    }
    int[] convertFromIndex(int[][] board, int index){
        index--;
        int w = board[0].length;
        int h = board.length;
        boolean startLeft = false;
        int add = index%(w);
        int rows = index/(w);
//        if(add==0) rows=rows-1;
        if(h%2 == 0 && rows%2==0 ) startLeft = true;
        else if (h%2==1 && rows%2==1 ) startLeft = true;
        if(startLeft) return new int[]{h-rows-1,add};
        else return new int[]{h-rows-1,w-add-1};
    }

    public static void runTest(){
        SnakesAndLadders snl = new SnakesAndLadders();
        int[][] board1 = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        int[][] board2 = {
                {-1,-1,-1,-1},
                {-1,-1,-1,-1},
                {-1,-1,-1,-1},
                {-1,-1,-1,-1}
        };
        int [] tmp;
        tmp = snl.convertFromIndex(board2,1);
        tmp = snl.convertFromIndex(board2,4);
        tmp = snl.convertFromIndex(board2,7);
        tmp = snl.convertFromIndex(board2,10);
        System.out.println(snl.snakesAndLadders(board2));
        System.out.println(snl.convertToIndex(board1,5,0));
        System.out.println(snl.convertToIndex(board1,4,0));
        System.out.println(snl.convertToIndex(board1,3,0));
    }

    private Integer rec(int[][] board,int i, int j){
        int n = board.length;
        int index = convertToIndex(board, i, j);
        if(index > n*n ) return 1;
        if(i>=board.length||j>=board[0].length) return 1;
        if(cache[i][j] != null) return cache[i][j];
        if(n*n-index<=6 ) {
            cache[i][j]=1;
            return 1;
        }
        if(board[i][j] == -1){
            int min = Integer.MAX_VALUE;
            for (int k=1;k<=6;k++){
                int[] newIndex = convertFromIndex(board,index+k);
                min = Math.min(rec(board,newIndex[0],newIndex[1])+1,min);
            }
            cache[i][j]=min;
            return min;
        } else {
            int[] newIndex = convertFromIndex(board,board[i][j]);
            return rec(board,newIndex[0],newIndex[j]);
        }
    }

}
