package com.bamzy;

import java.util.ArrayList;
import java.util.HashMap;

public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serializeToArray(TreeNode root) {
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
    public TreeNode deserializeFromArray(String data) {
        String[] arr = data.substring(1,data.length()-1).split(",");
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = null;


        for (int i = 0; i<arr.length;i++){
            TreeNode a;
            if (!arr[i].equals("null")) {
                int val = Integer.parseInt(arr[i]);
                if (map.containsKey(i))
                    a = map.get(i);
                else {
                    a = new TreeNode(val);
                    map.put(i,a);
                }

            }
            else
                continue;
            if (2 * i + 1 < arr.length) {
                if (!arr[2*i+1].equals("null") ) {
                    if (map.containsKey(2*i+1))
                        a.left = map.get(2*i+1);
                    else {
                        a.left = new TreeNode(Integer.parseInt(arr[2 * i + 1]));
                        map.put(2 * i + 1, a.left);
                    }
                }
                else a.left = null;
            }
            if (2 * i + 2 < arr.length) {
                if (!arr[2*i+2].equals("null") ) {
                    if (map.containsKey(2*i+2))
                        a.right = map.get(2*i+2);
                    else {
                        a.right = new TreeNode(Integer.parseInt(arr[2 * i + 2]));
                        map.put(2 * i + 2, a.right);
                    }
                }
                else a.right = null;
            }
        }

        return map.get(0);
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
