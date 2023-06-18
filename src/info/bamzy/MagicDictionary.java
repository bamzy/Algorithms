package info.bamzy;

import java.util.Arrays;

/**
 *
 */
public class MagicDictionary {
    boolean found = false;
    public MagicDictionary() {

    }
    Trie mainRoot = null;
    public void buildDict(String[] dictionary) {
        this.mainRoot = new Trie(null);
        for(String s: dictionary){
            buildTrie(s, mainRoot);
        }

    }
    private void buildTrie(String s,Trie root){
        for (int i =0;i<s.length();i++){
            Trie next;
            int c = s.charAt(i)-'a';
            if(root.next[c] == null){
                next = new Trie(s.charAt(i));
                root.next[c]=next;
            }
            root = root.next[c];
        }
        root.last = true;
    }

    public boolean search(String searchWord) {
        this.found = false;
        magicSearch(searchWord, false,this.mainRoot);
        return this.found;

    }
    private void magicSearch(String s, boolean bypassed,Trie thisroot){
        if(this.found) return;
        if (s.length() == 0 &&bypassed && thisroot.last) {
            System.out.println(s + " "+ bypassed + "  "+ thisroot.current + Arrays.toString(thisroot.next) ) ;
            this.found = true;
            return;
        }
        if(s.length()==0) return;
        int c = s.charAt(0)-'a';
        if(thisroot.next[c]!=null){
            magicSearch(s.substring(1),bypassed,thisroot.next[c]);
        } else  if(bypassed) return;
        if(!bypassed) {
            for (int i = 0; i < 26; i++) {
                if (thisroot.next[i] != null && i != c) magicSearch(s.substring(1), true, thisroot.next[i]);
            }
        }

    }

    private class Trie {
        public Character current;
        public boolean last = false;
        public Trie[] next = new Trie[26];
        public Trie(Character c){
            this.current = c;
        }
    }
}

