package info.bamzy;

public class SolveSudoku {

    private void solve(char[][] board){
//
        rec(board);
        System.out.println("end");

    }
    public boolean rec(char[][] board){

        for(int i = 0 ; i<board.length;i++){
            for (int j =0; j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for (char val = '1';val<='9';val++){
                        {
                            if(isAllowed(board,val,i,j)){

                                board[i][j] = val;
                                if(rec(board)) return true;
                                else board[i][j]= '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isAllowed(char[][] board,char val,int i, int j){

        /*for(int k = 0; k < 9; k++)
        {
            if(board[i][k] == val) return false;
            if(board[k][j] == val) return false;

            if(board[3*(i/3)+k/3][3*(j/3)+k%3] == val) return false;
        }
        return true;*/


        boolean alreadyExists  = false;
        for(int k = 0 ; k<9; k++ ) {
            if(board[k][j]== val) return false;
        }
        for(int l = 0 ; l<9; l++ ) {
            if(board[i][l]== val) return false;
        }

        int boxRow = i/3;
        int boxCol = j/3;
        for (int k = boxRow*3; k < boxRow*3+3 ; k++)
            for (int l = boxCol*3; l < boxCol*3+3 ; l++)
                if(board[k][l]==val) return false;
        return true;
    }

    public static void runTest(){
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solve(board);
    }
}
