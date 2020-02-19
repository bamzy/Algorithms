package com.bamzy;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class TraverseTree {
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

    int[] largestValuesInTreeRows(Tree<Integer> t) {
        if (t==null)
            return new int[0];
        ArrayList<Integer> results = new ArrayList<>();
        Tree<Integer> temp;
        ArrayList<Tree<Integer>> queue = new ArrayList<>();
        queue.add(t);
        while (!queue.isEmpty()){
            int max = -99999;
            int size = queue.size();
            for (int i=0; i< size; i++) {
                temp = queue.remove(0);
                if (temp.value > max)
                    max = temp.value;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            results.add(max);
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
