package info.bamzy;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> result = new HashMap<>();
        for (int i = 0 ; i < strs.length ; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (result.containsKey(sortedStr)){
                result.get(sortedStr).add(strs[i]);
            } else {
                result.put(sortedStr, new ArrayList());
                result.get(sortedStr).add(strs[i]);
            }
        }
        return new ArrayList(result.values());
    }

}
