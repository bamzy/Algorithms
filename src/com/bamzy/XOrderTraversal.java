package com.bamzy;

import java.util.*;

public class XOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root,res);
        return res;
    }
    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<TreeNode> queue = new ArrayList<>();
        boolean directionFlag = false;
        List<Integer> a = new ArrayList<>();
        a.add(root.val);
        result.add(a);
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> t1 = new ArrayList<>();
            if (directionFlag) {
                for (TreeNode val : queue) {
//                    temp.add(val.val);
                    if (val.left!=null) {
                        temp.add(val.left.val);
                        t1.add(val.left);
                    }
                    if (val.right!=null) {
                        t1.add(val.right);
                        temp.add(val.right.val);
                    }
                }
            } else {
                for (int i = queue.size()-1; i>=0; i--){
//                    temp.add(queue.get(i).val);

                    if (queue.get(i).right!=null) {
                        temp.add(queue.get(i).right.val);
                        t1.add(queue.get(i).right);
                    }
                    if (queue.get(i).left!=null) {
                        temp.add(queue.get(i).left.val);
                        t1.add(queue.get(i).left);
                    }
                }
            }
            queue.clear();
            queue.addAll(t1);
            if (!temp.isEmpty())
                result.add(temp);
            directionFlag = !directionFlag;
        }
        return result;
    }

}
