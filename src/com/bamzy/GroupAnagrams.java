package com.bamzy;

import java.util.*;

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

            Node ref = (Node) o;
            return ref.getSorted().compareTo(this.sorted);

        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> temp = new ArrayList<>();
        Map<String, List> result = new HashMap<>();
        List<Node> srca = new ArrayList<>();
        for (int i = 0 ; i < strs.length ; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            srca.add(new Node(sortedStr,strs[i]));

        }
        Collections.sort(srca);
        int counter = -1;
        String oldSorted = null;
        for (int i=0 ; i < srca.size() ; i++){
            if (srca.get(i).getSorted().equals(oldSorted))
                temp.get(counter).add(srca.get(i).getValue());
            else  {
                counter++;
                List<String> tempList = new ArrayList<>();
                temp.add(tempList);
                temp.get(counter).add(srca.get(i).getValue());
            }
            oldSorted = srca.get(i).getSorted();
        }
        return temp;
    }

}
