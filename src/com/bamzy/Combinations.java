package com.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    List<String> strs = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        recComb(k,0,1,n,new ArrayList<>());

        return result;
    }
    public void recComb(int k, int size,int currentN,int n,ArrayList<Integer> tmp){
        if (size==k) {
            ArrayList<Integer> myclone = new ArrayList<>(tmp);
            result.add(myclone);
            return;
        }
        if (currentN> n) return;
        recComb(k,size,currentN+1,n,tmp);
        tmp.add(currentN);
        recComb(k,size+1,currentN+1,n,tmp);
        tmp.remove(tmp.size()-1);
    }
    public static void runTest(){
        Combinations cs = new Combinations();
        List<List<Integer>> tmp = cs.combine(4, 2);
    }
}
