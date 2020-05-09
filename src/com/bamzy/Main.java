package com.bamzy;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        System.out.println(ws.exist(new char[][]{{'A', 'B', 'C', 'E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));
    }
}
