package info.bamzy;

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
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        int count = 0;
        bfsQueue.add(root);
        int levelSize = bfsQueue.size();
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        result.add(first);
        boolean flip = true;
        while(!bfsQueue.isEmpty()) {
            TreeNode curr = bfsQueue.poll();
            if(curr.left != null) {
                bfsQueue.offer(curr.left);
            }
            if(curr.right != null) {
                bfsQueue.offer(curr.right);
            }
            count++;
            if(count == levelSize){
                count = 0;
                levelSize = bfsQueue.size();
                List<Integer> currList = new LinkedList<>();
                for(TreeNode current : bfsQueue) {
                    currList.add(current.val);
                }
                if(flip) {
                    Collections.reverse(currList);
                }
                flip = !flip;
                if(!currList.isEmpty()){
                    result.add(currList);
                }
            }
        }
        return result;
    }

}
