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
    boolean search(String input) {
        return search(input,this.root);
    }
//    ["d"->"a"->["c"->[g,f]
//               ,"d"->[e,f->h]
//               ]
//   input: "da.f."
//    head : root,  a
//    i     : 0   , 1 ,
    boolean search(String input, TriNode head){
//        TriNode head = root;
        if(input=="" ){
            if (head==null) return true;
            else return false;
        }
        for(int i = 0 ;i < input.length(); i++){
            if(input.charAt(i)=='.'){
                boolean tmpRes = false;
                for(TriNode next: head.nexts){
                    if (next!=null) {
                        String substring = "";
                        if(i<input.length()-1) substring = input.substring(i + 1);
                        tmpRes = tmpRes || search(substring,next);
                        if(tmpRes) head = next;
                    }
                }
                if(!tmpRes) return false;
            } else {
                if (head.nexts[input.charAt(i) - 'a'] == null || head.nexts[input.charAt(i) - 'a'].val != input.charAt(i)) return false;
                head = head.nexts[input.charAt(i) - 'a'];
            }
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
        trie.insert("dac");
        trie.insert("dad");
        trie.insert("dacf");
        trie.insert("dach");
        trie.insert("dadh");
        trie.insert("dadf");
        trie.insert("dadfg");
        boolean res = trie.search("da.f.");

        System.out.println("helloe");
    }
}
