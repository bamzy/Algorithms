package com.bamzy;

public class WordSearch {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0 ; i < board.length; i++){
            for (int j =0 ; j < board[i].length ; j++){
                search(i,j,board,word);
            }
        }
        return res;
    }

    private void search(int i, int j, char[][] board, String word) {
        if ( i >= board.length || i<0 || j >= board[i].length || j<0)
            return;
        if (res)
            return;
        if (word.length() == 0){
            res = true;
            return;
        }

        if (board[i][j] == word.charAt(0)){
            var substring = word.substring(1);
            search(i+1,j,board, substring);
            search(i-1,j,board,substring);
            search(i,j+1,board,substring);
            search(i,j-1,board,substring);
        }
    }
}
