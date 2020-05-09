package com.bamzy;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        Subset subset = new Subset();
        var subsets = subset.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
