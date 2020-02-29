package com.bamzy;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> a = new Tree<>(0);
        Tree<Integer> b = new Tree<>(1);
        Tree<Integer> c = new Tree<>(2);
        Tree<Integer> d = new Tree<>(3);
        Tree<Integer> e = new Tree<>(4);
        a.left = b; a.right = c;  c.left = d; c.right = e;
        ShortestDepthTree shortestDepthTree = new ShortestDepthTree();
        int[] res= shortestDepthTree.findShortestLongestDepthInTree(a);
        System.out.println("Min is: " + res[0] + "\n" +
                "Max is: " + res[1]
        );
    }
}
