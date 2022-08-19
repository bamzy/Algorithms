package com.bamzy;

import java.util.Arrays;

public class WordSearch {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        res = false;
        for (int i = 0 ; i < board.length; i++){
            for (int j =0 ; j < board[i].length ; j++){
                boolean[][] visited = new boolean[board.length][board[i].length];
                search(i,j,board,word,visited);
            }
        }
        return res;
    }

    private void search(int i, int j, char[][] board, String word, boolean[][] visited) {
        if (word.length() == 0){
            res = true;
            return;
        }
        if ( i >= board.length || i<0 || j >= board[i].length || j<0)
            return;
        if (res)
            return;

        if (board[i][j] == word.charAt(0) && !visited[i][j]){
            visited[i][j] = true;
            String substring = word.substring(1);
            var clone = Arrays.copyOf(visited,visited.length);
            search(i+1,j,board, substring, clone);
            search(i-1,j,board,substring, clone);
            search(i,j+1,board,substring, clone);
            search(i,j-1,board,substring, clone);
        }
    }
}
