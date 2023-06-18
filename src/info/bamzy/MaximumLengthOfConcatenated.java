package info.bamzy;

import java.util.Arrays;
import java.util.List;

/*
1239. Maximum Length of a Concatenated String with Unique Characters

You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
Return the maximum possible length of s.
A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.

Example 2:
Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").

Example 3:
Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.


 */
public class MaximumLengthOfConcatenated {
//["un","iq","ue"]
    String sofar = "";
    public int maxLength(List<String> arr) {
        int[] chars = new int[26];
        return rec(arr,0,chars,"");
    }

    public int rec(List<String> arr,int index, int[] chars,String sofarResult) {
        if(index>= arr.size()) return sofarResult.length();
        String currentString = arr.get(index);
        int max = rec(arr,index+1,chars, sofarResult);
        int[] copyChars = Arrays.copyOfRange(chars,0,chars.length);
//        int[] copyChars = chars;
        boolean duplicate= false;
        for(char c : currentString.toCharArray()){
            int arrIndex = c- 'a';
            if (copyChars[arrIndex]>0) {
                duplicate = true;
                break;

            } else copyChars[arrIndex]++;
        }
        if(!duplicate){
            max = Math.max(max,rec(arr,index+1,copyChars,sofarResult+currentString));

        }

        return max;
    }
    public static void runTest(){
        MaximumLengthOfConcatenated maximumLengthOfConcatenated = new MaximumLengthOfConcatenated();
//        List<String> list = new ArrayList<>();
        List<String> list = Arrays.asList("un","iq","ue");
        System.out.println(maximumLengthOfConcatenated.maxLength(list));

        List<String> list1 = Arrays.asList("cha","r","act","ers");
        System.out.println(maximumLengthOfConcatenated.maxLength(list1));

        List<String> list2 = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        System.out.println(maximumLengthOfConcatenated.maxLength(list2));
    }
}