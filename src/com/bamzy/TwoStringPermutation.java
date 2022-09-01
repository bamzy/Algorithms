package com.bamzy;


import java.util.Arrays;

public class TwoStringPermutation {


  public void findStringPermutation(String src,String dest){

      for (int i=0; i<src.length(); i++){
          if(charspresent(src,i,dest)) System.out.println("found");
      }

  }
    public boolean charspresent(String src, int beginning,String dest){
        if(beginning+dest.length()>src.length()) return false;
        String substr = src.substring(beginning,beginning+dest.length());
        for (int i=0;i<dest.length();i++){
            if(substr.indexOf(dest.charAt(i))==-1) return false;
        }
        return true;
    }
}
