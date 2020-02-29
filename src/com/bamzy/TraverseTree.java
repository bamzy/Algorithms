package com.bamzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
    LinkedList<Long> results = new LinkedList<>();
    long makeInt(ArrayList<Integer> input){
        String result = "";
        for (Integer digits : input) {
            result = result + digits;
        }
        return Long.parseLong(result);
    }

    void recTraverse(Tree<Integer> t, ArrayList<Integer> numbers){
        numbers.add(t.value);
        ArrayList listCopy1 = new ArrayList(numbers);
        ArrayList listCopy2 = new ArrayList(numbers);
        if (t.left == null && t.right == null){
            results.add(makeInt(numbers));
        } else {
            if (t.left!= null)
                recTraverse(t.left,listCopy1);
            if (t.right!=null)
                recTraverse(t.right,listCopy2);
        }
    }

    long digitTreeSum(Tree<Integer> t) {
        ArrayList<Integer> numbers = new ArrayList<>();
        recTraverse(t, numbers);
        long finalSum=0;
        for (Long result : results) {
            finalSum=finalSum+ result;
        }
        return finalSum;

    }
}
