package com.bamzy.google;

import java.util.HashMap;
/*
Min Window Substring
Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr,
which will contain only two strings, the first parameter being the string N and the second
parameter being a string K of some characters, and your goal is to determine the smallest
substring of N that contains all the characters in K. For example: if strArr is ["aaabaaddae", "aed"]
then the smallest substring of N that contains the characters a, e, and d is "dae" located at the end
of the string. So for this example your program should return the string dae.

Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N that contains
all of the characters in K is "aabd" which is located at the beginning of the string.
Both parameters will be strings ranging in length from 1 to 50 characters and all of K's characters will exist
somewhere in the string N. Both strings will only contains lowercase alphabetic characters.
Examples
Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
Output: aksfaje
Input: new String[] {"aaffhkksemckelloe", "fhea"}
Output: affhkkse

*/
public class MinWindowSubstring {

    public  String MinWindowSubstring1(String[] strArr) {

        return slidingWindowSolution(strArr);

    }
    public String slidingWindowSolution(String[] strArr ){
        // code goes here

        String N = strArr[0];

//        log("runnung fr: "+ N);
        int n = N.length();
        String K = strArr[1];
        int k = K.length();
        HashMap<Character,Integer> kMap = buildMap(K);
        int start = 0, end = 0,min = Integer.MAX_VALUE;
        String result = "";
        boolean allow = true;
        while(n>=end && start<=n-k){
//            log("----->start:"+start + " end:" + end);
            String sub = N.substring(start,end);
            if (exists(sub,kMap)){
//                log("found");
                if( min > end-start) {
                    min = end-start;
                    result = sub;
                }
                start++;
            } else  {
                if(end<n) end++;
                else start++;
            }

        }
        return result;

    }
    private boolean exists(String src, HashMap<Character,Integer> kMap){
        HashMap<Character,Integer> nMap = buildMap(src);
        for (char key : kMap.keySet()){
            if(!nMap.containsKey(key)) return false;
            if(kMap.get(key)>nMap.get(key)) return false;
        }
        return true;
    }

    private  void log(String str){
        // return;
         System.out.println(str);
    }
    private  HashMap<Character, Integer> buildMap(String src){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<src.length();i++){
            if(!map.containsKey(src.charAt(i))) map.put(src.charAt(i),1);
            else map.put(src.charAt(i),map.get(src.charAt(i))+1);
        }
        return map;
    }

    public static void runTest () {
        // keep this function call here
        MinWindowSubstring mws = new MinWindowSubstring();
        String[] input1 = new String[] {"ahffaksfajeeubsne", "jefaa"};
        System.out.println(mws.MinWindowSubstring1(input1));

        String[] input2 = new String[] {"aaffhkksemckelloe", "fhea"};
        System.out.println(mws.MinWindowSubstring1(input2));

        String[] input3 = new String[] {"aabdccdbcacd", "aad"};
        System.out.println(mws.MinWindowSubstring1(input3));

        String[] input4 = new String[] {"aaffsfsfasfasfasfasfasfacasfafe", "fafsf"};
        System.out.println(mws.MinWindowSubstring1(input4));

        String[] input5 = new String[] {"vvavereveaevafefaef", "vvev"};
        System.out.println(mws.MinWindowSubstring1(input5));

        String[] input6 = new String[] {"aaabaaddae", "aed"};
        System.out.println(mws.MinWindowSubstring1(input6));

        String[] input7 = new String[] {"aaffsfsfasfasfasfasfasfacasfafe", "fafe"};
        System.out.println(mws.MinWindowSubstring1(input7));
    }
}
