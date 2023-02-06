package com.bamzy;

public class Trie {
    public static class TriNode{
        private int size = 26;
        boolean isLast = false;
        Character val;
        TriNode[] nexts;
        public TriNode(Character val){
            this.val = val;
            nexts = new TriNode[size];
            for (int i =0 ;i < size;i++){
                nexts[i]=null;
            }

        }
    }
    private TriNode root = new TriNode(null);
    void insert(String input){
        if (input.length()==0) return;
        TriNode head = root;
        for(int i = 0; i<input.length();i++){
            int charIndex = input.charAt(i) - 'a';
            if(head.nexts[charIndex]==null){
                head.nexts[charIndex] = new TriNode(input.charAt(i));
                if(i==input.length()-1) head.nexts[charIndex].isLast=true;
            }
            head  = head.nexts[charIndex];
        }
    }

    boolean search(String input){
        TriNode head = root;
        for(int i = 0 ;i < input.length(); i++){
            if(head.nexts[input.charAt(i)-'a']==null || head.nexts[input.charAt(i)-'a'].val!=input.charAt(i)) return false;
            head = head.nexts[input.charAt(i)-'a'];
        }
        if( head.isLast) return true;
        return false;
    }
    public boolean startsWidth(String input){
        TriNode head = root;
        for(int i = 0 ;i < input.length(); i++){
            if(head.nexts[input.charAt(i)-'a']==null || head.nexts[input.charAt(i)-'a'].val!=input.charAt(i)) return false;
            head = head.nexts[input.charAt(i)-'a'];
        }
        return true;
    }

    public static void runTest(){
        Trie trie = new Trie();
        trie.insert("dada");
        trie.insert("dab");
        trie.insert("ease");
        boolean res = trie.search("dac");
        res = trie.search("dad");
        res = trie.startsWidth("dd");
        System.out.println("helloe");
    }
}
