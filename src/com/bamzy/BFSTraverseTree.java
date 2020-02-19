package com.bamzy;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BFSTraverseTree {
    int[] traverseTree(Tree<Integer> t) {
        if (t==null)
            return new int[0];
        ArrayList<Integer> results = new ArrayList<>();
        Tree<Integer> temp;
        ArrayList<Tree<Integer>> queue = new ArrayList<>();
        queue.add(t);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i< size; i++) {
                temp = queue.remove(0);
                results.add(temp.value);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        int[] arrayRes = new int[results.size()];
        int counter = 0;
        for (Integer result : results) {
            arrayRes[counter] = result;
            counter++;
        }
        return arrayRes;
    }
}
