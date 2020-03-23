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

    public TreeNode constructTreeFromPreOrderInOrder(String[] inOrder, String[] preOrder){
        int len = preOrder.length;
        TreeNode root = buildTree(inOrder, preOrder, 0, len - 1);
        return  root;
    }
    static int preIndex = 0;
    TreeNode buildTree(String[] inOrder, String[] preOrder, int inStart, int inEnd)
    {
        if (inStart > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        TreeNode tNode = new TreeNode(Integer.parseInt(preOrder[preIndex++]));

        /* If this node has no children then return */
        if (inStart == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(inOrder, inStart, inEnd, tNode.val);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(inOrder, preOrder, inStart, inIndex - 1);
        tNode.right = buildTree(inOrder, preOrder, inIndex + 1, inEnd);

        return tNode;
    }
    /* Function to find index of value in arr[start...end]
   The function assumes that value is present in in[] */
    int search(String[] arr, int start, int end, int value)
    {
        int i;
        for (i = start; i <= end; i++) {
            if (Integer.parseInt(arr[i]) == value)
                return i;
        }
        return i;
    }

}
