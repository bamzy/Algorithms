package com.bamzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SerializeDeserializeBST {
    // Encodes a tree to a single string.


    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        List<Integer> preOrder = preorderTraversal(root);
        List<Integer> inOrder = inorderTraversal(root);
        String st = "[";
        for (int i =0;i<preOrder.size()-1;i++){
                st = st + preOrder.get(i) + ",";
        }
        st= st + preOrder.get(preOrder.size()-1) + "]&[";
        for (int i =0;i<inOrder.size()-1;i++){
            st = st + inOrder.get(i) + ",";
        }
        st= st + inOrder.get(inOrder.size()-1) + "]";
        return st;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] orders = data.split("&");
        String[] arrPre = orders[0].substring(1,orders[0].length()-1).split(",");
        String[] arrIn = orders[1].substring(1,orders[1].length()-1).split(",");
        return constructTreeFromPreOrderInOrder(arrIn,arrPre);
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
        TreeNode tNode = null;
        if (preIndex < preOrder.length)
            tNode = new TreeNode(Integer.parseInt(preOrder[preIndex++]));

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
    }
    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }


}
