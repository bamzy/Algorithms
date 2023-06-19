package info.bamzy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ExtraCharactersInString {
    HashMap<String,Integer> map = new HashMap<>();
    public int minExtraChar(String s, String[] dictionary) {
        int size = s.length();
        map.clear();
        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
        recSearch(s,dict,0,0,size);
        return map.get("0|"+size);
    }
    private int recSearch(String s,HashSet<String> dict,int fullMatched,int start,int end){
        if(map.containsKey(start+"|"+end)) {
            return map.get(start+"|"+end);
        }
        String tmp = s.substring(start,end);
        if(dict.contains(tmp) || tmp.length()==0) {
            fullMatched+=tmp.length();
            // minLeft=  Math.min(minLeft,size-fullMatched);
            map.put(start+"|"+end,end-start-fullMatched);
            return end-start - fullMatched;
        }
        int left = end-start;
        for(int i =start+1;i<end;i++){

            left = Math.min(left,recSearch(s,dict,fullMatched,start,i)+recSearch(s,dict,fullMatched,i,end));
        }
        map.put(start+"|"+end,left);
        return left;
    }
}
