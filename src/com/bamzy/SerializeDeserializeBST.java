package com.bamzy;

import java.util.ArrayList;

public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Integer[] res = new Integer[100];
        String st = "[";
        rec(0,root,res);
        int last=0;
        for (int i=0; i<res.length; i++) {
            if (res[i] != null)
                last = i;
        }
        for (int i =0;i<last;i++){
            if (res[i] == null)
                st = st + "null,";
            else
                st = st + res[i] + ",";
        }
        st= st + res[last] + "]";

        return st;
    }

    private void rec(int i, TreeNode root, Integer[] res) {
        if (root == null)
            return;
        res[i]=root.val;
        rec(2*i+1,root.left,res);
        rec(2*i+2,root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
