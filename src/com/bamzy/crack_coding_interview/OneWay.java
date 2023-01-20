package com.bamzy.crack_coding_interview;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 * Hints:#23, #97, #130
 */
public class OneWay {
    public boolean isOneAway(String a, String b){

        boolean error = false;
        int aindex = 0;
        int bindex = 0;
        if(Math.abs(a.length()-b.length())>1) return false;
        for (int i=0;i<Math.max(a.length(),b.length());i++) {
            if (a.charAt(aindex)==b.charAt(bindex)) {
                if(aindex<a.length()-1) aindex++;
                if(bindex<b.length()-1) bindex++;
            } else {
                if(error) return false;
                else {
                    error = true;
                    if (a.length() == b.length()+1) aindex++;
                    else if (b.length() == a.length()+1) bindex++;
                    else if (a.length()==b.length()) {
                        if(aindex<a.length()-1) aindex++;
                        if(bindex<b.length()-1) bindex++;
                    }

                }
            }

        }
        return true;

    }
    // pale, ple

    public static void runTest(){
        OneWay ow = new OneWay();

        System.out.println(ow.isOneAway("pale","ple"));
        System.out.println(ow.isOneAway("pales","pale"));
        System.out.println(ow.isOneAway("pale","bale"));
        System.out.println(ow.isOneAway("pale","bake"));
    }

}
