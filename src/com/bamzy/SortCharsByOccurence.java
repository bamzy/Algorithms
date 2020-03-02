package com.bamzy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/*Sort characters of a string based on the frequency of each character in a descending order*/
public class SortCharsByOccurence {


    class Node  implements  Comparable{
        private Character character;
        private Integer frequency;

        public Character getCharacter() {
            return character;
        }

        public Integer getFrequency() {
            return frequency;
        }

        public Node(Character character, Integer frequency){
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Object o) {
            return ((Node)o).getFrequency() - this.frequency ;
        }
    }
    String sortByFrequency(String input){
        int[] res;

        HashMap<Character, Integer> frequencies = new HashMap<>();
        ArrayList<Node> freqList = new ArrayList<>();
        for (int i=0; i< input.length(); i++) {
            if (frequencies.containsKey(input.charAt(i)))
                frequencies.put(input.charAt(i), frequencies.get(input.charAt(i))+1);
            else
                frequencies.put(input.charAt(i),1);
        }
        frequencies.forEach((k,v) -> freqList.add(new Node(k,v)));
        Collections.sort(freqList);
        char[] result = new char[input.length()];
        int counter = 0;
        for (int i= 0 ; i < freqList.size(); i++ ) {
            for (int j = 0 ; j < freqList.get(i).getFrequency() ; j++) {
                result[counter] = freqList.get(i).getCharacter();
                counter = counter + 1;
            }
        }
        return new String(result);

    }
}
