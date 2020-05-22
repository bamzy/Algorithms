package com.bamzy;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        System.out.println(ws.exist(new char[][]{{'A', 'B', 'C', 'E'},{'S','F','E','S'},{'A','D','E','E'}},"ABCESEEEFS"));
        System.out.println(ws.exist(new char[][]{{'A', 'B', 'C', 'E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        System.out.println(ws.exist(new char[][]{{'A', 'B', 'C', 'E'},{'S','F','C','S'},{'A','D','E','E'}},"SEE"));
        System.out.println(ws.exist(new char[][]{{'A', 'B', 'C', 'E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));
        System.out.println(ws.exist(new char[][]{{'A'}},"A"));
    }
}
