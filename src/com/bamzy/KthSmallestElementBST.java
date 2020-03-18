package com.bamzy;

import java.util.ArrayList;

public class KthSmallestElementBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        public int kthSmallest(TreeNode root, int k) {
            preOrder(root,k);
            return result;
        }
        int counter = 0;
        int result;
        private void preOrder(TreeNode root,int k) {
            if (root == null || counter>k)
                return;
            preOrder(root.left,k);
            counter++;
            if (counter == k)
                result = root.val;
            preOrder(root.right,k);
        }
}
