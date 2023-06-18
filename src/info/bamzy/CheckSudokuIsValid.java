package info.bamzy;

public class CheckSudokuIsValid {
    public boolean isValidSudoku(char[][] board) {
        // System.out.priCheckSudokuIsValidntln((int)board[0][2]);
        for(int i=0;i<board.length;i++){
            boolean[] rowChecks = new boolean[board.length];
            for(int j=0;j<board[0].length;j++){
                int val = board[i][j];
                if(val==46) continue;
                val = val-48;

                // System.out.println("int val:"+val);
                if(rowChecks[val-1] == true) return false;
                rowChecks[val-1] = true;
            }

        }


        for(int i=0;i<board.length;i++){
            boolean[] colChecks = new boolean[board.length];
            for(int j=0;j<board[0].length;j++){
                int val = board[j][i];
                if(val==46) continue;
                val = val-48;
                if(colChecks[val-1] == true) return false;
                colChecks[val-1] = true;
            }

        }
        for (int i=0;i<board.length;i=i+3){
            for (int j=0;j<board.length;j=j+3){

                if(!checkSquare(board,i,j))return false;
            }
        }
        return true;
    }
    private boolean checkSquare(char[][] board, int row,int col){
        boolean[] tmp = new boolean[9];
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                int value = board[i][j];
                if(value==46) continue;
                value = value-48;
                if(tmp[value-1]==true) return false;
                tmp[value-1]= true;
            }
        }
        return true;
    }
}
