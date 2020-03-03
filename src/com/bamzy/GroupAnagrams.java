package com.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GroupAnagrams {
    class Node implements Comparable{
        String sorted;
        String value;

        public Node(String sorted, String value) {
            this.sorted = sorted;
            this.value = value;
        }

        public String getSorted() {
            return sorted;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int compareTo(Object o) {
            if (((Node)o).sorted.equals(this.sorted))
                return 0;
            else return -1;
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> temp = new ArrayList<>();
        List<Node> srca = new ArrayList<>();
        for (int i = 0 ; i < strs.length-1 ; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            srca.add(new Node(sortedStr,strs[i]));

        }
        Collections.sort(srca);
        int counter = -1;
        String oldSorted = "";
        for (int i=0 ; i < srca.size() ; i++){
            if (srca.get(i).getSorted().equals(oldSorted))
                temp.get(counter).add(srca.get(i).getValue());
            else {
                counter++;
                temp.get(counter).add(srca.get(i).getValue());
            }
            oldSorted = srca.get(i).getSorted();
        }
        return temp;
    }

//    private boolean isAnagram(String first, String second) {
//        char[] charFirst = first.toCharArray();
//        char[] charSecond = second.toCharArray();
//        Arrays.sort(charFirst);
//        Arrays.sort(charSecond);
//        if (charFirst.equals(charSecond))
//            return true;
//        return false;
//
//    }
}
